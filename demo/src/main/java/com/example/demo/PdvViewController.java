package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;

public class PdvViewController {

    @FXML
    private TextField TxtProduto;

    @FXML
    private TextArea TotalItens;

    @FXML
    void AddCarrinho(ActionEvent event) {
        double Total = 1.2;
        for (int i = 0; i<= TxtProduto.getLength(); i ++){
            Total += Produto.getValorFinal();
          //  TotalItens = Total;
        }

    }

    @FXML
    void Finalizar(ActionEvent event) {

    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        ((Stage)TxtProduto.getScene().getWindow()).close();
    }

}
