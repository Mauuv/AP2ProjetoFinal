//Allyson
package com.example.demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InitViewController {


    @FXML
    private Button sair;

    @FXML
    public void StartGerenciamento(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("Login");
        st.setScene(scene);
        st.show();

    }

    @FXML
    public void StartPDV(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("PDVView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("PDV");
        st.setScene(scene);
        st.show();
    }

    @FXML
    void Sair(ActionEvent event) {
        ((Stage) sair.getScene().getWindow()).close();
    }
}
