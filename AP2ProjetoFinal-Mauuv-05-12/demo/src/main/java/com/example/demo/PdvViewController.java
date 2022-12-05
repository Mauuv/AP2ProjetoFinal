//Alysson implementou a lógica, Maurício ajudou na questão de adicionar mais itens e remover somente do carrinho
//Mauricio implementou parte de geração de excel

package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    List<Produto> ListProduto = new ArrayList<>();

    @FXML
    void AddCarrinho(ActionEvent event) {
        double soma = 0;
        int idProd = 0;
        Double quantidade = 0.0;
        DaoProduto dao = new DaoProduto();
        try {
            idProd = Integer.parseInt(TxtProduto.getText());
            quantidade = Double.parseDouble(qtProduto.getText());
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Somente numeros inteiros", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        Produto temp = dao.pesquisar(idProd);
        try {
            temp.setEstoque(quantidade);
            temp.setValorFinal(temp.getValorFinal() * temp.getEstoque());
        } catch (NullPointerException e) {
            BigBomAplication.addLog(e.getMessage());
        }

        if (!(temp == null)) {
            ListProduto.add(temp);
        }
        observableList = FXCollections.observableList(ListProduto);
            id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
            description.setCellValueFactory(new PropertyValueFactory<Produto, String>("Descricao"));
            value.setCellValueFactory(new PropertyValueFactory<Produto, Double>("ValorFinal"));
            amount.setCellValueFactory(new PropertyValueFactory<Produto, Double>("Estoque"));
            unit.setCellValueFactory(new PropertyValueFactory<Produto, String>("Unidade"));
            carrinho.setItems(observableList);

            for (Produto a : observableList) {
                try {
                    double Total;
                    Total = a.getEstoque() * a.getValorFinal();
                    soma += Total;
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Produto não existe", ButtonType.OK);
                    alert.showAndWait();
                    BigBomAplication.addLog(e.getMessage());
                }
            }
            TotalItens.setText(String.valueOf(soma));
            BooleanBinding selected = carrinho.getSelectionModel().selectedItemProperty().isNull();
            btnDel.disableProperty().bind(selected);
            carrinho.getSelectionModel().selectedItemProperty().addListener((Obsval, Oldval, Newval) -> {
                if (Newval != null) {
                    Produto n = (Produto) Newval;
                    id.setText(String.valueOf(n.getId()));
                    amount.setText(String.valueOf(n.getEstoque()));
                }
            });
        }
    @FXML
    void remover(ActionEvent event) {
        Produto prod = new Produto();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja excluir?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            observableList.remove(carrinho.getSelectionModel().getFocusedIndex());
        }
        carrinho.refresh();
    }

    @FXML
    void Finalizar(ActionEvent event) {
        DaoProduto dao = new DaoProduto();
        dao.pesquisarTodos();

        for (Produto prod : observableList) {
            try {
                prod.setEstoque(dao.pesquisar(prod.getId()).getEstoque() - prod.getEstoque());
                dao.alterar(prod);
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Produto não existe", ButtonType.OK);
                alert.showAndWait();
                BigBomAplication.addLog(e.getMessage());
            }
        }
        int contador = 1;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cupom Fiscal");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put(String.valueOf(contador), new Object[]{"Id", "Descricao", "Quantidade", "Unidade", "Preço"});
        try {
            for (Produto produto : observableList) {
                contador++;
                data.put(String.valueOf(contador), new Object[]{produto.getId(), produto.getDescricao(), produto.getEstoque(), produto.getUnidade(), produto.getValorFinal()});
            }
        } catch (NullPointerException e) {
            BigBomAplication.addLog(e.getMessage());
        }
        contador++;
        data.put(String.valueOf(contador),  new Object[]{"", "", "", "Valor total:", TotalItens});
        Set<String> keyset = data.keySet();
        int rownum = 0;

        for(String key: keyset){
            Row row = sheet.createRow(rownum++);
            Object[] objarr = data.get(key);
            int cellnum = 0;

            for(Object obj: objarr){
                Cell linha = row.createCell(cellnum++);
                if (obj instanceof String){
                    linha.setCellValue((String) obj);
                }
                else if (obj instanceof Integer){
                    linha.setCellValue((Integer) obj);
                }
                else if (obj instanceof Double){
                    linha.setCellValue((Double) obj);
                } else if (obj instanceof Label){
                    linha.setCellValue(((Label) obj).getText());
                }
            }
        }

        try{
            FileOutputStream os = new FileOutputStream("CupomFiscal.xlsx");
            workbook.write(os);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cupom fiscal gerado com sucesso!", ButtonType.OK);
            alert.showAndWait();
            workbook.close();
        } catch (FileNotFoundException e) {
            BigBomAplication.addLog(e.getMessage());
        } catch (IOException e) {
            BigBomAplication.addLog(e.getMessage());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao gerar nota", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        carrinho.getItems().clear();
        TotalItens.setText("0");
    }

    @FXML
    void Return(ActionEvent event) {
        ((Stage)TxtProduto.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    void refresh(){
        carrinho.getItems().removeAll();
        carrinho.setItems(observableList);
    }
}