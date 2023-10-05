package com.example.chanmansys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserDAO {
    private static final String DATABASE_URL = "jdbc:sqlite:ChanManSysDB.db"; // Путь к файлу базы данных SQLite

    public UserDAO() {
        // Создаем таблицу пользователей, если она не существует
        createTable();
    }

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS Users (UserID INTEGER PRIMARY KEY AUTOINCREMENT, UserLogin TEXT, UserPassword TEXT)"
             )) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createUser(String userLogin, String userPassword) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (UserLogin, UserPassword) VALUES (?, ?)")) {
            statement.setString(1, userLogin);
            statement.setString(2, userPassword);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUser(String userLogin, String userPassword) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE UserLogin = ? AND UserPassword = ?")) {
            statement.setString(1, userLogin);
            statement.setString(2, userPassword);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Если запись найдена, возвращается true, иначе - false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
