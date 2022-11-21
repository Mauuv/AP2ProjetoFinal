package com.example.demo;

public enum FormaPagamento {
    DINHEIRO("Dinheiro")
    ,CARTAO_CREDITO("Cartão de credito")
    ,CARTAO_DEBITO("Cartão de debito")
    ,VALE("Vale alimentação");
    public String nome;

    FormaPagamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public static FormaPagamento escolheFormaPagamento(int opcao){
        return FormaPagamento.values()[opcao - 1];
    }

    }
