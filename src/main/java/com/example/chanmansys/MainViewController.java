package com.example.chanmansys;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {
    @FXML
    private Label mainLabel;

    @FXML
    private Label usernameLabel;

    public void initialize() {
        mainLabel.setText("Это главное окно");

        // Отображаем информацию о текущем пользователе
        User currentUser = User.getCurrentUser();

        if (currentUser != null) {
            usernameLabel.setText(currentUser.getUserLogin());
        }
        else
            usernameLabel.setText("ПользовательНеНайден");
    }
}
