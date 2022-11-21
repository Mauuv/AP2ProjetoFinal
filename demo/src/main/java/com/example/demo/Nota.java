package com.example.demo;

public class Nota {
    private int id;
    private int numeroTransacao;
    private final char TIPO = 's';

    public Nota(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public char getTIPO() {
        return TIPO;
    }
    
    @Override
    public String toString(){
        return "Número da nota: " + id
        + System.lineSeparator() + "Transação: " + numeroTransacao
        + System.lineSeparator() + "Tipo da nota: " + TIPO;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nota)) return false;
        Nota other = (Nota) o;
        return this.getNumeroTransacao() == other.getNumeroTransacao();
    }
}
