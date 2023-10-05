/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */
package com.example.chanmansys;

import com.example.chanmansys.DAO.ChangeDAO;
import com.example.chanmansys.Model.Change;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

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
        ChangeDAO changeDAO = new ChangeDAO();

        // Получаем все записи из базы данных
        List<Change> changesList = changeDAO.getAllChanges();
        // Очищаем TableView
        RequirementsTable.getItems().clear();

        // Получаем ObservableList из TableView
        List<Change> tableData = (List<Change>) RequirementsTable.getItems();

        // Добавляем все записи из changesList в ObservableList
        tableData.addAll(changesList);
    }
}
