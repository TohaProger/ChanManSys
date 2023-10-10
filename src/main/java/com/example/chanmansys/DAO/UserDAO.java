package com.example.chanmansys.DAO;

// Interface that all UserDAOs must support

import com.example.chanmansys.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс Dao таблицы User для работы с БД
 */
public interface UserDAO {
    User get(String userLogin);
    void create(String userLogin);
    void update(User user);
    void delete(User user);

    void addUser(String userLogin, String userPassword) throws SQLException;

    int createFromLogin(String userLogin);

    User findUser(String userLogin) throws SQLException;

    boolean verification(String userLogin, String userPassword) throws SQLException;

    /**
     * Маппинг результата апроса
     * @param result результат
     * @return  Users
     * @throws SQLException исключение при работе с SQL-запросами
     */
    User Mapping(ResultSet result) throws SQLException;

    //void delete(String userLogin);
    /*public int insertCustomer(...);
    public boolean deleteCustomer(...);
    public Customer findCustomer(...);
    public boolean updateCustomer(...);
    public RowSet selectCustomersRS(...);
    public Collection selectCustomersTO(...);*/
    //public User findUserByID(int userID);

}
