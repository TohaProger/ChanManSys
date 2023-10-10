package com.example.chanmansys.Controller;

import com.example.chanmansys.Model.User;
import com.example.chanmansys.StartApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public static User user;

    public static boolean isUserIn = true;

    /**
     * Функция входа как пользователь
     * @throws SQLException  исключение при работе с SQL-запросами
     */
    @FXML
    protected void onLoginButtonLogin() throws SQLException {
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());

        if (StartApp.daoFactory.getUserDAO().verification(loginField.getText(), passwordField.getText()))
        {
            user=StartApp.daoFactory.getUserDAO().findUser(loginField.getText());
            //System.out.println("LoginController user.login="+user.getLogin());
            StartApp.openWindow("main-view.fxml", "Главное окно");
        }
        else
        {
            //loginField.clear();
            passwordField.clear();
            StartApp.showAlertView(Alert.AlertType.ERROR, "Ошибка авторизации. Неверные данные");
        }
    }

    @FXML
    protected void onLoginButtonRegistrationView() throws IOException {
        StartApp.openWindow("registration-view.fxml", "Окно регистрации");
    }
}
