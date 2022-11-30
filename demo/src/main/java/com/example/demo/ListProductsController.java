package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class ListProductsController implements Initializable {

    @FXML
    private TableView<Object> ListaProduto;
    @FXML
    private TableColumn<Produto, Double> amount;

    @FXML
    private TableColumn<Produto, String> description;

    @FXML
    private TableColumn<Produto, Integer> id;

    @FXML
    private TableColumn<Produto, String> unit;

    @FXML
    private TableColumn<Produto, Double> value;

    @FXML
    void voltar(ActionEvent event) {
        ((Stage)ListaProduto.getScene().getWindow()).close();
    }

    @FXML
    ObservableList<Object> ListarProduto(){
        DaoProduto dao = new DaoProduto();
        ObservableList<Object> ListaProduto = FXCollections.observableList(dao.pesquisarTodos());

        return ListaProduto;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        description.setCellValueFactory(new PropertyValueFactory<Produto, String>("Descricao"));
        value.setCellValueFactory(new PropertyValueFactory<Produto, Double>("ValorFinal"));
        amount.setCellValueFactory(new PropertyValueFactory<Produto, Double>("Estoque"));
        unit.setCellValueFactory(new PropertyValueFactory<Produto, String>("Unidade"));

        System.out.println(ListarProduto());
        ListaProduto.setItems(ListarProduto());
    }
}
