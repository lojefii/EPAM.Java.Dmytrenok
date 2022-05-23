package nau.advanced.practice8.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionPool {
    private static String url;
    private static String user;
    private static String password;
    private List<Connection> connectionPool;;

    public ConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getSize() {
        return connectionPool.size();
    }

    public static Connection create() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public boolean removeConnection(Connection connection) {
        return connectionPool.remove(connection);
    }
}