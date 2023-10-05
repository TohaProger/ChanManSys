package com.example.chanmansys;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {
    private static User currentUser;

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
            // Здесь можно выполнить действия после успешной авторизации
            System.out.println("Авторизация успешна!");
            currentUser = new User(userLogin);
            onLoginOpenMainView();
        } else {
            // Здесь можно обработать случай неверных данных
            System.out.println("Неверный логин или пароль");
        }
    }

    @FXML
    protected void onLoginButtonRegistrationView() throws IOException {
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

    public static User getCurrentUser() {
        return currentUser; // Метод для получения логина текущего пользователя
    }

    //открыть главное окно при успешном входе
    private void onLoginOpenMainView() {
        try {
            Stage currentStage = (Stage) userLogin.getScene().getWindow();
            currentStage.close();

            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Stage mainStage = new Stage();
            mainStage.setTitle("Главное окно");
            mainStage.setScene(new Scene(mainLoader.load()));
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
