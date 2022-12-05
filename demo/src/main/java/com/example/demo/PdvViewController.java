package com.example.demo;

import java.net.URL;
import java.util.*;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static java.time.zone.ZoneRulesProvider.refresh;

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
    private Button btnDel;
    @FXML
    private TableColumn<Produto, Double> amount;
    @FXML
    private TableColumn<Produto, Double> value;

    @FXML
    private TextField TxtProduto;

    @FXML
    private Label TotalItens;

    private ObservableList<Produto> observableList;

    @FXML
    void AddCarrinho(ActionEvent event) {
        double soma = 0;
        DaoProduto dao = new DaoProduto();
        int idProd = Integer.parseInt(TxtProduto.getText());
        List<Produto> ListProduto = Collections.singletonList(dao.pesquisar(idProd));
        id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        description.setCellValueFactory(new PropertyValueFactory<Produto, String>("Descricao"));
        value.setCellValueFactory(new PropertyValueFactory<Produto, Double>("ValorFinal"));
        amount.setCellValueFactory(new PropertyValueFactory<Produto, Double>("Estoque"));
        unit.setCellValueFactory(new PropertyValueFactory<Produto, String>("Unidade"));
        observableList = FXCollections.observableList(ListProduto);
        carrinho.setItems(observableList);

        for (Produto a : observableList){
            double Total;
           Total = a.getEstoque() * a.getValorFinal();
           soma += Total;
        }
        TotalItens.setText(String.valueOf(soma));
        BooleanBinding selected = carrinho.getSelectionModel().selectedItemProperty().isNull();
        btnDel.disableProperty().bind(selected);
        carrinho.getSelectionModel().selectedItemProperty().addListener((Obsval, Oldval , Newval) -> {
            if (Newval != null) {
                Produto n = (Produto) Newval;
                id.setText(String.valueOf(n.getId()));
                amount.setText(String.valueOf(n.getEstoque()));
            }
        });
    }
    @FXML
    void remover(ActionEvent event) {
        DaoProduto dao = new DaoProduto();
        Produto prod = new Produto();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);

        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            prod.setId(id.getCellObservableValue(carrinho.getSelectionModel().getFocusedIndex()).getValue());
            dao.remover(prod);
        }
        refresh();
    }

    @FXML
    void Finalizar(ActionEvent event) {
        /*int contador = 1;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cupom Fiscal");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put(String.valueOf(contador), new Object[]{"Descricao", "Valor", "Quantidade", "Unidade"});

       for(Produto) {produto: //nome da lista ou array){
            contador++;
            data.put(String.valueOf(contador), new Object[])//Getters para pegar os valoresd os atributos dos produtos);
        }
        Set<String> keyset = data.keySet();
        int rownum = 0;

        for(String key: keyset){
            Row row = sheet.createRow(rownum++);
            Object[] objarr = data.get(key);
            int cellnum = 0;

            for(Object obj: objarr){
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String){
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Integer){
                    cell.setCellValue((Integer) obj);
                }
                else if (obj instanceof Float){
                    cell.setCellValue((Float) obj);
                }
            }
        }

        try{
            FileOutputStream os = new FileOutputStream("teste.xlsx");
            workbook.write(os);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cupom fiscal gerado com sucesso!", ButtonType.OK);
            alert.showAndWait();
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Arquivo nao encontrado!", ButtonType.OK);
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro", ButtonType.OK);
        }*/
    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        ((Stage)TxtProduto.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
