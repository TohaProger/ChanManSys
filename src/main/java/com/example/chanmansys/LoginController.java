package com.example.chanmansys;

import com.example.chanmansys.DAO.User;
import com.example.chanmansys.DAO.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonLogin() {
        String userLogin = this.userLogin.getText();
        String userPassword = passwordField.getText();

        UserDAO userDao = new UserDAO();
        boolean loginSuccessful = userDao.loginUser(userLogin, userPassword);

        // Здесь вы можете добавить логику проверки логина и пароля
        if (loginSuccessful) {
            // Здесь действия после успешной авторизации
            StartApp.showAlertView("Вы успешно авторизованы.\nПереход в главное окно.");
            User.setCurrentUser(userLogin, userPassword);
            StartApp.openWindow("main-view.fxml", "Главное окно");
        } else {
            // Здесь в случае неверных данных
            StartApp.showAlertView("Неверный логин или пароль :(");
        }
    }

    @FXML
    protected void onLoginButtonRegistrationView() throws IOException {
        StartApp.openWindow("registration-view.fxml", "Окно регистрации");
    }
}
