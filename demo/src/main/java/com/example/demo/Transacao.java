package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Transacao {
    private int numeroTransacao;
    private FormaPagamento formaPagamento;
    private ArrayList<Produto> itens = new ArrayList<>();
    private BigDecimal valorTotal;
    private String CPF;
    private boolean status;

    public Transacao(FormaPagamento formaPagamento, ArrayList<Produto> itens, BigDecimal valorTotal, String CPF) {
        this.formaPagamento = formaPagamento;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.CPF = CPF;
        this.status = true;
    }

    public Transacao(FormaPagamento formaPagamento, ArrayList<Produto> itens, BigDecimal valorTotal) {
        this.formaPagamento = formaPagamento;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.status = true;
    }

    // fazer
    public boolean cancelarTransacao(){
        // implementar equals para validar qual vai ser cancelada
        this.status = false;
        return true; // caso teha sido cancelada
    }

    public int getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
            @Override
    public String toString(){
        return "Numero da Transação: " + numeroTransacao
        + System.lineSeparator() + "Forma de pagamento: " + formaPagamento.getNome()
        + System.lineSeparator() + "Itens: " + itens
        + System.lineSeparator() + "Valor Total: " + valorTotal
        + System.lineSeparator() + "CPF: " + CPF
        + System.lineSeparator() + "Válida: " + status;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao)) return false;
        Transacao other = (Transacao) o;
        return this.getNumeroTransacao() == other.getNumeroTransacao();
    }
}
