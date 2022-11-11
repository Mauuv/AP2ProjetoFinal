package com.example.bigbom;

import com.example.bigbom.Controller.InitViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BigBomAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("InitView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("BIG BOM!");
        st.setScene(scene);
        st.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}