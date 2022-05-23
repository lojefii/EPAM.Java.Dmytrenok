package nau.advanced.practice8.dao;

import nau.advanced.practice8.entities.Film;
import nau.advanced.practice8.connectionPool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    protected ConnectionPool connectionPool;

    public List<Film> findAll() throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionPool.create();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM film");
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setReleaseYear(resultSet.getInt(3));
                film.setReleaseCounty(resultSet.getString(4));
                films.add(film);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    public Film findFilmById(int id) throws DaoException {
        Film film = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("SELECT * FROM film WHERE film_id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            film.setId(resultSet.getInt(1));
            film.setTitle(resultSet.getString(2));
            film.setReleaseYear(resultSet.getInt(3));
            film.setReleaseCounty(resultSet.getString(4));
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return film;
    }

    public List<Film> findFilmsInThisYear() throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("SELECT * FROM film WHERE release_year>=?");
            statement.setInt(1, 2021);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setReleaseYear(resultSet.getInt(3));
                film.setReleaseCounty(resultSet.getString(4));
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    public boolean addActorToFilm(int filmId, int actorId) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("INSERT INTO film_actor (film_id, actor_id) values (?, ?)");
            statement.setInt(1, filmId);
            statement.setInt(2, actorId);
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }

    public boolean addDirectorToFilm(int filmId, int actorId) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("INSERT INTO film_director (film_id, actor_id) values (?, ?)");
            statement.setInt(1, filmId);
            statement.setInt(2, actorId);
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }
    
    public List<Film> deleteOldFilm(int years) throws DaoException {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("SELECT * FROM film WHERE film.release_year<=?");
            statement.setInt(1, 2022 - years);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setReleaseYear(resultSet.getInt(3));
                film.setReleaseCounty(resultSet.getString(4));
            }
            statement = connection.prepareStatement("DELETE FROM film WHERE film.release_year<=?");
            statement.setInt(1, 2022 - years);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return films;
    }

    public boolean create(Film film) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("INSERT INTO film " +
                    "(title, release_year, release_country) values (?, ?, ?);");
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getReleaseYear());
            statement.setString(3, film.getReleaseCounty());
            count = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        } finally {
            close(statement);
            close(connection);
        }
        return count > 0;
    }
    
    public boolean delete(Film film) throws DaoException {
        int count = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) ConnectionPool.create();
            statement = connection.prepareStatement("DELETE FROM film WHERE title=? " +
                    "AND release_year=? AND release_country=?;");
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getReleaseYear());
            statement.setString(3, film.getReleaseCounty());
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
            statement = connection.prepareStatement("DELETE FROM film WHERE film_id=?");
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