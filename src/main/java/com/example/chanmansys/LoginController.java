package com.example.chanmansys;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() {
        String username = userLogin.getText();
        String password = passwordField.getText();

        UserDAO userDao = new UserDAO();
        boolean loginSuccessful = userDao.loginUser(username, password);

        // Здесь вы можете добавить логику проверки логина и пароля
        if (loginSuccessful) {
            // Здесь можно выполнить действия после успешной авторизации
            System.out.println("Авторизация успешна!");
        } else {
            // Здесь можно обработать случай неверных данных
            System.out.println("Неверный логин или пароль");
        }
    }

    @FXML
    protected void onRegistrationViewButtonClick() throws IOException {
        // Закрываем текущее окно
        Stage currentStage = (Stage) userLogin.getScene().getWindow();
        currentStage.close(); // Используйте hide(), если хотите просто скрыть окно
        // Открываем окно регистрации
        FXMLLoader registrationLoader = new FXMLLoader(getClass().getResource("registration-view.fxml"));
        Stage registrationStage = new Stage();
        registrationStage.setTitle("Регистрация");
        registrationStage.setScene(new Scene(registrationLoader.load()));
        registrationStage.show();
    }
}
