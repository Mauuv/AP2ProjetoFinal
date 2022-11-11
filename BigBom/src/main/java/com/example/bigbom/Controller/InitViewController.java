package com.example.bigbom.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InitViewController implements Initializable {

    @FXML
    void StartGerenciamento(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("Gerenciamento");
        st.setScene(scene);
        st.show();
    }

    @FXML
    void StartPDV(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("PDVView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("PDV");
        st.setScene(scene);
        st.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
