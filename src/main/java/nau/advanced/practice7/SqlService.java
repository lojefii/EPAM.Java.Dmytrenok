package nau.advanced.practice7;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SqlService {
    private static final String URL = "";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Connection connection;
    private Statement statement;

    public SqlService() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
    }

    public ArrayList<Film> findRecentFilms() throws SQLException {
        ArrayList<Film> films = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM films WHERE YEAR(date) = 2022 OR YEAR(date) = 2021");
        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            Date date = result.getDate(3);
            String country = result.getString(4);
            films.add(new Film(id, name, date, country));
        }
        return films;
    }

    public ArrayList<Person> findActorsInFilm(String filmName) throws SQLException {
        ArrayList<Person> actors = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM people WHERE person_id IN " +
                "(SELECT person_id FROM actors WHERE film_id = " +
                "(SELECT film_id FROM films WHERE name = " + filmName + "))");
        while (result.next()) {
            int id = result.getInt(1);
            String fullname = result.getString(2);
            Date date = result.getDate(3);
            actors.add(new Person(id, fullname, date));
        }
        return actors;
    }

    public ArrayList<Person> findActorsInNFilms(int numberOfFilms) throws SQLException {
        ArrayList<Person> actors = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        ResultSet result = statement.executeQuery("SELECT actor.* FROM actor ac, actors acts " +
                "WHERE actor.actor_id=acts.actor_id GROUP BY acts.actor_id HAVING count(*) > " + numberOfFilms);
        while (result.next()) {
            int id = result.getInt(1);
            String fullName = result.getString(2);
            Date date = result.getDate(3);
            actors.add(new Person(id, fullName, date));
        }
        return actors;
    }

    public ArrayList<Person> findActorsIsDirectors() throws SQLException {
        ArrayList<Person> actors = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM people WHERE person_id IN " +
                "(SELECT person_id FROM actors WHERE person_id IN (SELECT person_id FROM directors))");
        while (result.next()) {
            int id = result.getInt(1);
            String fullName = result.getString(2);
            Date date = result.getDate(3);
            actors.add(new Person(id, fullName, date));
        }
        return actors;
    }

    public void deleteByDate(int years) throws SQLException {
        int year = 2022 - years;
        statement.execute("DELETE FROM films WHERE YEAR(date) = " + year);
    }
}