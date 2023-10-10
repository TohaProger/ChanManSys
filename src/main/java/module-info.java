module com.example.chanmansys {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.chanmansys to javafx.fxml;
    exports com.example.chanmansys;
    exports com.example.chanmansys.DAO;
    opens com.example.chanmansys.DAO to javafx.fxml;
    exports com.example.chanmansys.Model;
    opens com.example.chanmansys.Model to javafx.fxml;
    exports com.example.chanmansys.Controller;
    opens com.example.chanmansys.Controller to javafx.fxml;
}