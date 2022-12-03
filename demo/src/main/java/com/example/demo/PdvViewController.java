package com.example.demo;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.*;

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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class PdvViewController implements Initializable {

    @FXML
    private TableView<Produto> carrinho;
    @FXML
    private TableColumn<Produto, String> description;

    @FXML
    private TextField qtProduto;
    @FXML
    private TableColumn<Produto, Integer> id;

    @FXML
    private TableColumn<Produto, String> unit;

    @FXML
    private TableColumn<Produto, Double> amount;
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
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        observableList = FXCollections.observableList(ListProduto);
        carrinho.setItems(observableList);
    }

    @FXML
    void Finalizar(ActionEvent event) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cupom Fiscal");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Descricao", "Valor", "Quantidade", "Unidade"});
    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        ((Stage)TxtProduto.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
