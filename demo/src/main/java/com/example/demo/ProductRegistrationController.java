package com.example.demo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductRegistrationController implements Initializable {

    @FXML
    private TableView<Object> ListaProduto;

    @FXML
    private TableColumn<Produto, Double> amount;

    @FXML
    private TextField descricao;

    @FXML
    private TableColumn<Produto, String> description;

    @FXML
    private TableColumn<Produto, Integer> id;

    @FXML
    private TextField quantidade;

    @FXML
    private TextField unidade;

    @FXML
    private TableColumn<Produto, String> unit;

    @FXML
    private TextField valor;

    @FXML
    private TableColumn<Produto, Double> value;

    @FXML
    ObservableList<Object> ListarProduto() {
        DaoProduto dao = new DaoProduto();
        ObservableList<Object> ListaProduto = FXCollections.observableList(dao.pesquisarTodos());

        return ListaProduto;
    }

    @FXML
    void btnCadastrar(ActionEvent event) {
        Produto prod = new Produto();
        prod.setDescricao(descricao.getText());
        prod.setValorFinal(Double.parseDouble(valor.getText()));
        prod.setEstoque(Integer.parseInt(quantidade.getText()));
        prod.setUnidade(unidade.getText());
        DaoProduto dao = new DaoProduto();
        if (dao.pesquisaProd(prod)) {
            System.out.println("Ja existe um produto com essas características!!");
        } else {
            dao.adicionar(prod);
            refresh();
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        ((Stage) descricao.getScene().getWindow()).close();
    }

    void refresh(){
        ListaProduto.getItems().clear();
        ListaProduto.getItems().addAll(ListarProduto());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        description.setCellValueFactory(new PropertyValueFactory<Produto, String>("Descricao"));
        value.setCellValueFactory(new PropertyValueFactory<Produto, Double>("ValorFinal"));
        amount.setCellValueFactory(new PropertyValueFactory<Produto, Double>("Estoque"));
        unit.setCellValueFactory(new PropertyValueFactory<Produto, String>("Unidade"));
        ListaProduto.setItems(ListarProduto());
    }
}
