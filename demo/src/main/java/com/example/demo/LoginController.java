package com.example.demo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.InitViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    private PasswordField pwd;

    @FXML
    private TextField user;

    Stage stage;
    InitViewController controller;



    @FXML
    void login(ActionEvent event) throws IOException {
        //if (Usuario.isAdmin()) {
            ((Stage)user.getScene().getWindow()).hide();
            FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("GerView.fxml"));

            Scene scene = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Gerenciamento");
            st.setScene(scene);
            st.show();
        controller = fx.getController();
        stage = ((Stage)user.getScene().getWindow());
        controller.passaJanela(stage);
//        }
//        else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("ERRO");
//            alert.setHeaderText("ERRO AO FAZER LOGIN!!");
//            alert.setContentText("USUÁRIO OU SENHA INCORRETOS!!");
//        }
    }

    public void mostra() {
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
