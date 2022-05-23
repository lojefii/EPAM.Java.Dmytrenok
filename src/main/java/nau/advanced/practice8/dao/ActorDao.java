package nau.advanced.practice8.dao;

import nau.advanced.practice8.entities.Actor;
import nau.advanced.practice8.entities.Film;
import nau.advanced.practice8.connectionPool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    protected ConnectionPool connectionPool;

    public List<Actor> findAll() throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");
            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));
                actor.setBirthYear(resultSet.getInt(4));
                actors.add(actor);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    public Actor findActorById(int id) throws DaoException {
        Actor actor = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("SELECT * FROM actor WHERE actor_id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            actor.setId(resultSet.getInt(1));
            actor.setFirstName(resultSet.getString(2));
            actor.setLastName(resultSet.getString(3));
            actor.setBirthYear(resultSet.getInt(4));
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actor;
    }

    public List<Actor> findActorsInFilm(Film film) throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("SELECT * FROM people WHERE person_id IN " +
                    "(SELECT person_id FROM actors WHERE film_id=" +
                    "(SELECT film_id FROM films WHERE title=" + film.getTitle() + "))");
            statement.setString(1, film.getTitle());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));
                actor.setBirthYear(resultSet.getInt(4));
                actors.add(actor);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    public List<Actor> findActorsInNFilms(int numberOfFilms) throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.create();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT actor.* FROM actor ac, actors acts " +
                    "WHERE actor.actor_id=acts.actor_id GROUP BY acts.actor_id HAVING count(*) > " + numberOfFilms);
            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));
                actor.setBirthYear(resultSet.getInt(4));
                actors.add(actor);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    public List<Actor> findActorsIsDirector() throws DaoException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people WHERE person_id IN " +
                    "(SELECT person_id FROM actors WHERE person_id IN (SELECT person_id FROM directors))");
            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));
                actor.setBirthYear(resultSet.getInt(4));
                if (!actors.contains(actor)) {
                    actors.add(actor);
                }
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    public boolean create(Actor actor) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("INSERT INTO actor " +
                    "(first_name, last_name, birth_year) values (?, ?, ?);");
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());
            statement.setInt(3, actor.getBirthYear());
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }

    public boolean delete(Actor actor) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("DELETE FROM actor WHERE first_name=? " +
                    "and last_name=? and birth_year=?;");
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());
            statement.setInt(3, actor.getBirthYear());
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }

    public boolean delete(int id) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("DELETE FROM actor WHERE actor_id=?");
            statement.setInt(1, id);
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }

    public void close(Statement statement) throws DaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public void close(Connection connection) {
        if (connection != null) {
            connectionPool.removeConnection(connection);
        }
    }
}
