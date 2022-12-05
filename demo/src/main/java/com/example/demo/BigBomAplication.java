package com.example.demo;

import java.io.IOException;

import org.w3c.dom.Document;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.itextpdf.text.Document;

public class BigBomAplication extends Application {
    
    @Override
    public void start(Stage st) throws IOException {
        try{
            FXMLLoader fx = new FXMLLoader(BigBomAplication.class.getResource("InitView.fxml"));
            Scene scene = new Scene(fx.load());
            st.setTitle("BIG BOM!");
            st.setScene(scene);
            st.show();
        } catch (IOException e) {
            //PDF
        }
    }     

    public static void main(String[] args) {
        launch(args);
    }

}
