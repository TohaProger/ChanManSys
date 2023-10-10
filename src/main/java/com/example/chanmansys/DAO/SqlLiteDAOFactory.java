package com.example.chanmansys.DAO;
// код для подключения бд в SQL LITE

import java.sql.*;

public class SqlLiteDAOFactory extends DAOFactory {

    //public static final String DRIVER = "COM.cloudscape.core.RmiJdbcDriver";
    public static final String DATABASE_URL = "jdbc:sqlite:ChanManSysDB.db"; // Путь к файлу базы данных SQLite

    // method to create database connection
    public static Connection createConnection() {
        // Use DRIVER and DATABASE_URL to create a connection. Recommend connection pool implementation/usage
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS User (" +
                     "UserID INTEGER PRIMARY KEY," +
                     "UserLogin VARCHAR(20)," +
                     "UserPassword VARCHAR(10)" +
                     ");")) {
            System.out.println("Подключение к базе данных успешно");
            statement.execute();

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //System.out.println("Подключение к SQLite не получилось ((");
            e.printStackTrace();
            //return null;
        }
        return null;
    }

    public UserDAO getUserDAO() {
        // SqlLiteUserDAO implements UserDAO
        return new SqlLiteUserDAO();
    }

    public ChangeDAO getChangeDAO() {
        // SqlLiteChangeDAO implements ChangeDAO
        return new SqlLiteChangeDAO();
    }

    @Override
    public ServiceDAO getServiceDAO() {
        return null;
    }

    /*public ServiceDAO getServicesDAO() {
        return new SQLiteServicesDAO();
    }*/
}
