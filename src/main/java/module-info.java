module com.example.chanmansys {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.chanmansys to javafx.fxml;
    exports com.example.chanmansys;
}