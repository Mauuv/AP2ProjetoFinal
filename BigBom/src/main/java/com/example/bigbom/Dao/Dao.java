package com.example.bigbom.Dao;

import java.util.List;

public interface Dao {

    public boolean Adicionar(Object m);

    public boolean Alterar(Object m);

    public boolean Remover(Object m);

    public boolean Pesquisar(Object m);

    public List<Object> PesquisaTodos();



}
