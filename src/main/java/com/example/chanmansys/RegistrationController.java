package com.example.chanmansys;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
                System.out.println("Регистрация успешна!");
                onRegistrationOpenLoginView();
            } else {
                System.out.println("Ошибка при регистрации");
            }
        } else {
            System.out.println("Пароли не совпадают");
        }
    }

    @FXML
    //открыть окно входа из окна регистрации
    protected void onLoginViewButtonClick() throws IOException {
        // Закрываем текущее окно
        Stage currentStage = (Stage) userLoginField.getScene().getWindow();
        currentStage.close(); // Используйте hide(), если хотите просто скрыть окно
        // Открываем окно входа
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Stage loginStage = new Stage();
        loginStage.setTitle("Вход");
        loginStage.setScene(new Scene(loginLoader.load()));
        loginStage.show();
    }

    //открыть окно входа при успешной регистрации
    private void onRegistrationOpenLoginView() {
        try {
            Stage currentStage = (Stage) userLoginField.getScene().getWindow();
            currentStage.close();

            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Stage mainStage = new Stage();
            mainStage.setTitle("Главное окно");
            mainStage.setScene(new Scene(mainLoader.load()));
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
