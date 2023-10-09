package com.example.chanmansys;

import com.example.chanmansys.DAO.DAOFactory;
import com.example.chanmansys.DAO.User;
import com.example.chanmansys.DAO.UserDAO;
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

    @FXML
    protected void onLoginButtonLogin() throws SQLException {
        String userLogin = this.loginField.getText();
        String userPassword = passwordField.getText();

        // исправить так - создаем объект user с данными, а потом с помощью userDao его уже добавляем, удаляем и прочее

        //User user = new User();
        //boolean loginSuccessful = user.boolUserFind(userLogin, userPassword);

        // Здесь вы можете добавить логику проверки логина и пароля
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());


        if (StartApp.userDAO.verification(loginField.getText(), passwordField.getText()))
        {
            System.out.println("Ну типа зарегались");
            // Здесь действия после успешной авторизации
            //user=HomeViewController.daoFactory.getUserDAO().findUser(LoginText.getText(), PasswordText.getText());
            /*StartApp.showAlertView("Вы успешно авторизованы.\nПереход в главное окно.");
            User.setCurrentUser(userLogin, userPassword);
            StartApp.openWindow("main-view.fxml", "Главное окно");*/
        }
        else {
            // Здесь в случае неверных данных
            /*loginField.clear();
            passwordField.clear();
            StartApp.showAlertView("Неверный логин или пароль :(")

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка авторизации");
            alert.setContentText("Неверные данные");
            alert.showAndWait();*/
        }
    }

    @FXML
    protected void onLoginButtonRegistrationView() throws IOException {
        StartApp.openWindow("registration-view.fxml", "Окно регистрации");
    }
}
