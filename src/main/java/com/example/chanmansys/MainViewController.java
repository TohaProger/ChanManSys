/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */
package com.example.chanmansys;

import com.example.chanmansys.DAO.ChangeDAO;
import com.example.chanmansys.DAO.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class MainViewController {
    @FXML
    private TableColumn<?, ?> ChangeDescription;

    @FXML
    private TableColumn<?, ?> ChangeID;

    @FXML
    private TableColumn<?, ?> ChangePriority;

    @FXML
    private TableColumn<?, ?> ChangeStatus;

    @FXML
    private TableView<?> RequirementsTable;

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

        loadTableData();

        //ChangeDAO changeDAO = new ChangeDAO();

        //System.out.println(changeDAO.getYesNoChanges());
    }

    private void loadTableData() {
        // Создаем экземпляр ChangeDAO для работы с базой данных
        /*ChangeDAO changeDAO = new ChangeDAO();

        // Получаем все записи из базы данных
        List<Change> changesList = changeDAO.getAllChanges();
        // Очищаем TableView
        RequirementsTable.getItems().clear();
        // Получаем ObservableList из TableView
        ObservableList<Change> tableData = (ObservableList<Change>) RequirementsTable.getItems();

        // Добавляем все записи из changesList в ObservableList
        tableData.addAll(changesList);

        System.out.println(changesList.get(0).getChangePriority());*/






        // Отображаем информацию о текущем пользователе
        /*User currentUser = User.getCurrentUser();
        if (currentUser != null) {
            textDescription.setText("Вы вошли как: " + currentUser.getUserLogin());
        }
        // ниже идёт заполнение таблицы:
        ObservableList<User> users = User.getAllUsers();

        RequirementsTable = new TableView<>(users);

        // столбец для вывода имени
        //TableColumn<User, String> nameColumn = new TableColumn<User, String>("login");
        ChangeDescription = new TableColumn<User, String>("login");
        // определяем фабрику для столбца с привязкой к свойству name
        //nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("UserLogin"));
        ChangeDescription.setCellValueFactory(new PropertyValueFactory<User, String>("ChangeDescription"));
        // добавляем столбец
        RequirementsTable.getColumns().add(ChangeDescription);

        // столбец для вывода возраста
        ChangeStatus = new TableColumn<User, String>("passw");
        ChangeStatus.setCellValueFactory(new PropertyValueFactory<User, String>("UserPassword"));
        RequirementsTable.getColumns().add(ChangeStatus);*/



        //FlowPane root = new FlowPane(10, 10, RequirementsTable);

        //Scene scene = new Scene(root, 300, 250);

        //stage.setScene(scene);
        //stage.setTitle("TableView in JavaFX");
        //stage.show();
    }
}
