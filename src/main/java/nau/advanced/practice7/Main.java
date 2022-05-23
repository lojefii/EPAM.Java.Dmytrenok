package nau.advanced.practice7;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SqlService service = new SqlService();
        service.findRecentFilms();
        service.findActorsInFilm("1917");
        service.findActorsInNFilms(3);
        service.findActorsIsDirectors();
        service.deleteByDate(15);
    }
}