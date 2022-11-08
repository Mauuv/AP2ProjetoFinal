
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
}
