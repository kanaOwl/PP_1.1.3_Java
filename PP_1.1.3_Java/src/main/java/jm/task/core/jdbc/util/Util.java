package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {

    private static final String hostName = "jdbc:mysql://localhost:3306/test";
    private static final String userName = "root";
    private static final String password = "Ft91Q#hg543%z0";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(hostName, userName, password);
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
