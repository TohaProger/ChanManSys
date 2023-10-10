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

    @Override
    public void addUser(String login, String password) throws SQLException {
        PreparedStatement insert  = connection.prepareStatement("insert into User (UserLogin,UserPassword) values (?,?);");
        insert.setString(1,login);
        insert.setString(2,password);
        insert.executeUpdate();
        findUser(login).getUserID();
    }

    public boolean verification(String userLogin, String userPassword) {
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

    public User findUser(String login) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM User WHERE UserLogin='"+login+"';";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user= Mapping(resultSet);
            }
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignored) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignored) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignored) {
            }
        }
        return user;
    }

    /*public User findUser(String login, String password) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM User WHERE LOGIN='"+login+"' and PASSWORD='"+password+"';";
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user= Mapping(resultSet);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return user;
    }*/

    @Override
    public User Mapping(ResultSet result) throws SQLException {
        ResultSet resultSet = result;
        User user = new User();
        user.setUserID(result.getInt("UserID"));
        user.setUserLogin(resultSet.getString(2));
        user.setUserPassword(resultSet.getString(3));
        return user;
    }
}
