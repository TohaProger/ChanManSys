package com.example.chanmansys;

public class User {
    private String UserID;
    private String UserLogin;
    private String UserPassword;
    //private String UserName;

    public User(String userLogin) {
        //this.UserName = username;
        this.UserLogin = userLogin;
    }

    /*public String getUserName() {
        return UserName;
    }*/

    public String getUserLogin() {
        return UserLogin;
    }
}
