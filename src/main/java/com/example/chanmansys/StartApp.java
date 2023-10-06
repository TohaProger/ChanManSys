package com.example.chanmansys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApp extends Application {
    public static Stage currentStage; // Статическое поле для хранения основной сцены

    @Override
    public void start(Stage stage) throws IOException {
        openWindow("login-view.fxml", "Вход"); // Открываем начальное окно (например, окно входа)
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

    public static void openWindow(String fxmlFileName, String windowTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(StartApp.class.getResource(fxmlFileName));
            Stage newStage = new Stage();
            newStage.setTitle(windowTitle);
            newStage.setScene(new Scene(loader.load()));
            newStage.show();

            // Закрываем текущее окно
            if (currentStage != null) {
                currentStage.close();
            }

            currentStage = newStage;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
