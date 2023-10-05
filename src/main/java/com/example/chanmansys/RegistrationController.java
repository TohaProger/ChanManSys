package com.example.chanmansys;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private TextField userLoginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    //обработка регистрации в окне регистрации
    protected void onRegisterButtonClick() {
        String userLogin = userLoginField.getText();
        String userPassword = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Здесь логика регистрации пользователя
        // Проверка совпадения пароля и подтверждения пароля из БД
        if (userPassword.equals(confirmPassword)) {
            UserDAO userDao = new UserDAO();
            boolean success = userDao.createUser(userLogin, userPassword);
            if (success) {
                StartApp.showAlertView("Вы успешно зарегистрированы.\nПереход в окно входа.");
                StartApp.openWindow("login-view.fxml", "Окно входа");
            } else {
                StartApp.showAlertView("Ошибка при регистрации :(");
            }
        } else {
            StartApp.showAlertView("Введенные пароли не совпадают.");
        }
    }

    @FXML
    //открыть окно входа из окна регистрации
    protected void onLoginViewButtonClick() throws IOException {
        StartApp.openWindow("login-view.fxml", "Окно входа");
    }
}
