/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */
package com.example.chanmansys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainViewController {
    @FXML
    private TableColumn<User, String> ChangeDescription;

    @FXML
    private TableColumn<?, ?> ChangeID;

    @FXML
    private TableColumn<?, ?> ChangePriority;

    @FXML
    private TableColumn<User, String> ChangeStatus;

    @FXML
    private TableView<User> RequirementsTable;

    @FXML
    private TableColumn<?, ?> ServiceID_FK;

    @FXML
    private TableColumn<?, ?> UserID_FK;

    @FXML
    private CheckBox checkAuthor;

    @FXML
    private ComboBox<?> comboPriority;

    @FXML
    private ComboBox<?> comboStatus;

    @FXML
    private GridPane grid;

    @FXML
    private TextArea textDescription;

    @FXML
    public void selectSourceTab(MouseEvent mouseEvent) {
    }
    public void initialize() {
        // Загрузка данных в таблицу

        Stage stage = new Stage();
        loadTableData(stage);

        //ChangeDAO changeDAO = new ChangeDAO();

        //System.out.println(changeDAO.getYesNoChanges());
    }

    private void loadTableData(Stage stage) {

        // Создаем экземпляр ChangeDAO для работы с базой данных
        /*ChangeDAO changeDAO = new ChangeDAO();

        // Получаем все записи из базы данных
        List<Change> changesList = changeDAO.getAllChanges();
        // Очищаем TableView
        RequirementsTable.getItems().clear();

        // Получаем ObservableList из TableView
        List<Change> tableData = (List<Change>) RequirementsTable.getItems();

        // Добавляем все записи из changesList в ObservableList
        tableData.addAll(changesList);*/


        // Отображаем информацию о текущем пользователе
        User currentUser = User.getCurrentUser();

        if (currentUser != null) {
            textDescription.setText("Вы вошли как: " + currentUser.getUserLogin());
        }

        // ниже идёт заполнение таблицы:
        ObservableList<User> users = User.getAllUsers();

        // создаем список объектов
        /*ObservableList<User> users = FXCollections.observableArrayList(
                new User("user1", "34"),
                new User("Bob", "22")
        );*/
        // определяем таблицу и устанавливаем данные
        //TableView<User> table = new TableView<User>(users);
        //table.setPrefWidth(250);
        //table.setPrefHeight(200);

        RequirementsTable = new TableView<>(users);

        // столбец для вывода имени
        //TableColumn<User, String> nameColumn = new TableColumn<User, String>("login");
        ChangeDescription = new TableColumn<User, String>("login");
        // определяем фабрику для столбца с привязкой к свойству name
        //nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("UserLogin"));
        ChangeDescription.setCellValueFactory(new PropertyValueFactory<User, String>("UserLogin"));
        // добавляем столбец
        RequirementsTable.getColumns().add(ChangeDescription);

        // столбец для вывода возраста
        /*TableColumn<User, Integer> ageColumn = new TableColumn<User, Integer>("password");
        ageColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("UserPassword"));
        table.getColumns().add(ageColumn);*/

        ChangeStatus = new TableColumn<User, String>("passw");
        ChangeStatus.setCellValueFactory(new PropertyValueFactory<User, String>("UserPassword"));
        RequirementsTable.getColumns().add(ChangeStatus);

        //FlowPane root = new FlowPane(10, 10, RequirementsTable);

        //Scene scene = new Scene(root, 300, 250);

        //stage.setScene(scene);
        //stage.setTitle("TableView in JavaFX");
        //stage.show();
    }
}
