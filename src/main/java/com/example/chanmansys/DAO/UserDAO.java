package com.example.chanmansys.DAO;

// Interface that all UserDAOs must support

import com.example.chanmansys.Model.User;

import java.sql.SQLException;

public interface UserDAO {
    User get(String userLogin);
    void create(String userLogin);
    void update(User user);
    void delete(User user);

    boolean boolUserCreate(String userLogin, String userPassword);
    boolean boolUserFind(String userLogin, String userPassword);

    int createFromLogin(String userLogin);

    User findUser(int userID);

    boolean verification(String userLogin, String userPassword) throws SQLException;

    //void delete(String userLogin);
    /*public int insertCustomer(...);
    public boolean deleteCustomer(...);
    public Customer findCustomer(...);
    public boolean updateCustomer(...);
    public RowSet selectCustomersRS(...);
    public Collection selectCustomersTO(...);*/
    //public User findUserByID(int userID);

}
