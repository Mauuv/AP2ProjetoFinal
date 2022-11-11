package com.example.bigbom.Model;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private int id;
    private String descricao;
    private BigDecimal valorFinal;
    private int estoque;

    public void Produto(String descricao, BigDecimal valorFinal, int estoque) {
        this.descricao = descricao;
        this.valorFinal = valorFinal;
        this.estoque = estoque;
    }

    public void Produto(int estoque, String descricao) {
        this.descricao = descricao;
        this.estoque = estoque;
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

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString(){
        return "Id: " + id
                + System.lineSeparator() + "Descrição: " + descricao
                + System.lineSeparator() + "Estoque: " + estoque
                + System.lineSeparator() + "Valor Final: " + valorFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getId() == produto.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
