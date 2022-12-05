//Alysson
//Mauricio fez a parte do log de erro

package com.example.demo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto implements Dao {
    @Override
    public boolean adicionar(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantesProduto.INSERT);
            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getValorFinal());
            stmt.setDouble(3, prod.getEstoque());
            stmt.setString(4, prod.getUnidade());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao inserir", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso", ButtonType.OK);
        alert.showAndWait();
        return true;
    }

    @Override
    public boolean alterar(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantesProduto.UPDATE);
            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getValorFinal());
            stmt.setDouble(3, prod.getEstoque());
            stmt.setString(4, prod.getUnidade());
            stmt.setInt(5, prod.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao alterar", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alterado com sucesso", ButtonType.OK);
        alert.showAndWait();
        return true;
    }

    @Override
    public boolean remover(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantesProduto.REMOVE);
            stmt.setInt(1, prod.getId());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro na remoção", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Removido com sucesso", ButtonType.OK);
        alert.showAndWait();
        return true;

    }

    @Override
    public Produto pesquisar(Object o) {
        Integer integer = (Integer) o;
        List<Object> todos = new DaoProduto().pesquisarTodos();

        for (Object pp : todos) {
            Produto prod = (Produto) pp;
            if (prod.getId() == integer) {
                return prod;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING, "Produto com o código " + o + " não foi encontrado!", ButtonType.OK);
        alert.showAndWait();
        return null;
    }

    @Override
    public List<Object> pesquisarTodos() {
        List<Object> produtos = new ArrayList<>();
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantesProduto.SEARCH);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setDescricao(rs.getString("Description"));
                prod.setValorFinal(rs.getDouble("Value"));
                prod.setEstoque(rs.getInt("Amount"));
                prod.setUnidade(rs.getString("Unit"));
                produtos.add(prod);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao pesquisar produtos!!", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        return produtos;
    }

    public boolean pesquisaProd(Object o){
        Produto prod = (Produto) o;
        List<Object> produtos = pesquisarTodos();
        for (Object pp : produtos){
            if (((Produto)pp).equals(prod)){
                return true;
            }
        }
        return false;
    }
}
