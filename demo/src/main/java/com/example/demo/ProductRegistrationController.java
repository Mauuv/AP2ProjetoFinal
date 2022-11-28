package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class ProductRegistrationController {

    @FXML
    private TextField amount;

    @FXML
    private TextField description;

    @FXML
    private TextField unit;

    @FXML
    private TextField value;

    @FXML
    void btnCadastrar(ActionEvent event) {
      Produto prod = new Produto();
      prod.setDescricao(description.getText());
      prod.setValorFinal(Double.parseDouble(value.getText()));
      prod.setEstoque(Integer.parseInt(amount.getText()));
      prod.setUnidade(unit.getText());
      DaoProduto dao = new DaoProduto();
        if (dao.pesquisaProd(prod)){
            System.out.println("Ja existe um produto com essas características!!");
        }else {
            dao.adicionar(prod);
            ((Stage) description.getScene().getWindow()).close();
        }
   }
}
