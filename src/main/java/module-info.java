module com.example.cafe94 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cafe94 to javafx.fxml;
    exports com.example.cafe94;
    exports com.example.cafe94.entities;
}