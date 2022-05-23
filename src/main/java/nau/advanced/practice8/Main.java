package nau.advanced.practice8;

import nau.advanced.practice8.connectionPool.ConnectionPool;
import nau.advanced.practice8.dao.ActorDao;
import nau.advanced.practice8.dao.DaoException;
import nau.advanced.practice8.dao.FilmDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, DaoException {
        ConnectionPool connectionPool = new ConnectionPool("jdbc:mysql://localhost:8808/video_library",
                "root", "password");
        ActorDao actorDao = new ActorDao();
        FilmDao filmDao = new FilmDao();

        actorDao.findActorsInNFilms(3).forEach(System.out::println);
        actorDao.findAll().forEach(System.out::println);
        filmDao.deleteOldFilm(20).forEach(System.out::println);
        filmDao.addDirectorToFilm(2, 4);
    }
}
