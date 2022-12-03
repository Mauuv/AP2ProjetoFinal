module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires java.desktop;
    requires org.apache.poi.ooxml;

    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}