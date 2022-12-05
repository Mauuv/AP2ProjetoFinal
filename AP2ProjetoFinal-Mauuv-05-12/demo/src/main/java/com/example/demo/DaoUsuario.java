//Mauricio

package com.example.demo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario implements Dao{
    @Override
    public boolean adicionar(Object o) {
        return false;
    }

    @Override
    public boolean alterar(Object o) {
        return false;
    }

    @Override
    public boolean remover(Object o) {
        return false;
    }

    @Override
    public Object pesquisar(Object o) {
        Usuario usuario = (Usuario) o;
        List<Object> todos = new DaoUsuario().pesquisarTodos();
        for (Object obj : todos){
            Usuario user = (Usuario) obj;
            if(user.equals(usuario)){
                return true;
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "Usuário não encontrado!", ButtonType.OK);
                alert.showAndWait();
            }
        }
        return false;

    }

    @Override
    public List<Object> pesquisarTodos() {
        List<Object> usuarios = new ArrayList<>();
        try{
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SqlConstantesUsuario.SEARCH);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("User"));
                user.setSenha(rs.getString("PASSWORD"));
                usuarios.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao pesquisar usuário!!", ButtonType.OK);
            alert.showAndWait();
            BigBomAplication.addLog(e.getMessage());
        }
        return usuarios;
    }
}
