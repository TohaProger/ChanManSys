package com.example.chanmansys.Controller;

import com.example.chanmansys.Model.Change;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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

    public static Change changes =new Change();

    public void initialize() {
        // Загрузка данных в таблицу
        loadTableData();
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