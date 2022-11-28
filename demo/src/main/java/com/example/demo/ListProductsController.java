package com.example.demo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListProductsController implements Initializable {

    @FXML
    private TableView<Object> ListaProduto;
    @FXML
    private TableColumn<Produto, Integer> amount;

    @FXML
    private TableColumn<Produto, String> description;

    @FXML
    private TableColumn<Produto, Integer> id;

    @FXML
    private TableColumn<Produto, String> unit;

    @FXML
    private TableColumn<Produto, Double> value;

    private ObservableList<Object> observableList;
    @FXML
    void voltar(ActionEvent event) {
        ((Stage)ListaProduto.getScene().getWindow()).close();
    }

    @FXML
    void ListarProduto(){
        DaoProduto dao = new DaoProduto();
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        observableList = FXCollections.observableList(dao.pesquisarTodos());
        ListaProduto.setItems(observableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListarProduto();
    }
}
