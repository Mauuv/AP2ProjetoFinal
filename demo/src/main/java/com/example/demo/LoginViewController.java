package com.example.demo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {
    @FXML
    private PasswordField pwd;

    @FXML
    private TextField user;

    @FXML
    private Button lista;
    Stage stage;
    InitViewController controller;


    @FXML
    void login(ActionEvent event) throws IOException {
        try{
            if (Valida(user.getText(), pwd.getText())) {
                user.getScene().getWindow().hide();
                FXMLLoader fx = new FXMLLoader(InitViewController.class.getResource("GerView.fxml"));
                Scene scene = new Scene(fx.load());
                Stage st = new Stage();
                st.setTitle("Gerenciamento");
                st.setScene(scene);
                st.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"ERRO, USUÁRIO OU SENHA INCORRETOS!!", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (IOException e) {
        //PDF
        }
    } 

    @FXML
    void Lista(ActionEvent event) throws IOException {
        try{
            FXMLLoader fx = new FXMLLoader(GerViewController.class.getResource("ListProductsView.fxml"));
            Scene scene = new Scene(fx.load());
            Stage st = new Stage();
            st.setTitle("Gerenciamento");
            st.setScene(scene);
            st.show();
        } catch (IOException e) {
        //PDF
        }
    }

    @FXML
    public boolean Valida(String user, String password) {
        Usuario usuario = new Usuario(user, password);
        System.out.println(usuario);
        DaoUsuario daoUsuario = new DaoUsuario();
        ObservableList<Object> ListaUsuarios = FXCollections.observableList(daoUsuario.pesquisarTodos());

        if(ListaUsuarios.contains(usuario)){
            return true;
        }
        return false;
    }

    @FXML
    void voltar(ActionEvent event) {
        ((Stage)lista.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
