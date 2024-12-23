module com.example.cabinet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cabinet to javafx.fxml;
    exports com.example.cabinet;
}