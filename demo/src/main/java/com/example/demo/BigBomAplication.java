package com.example.demo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BigBomAplication extends Application {
    @Override
    public void start(Stage st) throws IOException {
        FXMLLoader fx = new FXMLLoader(BigBomAplication.class.getResource("InitView.fxml"));
        Scene scene = new Scene(fx.load());
        st.setTitle("BIG BOM!");
        st.setScene(scene);
        st.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}