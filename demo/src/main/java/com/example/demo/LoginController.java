package com.example.demo;
import java.io.IOException;

import com.example.demo.InitViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private PasswordField pwd;

    @FXML
    private TextField user;

    @FXML
    void login(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("GerView.fxml"));
        Scene scene = new Scene(fx.load());
        Stage st = new Stage();
        st.setTitle("Gerenciamento");
        st.setScene(scene);
        st.show();
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("ERRO");
//        alert.setHeaderText("ERRO AO FAZER LOGIN!!");
//        alert.setContentText("USUÁRIO OU SENHA INCORRETOS!!");
    }
}
