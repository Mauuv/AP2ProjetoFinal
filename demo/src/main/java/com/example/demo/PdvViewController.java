package com.example.demo;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PdvViewController implements Initializable {

    @FXML
    private TableView<Produto> carrinho;
    @FXML
    private TableColumn<Produto, String> description;

    @FXML
    private TableColumn<Produto, Integer> id;

    @FXML
    private TableColumn<Produto, String> unit;

    @FXML
    private TableColumn<Produto, Double> value;

    @FXML
    private TextField TxtProduto;

    @FXML
    private TextArea TotalItens;

    private ObservableList<Produto> observableList;

    @FXML
    void AddCarrinho(ActionEvent event) {
        DaoProduto dao = new DaoProduto();
        int idProd = Integer.parseInt(TxtProduto.getText());
        List<Produto> ListProduto = Collections.singletonList(dao.pesquisar(idProd));
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        observableList = FXCollections.observableList(ListProduto);
        carrinho.setItems(observableList);
    }

    @FXML
    void Finalizar(ActionEvent event) {

    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        ((Stage)TxtProduto.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
