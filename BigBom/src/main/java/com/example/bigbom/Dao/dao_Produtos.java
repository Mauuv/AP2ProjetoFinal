package com.example.bigbom.Dao;

import com.example.bigbom.Model.SQLConstantes;
import com.example.bigbom.Model.Usuario;
import java.util.List;

public class dao_Produtos implements Dao{

    @Override
    public boolean Adicionar(Object m) {
        Usuario  user = (Usuario) m;
        String sql = SQLConstantes.INSERT;
        return false;
    }

    @Override
    public boolean Alterar(Object m) {
        return false;
    }

    @Override
    public boolean Remover(Object m) {
        return false;
    }

    @Override
    public boolean Pesquisar(Object m) {
        return false;
    }

    @Override
    public List<Object> PesquisaTodos() {
        return null;
    }
}
