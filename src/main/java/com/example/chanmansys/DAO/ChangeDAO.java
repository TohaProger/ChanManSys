package com.example.chanmansys.DAO;

public interface ChangeDAO {
    Change get(int changeID);

    void create(Change change);

    void update(Change change);



    /*void delete(String userLogin);
    public int insertCustomer(...);
    public boolean deleteCustomer(...);
    public Customer findCustomer(...);
    public boolean updateCustomer(...);
    public RowSet selectCustomersRS(...);
    public Collection selectCustomersTO(...);*/
}


/*import com.example.chanmansys.DAO.Change;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeDAO {
    private static final String DATABASE_URL = "jdbc:sqlite:ChanManSysDB.db"; // Путь к файлу базы данных SQLite

    public ChangeDAO() {
        // Создаем таблицу, если она не существует
        createTable();
    }

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS Change (" +
                             "ChangeID INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "ChangeDescription TEXT," +
                             "ChangePriority TEXT," +
                             "ChangeStatus TEXT," +
                             "ServiceID_FK INTEGER," +  // Внешний ключ
                             "UserID_FK INTEGER" +      // Внешний ключ
                             ")"
             )) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Change> getAllChanges() {
        List<Change> changesList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Change")) {

            while (resultSet.next()) {
                Change change = new Change();
                change.setChangeID(resultSet.getInt("ChangeID"));
                change.setChangeDescription(resultSet.getString("ChangeDescription"));
                change.setChangePriority(resultSet.getString("ChangePriority"));
                change.setChangeStatus(resultSet.getString("ChangeStatus"));
                change.setServiceID_FK(resultSet.getInt("ServiceID_FK"));
                change.setUserID_FK(resultSet.getInt("UserID_FK"));

                changesList.add(change);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return changesList;
    }
}
*/