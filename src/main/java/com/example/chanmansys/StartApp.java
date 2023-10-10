package com.example.chanmansys;

import com.example.chanmansys.DAO.DAOFactory;
import com.example.chanmansys.DAO.UserDAO;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApp extends Application {
    public static Stage currentStage; // Статическое поле для хранения основной сцены

    public static DAOFactory daoFactory;// = DAOFactory.getDAOFactory(DAOFactory.SQLITE);

    //public static UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public void start(Stage stage) throws IOException {
        openWindow("start-view.fxml", "Загрузка из..."); // Открываем начальное окно (выбор метода загрузки данных)
    }
    public static void main(String[] args) {
        launch();

        // create the required DAO Factory
        //DAOFactory sqlLiteFactory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        // Create a DAO
        //UserDAO userDAO = sqlLiteFactory.getUserDAO();

        // create a new user
        //int newUserID = userDAO.createFromLogin("userNew");

        // Find a customer object. Get the Transfer Object
        //User user = userDAO.findUser(newUserID);

        // modify the values in the Transfer Object.
        //user.setUserPassword("343545");
        //user.setEmail();

        // update the customer object using the DAO
        //userDAO.update(user);

        // delete a customer object
        //userDAO.delete(user);

        // select all customers in the same city
        //User criteria = new User();
        //criteria.setCity("New York");
        //Collection customersList = custDAO.selectCustomersTO(criteria);

        // returns customersList - collection of Customer
        // Transfer Objects. iterate through this collection to
        // get values.
    }

    public static void showAlertView(AlertType alertType, String alertTitle, String alertMessage) {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setHeaderText(null);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    /**
     * Функция загрузки всех окон
     * @param fxmlFileName String
     * @param windowTitle String
     */
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

    //открытие окна по методу загрузки - из базы данных, файла или из памяти
    public void onDataBase(ActionEvent actionEvent) throws IOException {
        daoFactory = DAOFactory.getDAOFactory(1);
        openWindow("login-view.fxml", "Страница входа");
    }

    public void onTxt(ActionEvent actionEvent) throws IOException  {
        daoFactory = DAOFactory.getDAOFactory(2);
        openWindow("login-view.fxml", "Страница входа");
    }

    public void onRam(ActionEvent actionEvent) throws IOException {
        daoFactory = DAOFactory.getDAOFactory(3);
        openWindow("login-view.fxml", "Страница входа");
    }
}
