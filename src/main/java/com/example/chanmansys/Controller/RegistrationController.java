package com.example.chanmansys.Controller;

import com.example.chanmansys.StartApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Контроллер для регистрации
 */
public class RegistrationController {
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    //обработка регистрации в окне регистрации
    protected void onRegisterButtonClick() throws SQLException {
        String userLogin = loginField.getText();
        String userPassword = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Здесь логика регистрации пользователя. Проверка совпадения пароля и подтверждения пароля из БД

        if (userLogin.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty()) {
            StartApp.showAlertView(Alert.AlertType.ERROR, "Пожалуйста, заполните поля");
            loginField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            return;
        }

        if (!userPassword.equals(confirmPassword)) {
            StartApp.showAlertView(Alert.AlertType.ERROR, "Введенные пароли не совпадают");
            passwordField.clear();
            confirmPasswordField.clear();
            return;
        }

        StartApp.daoFactory.getUserDAO().addUser(userLogin, userPassword);

        if(StartApp.daoFactory.getUserDAO().findUser(userLogin) == null) {
            StartApp.showAlertView(Alert.AlertType.ERROR, "Ошибка регистрации на стороне БД. Пользователь не был добавлен");
            loginField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            return;
        }

        StartApp.showAlertView(Alert.AlertType.INFORMATION, "Вы успешно зарегистрированы. Открываем страницу входа");

        StartApp.openWindow("login-view.fxml", "Страница входа");
    }

    private boolean userExists(String login) {
        // Логика для проверки существования пользователя в базе данных или другом источнике данных
        return false; // Замените на соответствующую логику проверки
    }

    private void openMainWindow() {
        // Логика для открытия главного окна приложения
    }

    @FXML
    //открыть окно входа из окна регистрации
    protected void onLoginViewButtonClick() throws IOException {
        StartApp.openWindow("login-view.fxml", "Окно входа");
    }
}
