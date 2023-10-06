package com.example.chanmansys.DAO;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements java.io.Serializable {
    // member variables
    private SimpleIntegerProperty UserID;
    SimpleStringProperty UserLogin;
    SimpleStringProperty UserPassword;
    //private String UserName;

    // getter and setter methods...
    private static User currentUser;

    /*public User(String userLogin, String userPassword) {
        //this.UserID = new SimpleIntegerProperty(userID);
        this.UserLogin = new SimpleStringProperty(userLogin);
        this.UserPassword = new SimpleStringProperty(userPassword);
    }*/

    public User() {
    }

    public String getUserLogin() {
        return UserLogin.get();
    }

    public void setUserLogin(String value) {
        UserLogin.set(value);
    }

    public String getUserPassword() {
        return UserPassword.get();
    }

    public void setUserPassword(String value) {
        UserPassword.set(value);
    }

    public int getUserID() {
        return UserID.get();
    }

    public void setUserID(int value) {
        UserID.set(value);
    }

    //получить логин текущего пользователя
    public static User getCurrentUser() {
        return currentUser; // Метод для получения текущего пользователя
    }

    //задать текущего пользователя по логину
    public static void setCurrentUser(String userLogin, String userPassword) {
        currentUser = new User();
        //currentUser; // Метод для задания текущего пользователя
    }

    // тестовое получение всех пользователей
    public static ObservableList<User> getAllUsers() {
        currentUser = getCurrentUser();

        return FXCollections.observableArrayList(
                currentUser//,
                //new User("user47", "999")
        );
    }
}