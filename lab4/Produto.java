public class Produto {
    private String descricao;
    private int quantidadeEstoque;
    private double valor;

    public Produto (String descricao, int quantidadeEstoque, double valor) {
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valor = valor;
    }

    // getters
    public String getDescricao () {
        return descricao;
    }
    
    public int getQuantidadeEstoque () {
        return quantidadeEstoque;
    }

    public double getValor () {
        return valor;
    }

    // setters
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
    
    public void setQuantidadeEstoque (int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setValor (double valor) {
        this.valor = valor;
    }
}
