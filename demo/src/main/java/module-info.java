module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}