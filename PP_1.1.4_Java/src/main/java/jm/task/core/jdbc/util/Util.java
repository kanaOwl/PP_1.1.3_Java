package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class Util {

    private static final String hostName = "jdbc:mysql://localhost:3306/test";
    private static final String userName = "root";
    private static final String password = "Ft91Q#hg543%z0";
    private static Connection connection;
    private static SessionFactory sessionFactoryUtil;

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

    public static SessionFactory getSessionFactory() {
        
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "Ft91Q#hg543%z0");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.current_session_context_class", "thread");

            sessionFactoryUtil = configuration.addAnnotatedClass(User.class).buildSessionFactory();
            return sessionFactoryUtil;
    }
}



