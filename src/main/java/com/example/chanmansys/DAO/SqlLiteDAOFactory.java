package com.example.chanmansys.DAO;
// код для подключения бд в SQL LITE

import java.sql.*;

public class SqlLiteDAOFactory extends DAOFactory {

    public static final String DRIVER =
            "COM.cloudscape.core.RmiJdbcDriver";
    public static final String DATABASE_URL = "jdbc:sqlite:ChanManSysDB.db"; // Путь к файлу базы данных SQLite

    // method to create Cloudscape connections
    public static Connection createConnection() {
        // Use DRIVER and DATABASE_URL to create a connection. Recommend connection pool implementation/usage
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS User ()")) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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

    /*public OrderDAO getOrderDAO() {
        // CloudscapeOrderDAO implements OrderDAO
        return new CloudscapeOrderDAO();
    }*/
}
