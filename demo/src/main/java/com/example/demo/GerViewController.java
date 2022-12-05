package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GerViewController implements Initializable {

    @FXML
    private Button cadastro;

    @FXML
    void Cadastro(ActionEvent event) throws IOException {
        try{
            FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("ProductRegistrationView.fxml"));
            Scene scene = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Cadastro de Produtos");
            st.setScene(scene);
            st.show();
        } catch (IOException e) {
            //PDF
        }
    }

    @FXML
    void Remover(ActionEvent event) throws IOException {
        try{
            FXMLLoader fx = new FXMLLoader(GerViewController.class.getResource("RemoveUpdateProductsView.fxml"));
            Scene scene = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Alteracao de produtos");
            st.setScene(scene);
            st.show();
        } catch (IOException e) {
        //PDF
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void voltar(ActionEvent event) {
        ((Stage)cadastro.getScene().getWindow()).close();
    }
}
