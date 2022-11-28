package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class DaoProduto implements Dao {
    @Override
    public boolean adicionar(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantes.INSERT);
            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getValorFinal());
            stmt.setInt(3, prod.getEstoque());
            stmt.setString(4, prod.getUnidade());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados na tabela!");
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        return true;
    }

    @Override
    public boolean alterar(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantes.UPDATE);
            stmt.setString(1, prod.getDescricao());
            stmt.setDouble(2, prod.getValorFinal());
            stmt.setInt(3, prod.getEstoque());
            stmt.setString(4, prod.getUnidade());
            stmt.setInt(5, prod.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados do produto "+ prod.getDescricao());
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "Alterado com sucesso!!");

        return true;
    }

    @Override
    public boolean remover(Object o) {
        Produto prod = (Produto) o;
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantes.REMOVE);
            stmt.setInt(1, prod.getId());
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao remover produto " + prod.getDescricao());
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "Removido com sucesso!!");
        return true;

    }

    @Override
    public Produto pesquisar(int o) {
        List<Object> todos = new DaoProduto().pesquisarTodos();

        for (Object pp : todos){
            Produto prod = (Produto) pp;
            if(prod.getId() == o){
                return prod;
            }else{
                JOptionPane.showMessageDialog(null,"Produto com o código " + o + " não foi encontrado!");
            }
        }
        return null;
    }

    @Override
    public List<Object> pesquisarTodos() {
        List<Object> produtos = new ArrayList<>();
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantes.SEARCH);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto prod = new Produto();
                prod.setId(rs.getInt("ID"));
                prod.setDescricao(rs.getString("description"));
                prod.setValorFinal(rs.getDouble("value"));
                prod.setEstoque(rs.getInt("amount"));
                prod.setUnidade(rs.getString("unit"));
                produtos.add(prod);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar produtos!!");
            throw new RuntimeException(e);
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
