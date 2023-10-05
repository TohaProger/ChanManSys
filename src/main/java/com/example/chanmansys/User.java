package com.example.chanmansys;

public class User {
    private String UserID;
    private String UserLogin;
    private String UserPassword;
    //private String UserName;
    private static User currentUser;

    public User(String userLogin) {
        //this.UserName = username;
        this.UserLogin = userLogin;
    }

    /*public String getUserName() {
        return UserName;
    }*/

    //получить логин текущего пользователя
    public static User getCurrentUser() {
        return currentUser; // Метод для получения текущего пользователя
    }

    //задать текущего пользователя по логину
    public static void setCurrentUser(String userLogin) {
        currentUser = new User(userLogin);
        //currentUser; // Метод для задания текущего пользователя
    }

    public String getUserLogin() {
        return UserLogin;
    }
}
