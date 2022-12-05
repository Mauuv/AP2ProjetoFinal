//Mauricio

package com.example.demo;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RemoveUpdateProductsController implements Initializable {

    @FXML
    private Button btnAlt;

    @FXML
    private Button btnDel;
    @FXML
    private TextField descricao;
    @FXML
    private TextField unidade;
    @FXML
    private TextField estoque;
    @FXML
    private TextField valor;
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

        ListaProduto.setItems(ListarProduto());
        BooleanBinding selected = ListaProduto.getSelectionModel().selectedItemProperty().isNull();

        btnDel.disableProperty().bind(selected);
        btnAlt.disableProperty().bind(selected);
        ListaProduto.getSelectionModel().selectedItemProperty().addListener((Obsval, Oldval , Newval) -> {
            if (Newval != null) {
                Produto n = (Produto) Newval;
                descricao.setText(n.getDescricao());
                estoque.setText(String.valueOf(n.getEstoque()));
                valor.setText(String.valueOf(n.getValorFinal()));
                unidade.setText(n.getUnidade());
            }
        });
    }

    @FXML
    void alterar(ActionEvent event) {
        DaoProduto dao = new DaoProduto();
        Produto prod = new Produto();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo alterar? ", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);

        alert.showAndWait();
        try {
            if (alert.getResult() == ButtonType.YES) {
                prod.setDescricao(descricao.getText());
                prod.setValorFinal(Double.parseDouble(valor.getText()));
                prod.setEstoque(Double.parseDouble(estoque.getText()));
                prod.setUnidade(unidade.getText());
                prod.setId(id.getCellObservableValue(ListaProduto.getSelectionModel().getFocusedIndex()).getValue());
                dao.alterar(prod);
            }
        } catch (NumberFormatException e) {
            Alert alertException = new Alert(Alert.AlertType.ERROR, "Erro ao coletar dados, confira se os campos estão preenchidos corretamente", ButtonType.OK);

            alertException.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        refresh();
    }

    @FXML
    void remover(ActionEvent event) {
        DaoProduto dao = new DaoProduto();
        Produto prod = new Produto();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);

        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            prod.setId(id.getCellObservableValue(ListaProduto.getSelectionModel().getFocusedIndex()).getValue());
            dao.remover(prod);
        }
        refresh();
    }

    @FXML
    void voltar(ActionEvent event) {
        ((Stage)ListaProduto.getScene().getWindow()).close();
    }

    void refresh(){
        ListaProduto.getItems().clear();
        ListaProduto.getItems().addAll(ListarProduto());
    }

}
