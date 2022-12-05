//Alysson

package com.example.demo;

import java.util.List;

public interface Dao {

    public boolean adicionar(Object o);
    public boolean alterar(Object o);
    public boolean remover(Object o);
    public Object pesquisar(Object o);
    public List<Object> pesquisarTodos();


}
