// Maurício
package com.example.demo;

import java.math.BigDecimal;

public class    Produto {
    private int id;
    private String descricao;
    private static double valorFinal;
    private double estoque;
    private String unidade;

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade.toUpperCase();
    }

    @Override
    public String toString(){
        return "Id: " + id
        + System.lineSeparator() + "Descrição: " + descricao
        + System.lineSeparator() + "Estoque: " + estoque
        + System.lineSeparator() + "Valor Final: " + valorFinal
        + System.lineSeparator() + "Unidade: " + unidade;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto other = (Produto) o;
        return this.getId() == other.getId();
    }
}
