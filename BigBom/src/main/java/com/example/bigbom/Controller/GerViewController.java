package com.example.bigbom.Controller;

import com.example.bigbom.Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class GerViewController implements Initializable {

    @FXML
    void Cadastro(ActionEvent event) throws IOException {
        if (Usuario.isAdmin()){
            FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("ProductRegistrationView.fxml"));
            Scene scene = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Cadastro de Produtos");
            st.setScene(scene);
            st.show();
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText("ERRO DE PERMISSÃO");
        alert.setContentText("SOMENTE ADMINS PODEM FAZER O CADASTRO DE PRODUTOS");

    }

    @FXML
    void Lista(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("GerView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("Gerenciamento");
        st.setScene(scene);
        st.show();
    }

    @FXML
    void Remover(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("GerView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("Gerenciamento");
        st.setScene(scene);
        st.show();
    }

    public void Validation(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
