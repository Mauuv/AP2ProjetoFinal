import java.math.BigDecimal;

public class Produto {
    private int id;
    private String descricao;
    private BigDecimal valorFinal;
    private int estoque;

    public Produto(String descricao, BigDecimal valorFinal, int estoque) {
        this.descricao = descricao;
        this.valorFinal = valorFinal;
        this.estoque = estoque;
    }

    public Produto(int estoque, String descricao) {
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
}
