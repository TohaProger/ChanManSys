package com.example.chanmansys.DAO;

// SqlLiteUserDAO включает (implementation) UserDAO interface.
// он включает все SqlLite specific code and SQL statements.
// The client is thus shielded from knowing these implementation details

import com.example.chanmansys.Model.User;

import java.sql.*;

public class SqlLiteUserDAO implements UserDAO {

    // вот это, наверное, неправильная фигня
    Connection connection= SqlLiteDAOFactory.createConnection();

    public SqlLiteUserDAO() {
        //createTable();
        // initialization
    }

    // The following methods can use SqlLiteDAOFactory.createConnection() to get a connection as required

    public User get(String userLogin) {
        return null;
    }

    @Override
    public void create(String userLogin) {

    }

    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    /*public void createTable() {
        try (Connection connection = SqlLiteDAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(
                         "CREATE TABLE IF NOT EXISTS User (UserID INTEGER PRIMARY KEY AUTOINCREMENT, UserLogin TEXT, UserPassword TEXT)"
                 )) {
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public boolean boolUserCreate(String userLogin, String userPassword) {
        try (Connection connection = SqlLiteDAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO User (UserLogin, UserPassword) VALUES (?, ?)")) {
                statement.setString(1, userLogin);
                statement.setString(2, userPassword);
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean boolUserFind(String userLogin, String userPassword) {
        try (Connection connection = SqlLiteDAOFactory.createConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE UserLogin = ? AND UserPassword = ?")) {
                statement.setString(1, userLogin);
                statement.setString(2, userPassword);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Если запись найдена, возвращается true, иначе - false
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verification(String userLogin, String userPassword) {
        /*String sql = "SELECT * FROM User WHERE UserLogin='"+userLogin+"' and UserPassword='"+userPassword+"';";
        System.out.println("Verification "+sql);
        //return true;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return true;*/

        try (Connection connection = SqlLiteDAOFactory.createConnection()) {
            String sql = "SELECT * FROM User WHERE UserLogin='"+userLogin+"' and UserPassword='"+userPassword+"';";
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userLogin);
                statement.setString(2, userPassword);
                ResultSet resultSet = statement.executeQuery();
                System.out.println(resultSet.next());
                return resultSet.next(); // Если запись найдена, возвращается true, иначе - false
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public int createFromLogin(String userLogin){
        // тут типа создание нового пользователя, возврат его id
        return 1;
    }

    @Override
    public User findUser(int userID) {
        return null;
    }
}
