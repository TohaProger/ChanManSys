package com.example.chanmansys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loginLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene loginScene = new Scene(loginLoader.load());

        stage.setTitle("Авторизация");
        stage.setScene(loginScene);
        stage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showAlertView(String alertMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle(alertTitle);
        alert.setHeaderText(null);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }
}
