module com.example.bigbom {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.bigbom.Controller to javafx.fxml;
    exports com.example.bigbom.Controller;
    exports com.example.bigbom;
    opens com.example.bigbom to javafx.fxml;
}