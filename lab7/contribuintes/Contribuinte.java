package contribuintes;

public abstract class Contribuinte {
    private String nome;
    protected double rendas;
    protected double deducoes;

    public Contribuinte (String nome) {
        this.nome = nome;
        rendas = 0;
        deducoes = 0;
    }

    public String toString () {
        return nome;
    }

    public void registraRendimento (double valor) {
        rendas += valor;
    }

    public void registraDeducao (double valor) {
        deducoes += valor;
    }

    public abstract double calculaImposto ();

    public String getNome () {
        return nome;
    }

    public double getRendas () {
        return rendas;
    }

    public double getDeducoes () {
        return deducoes;
    }
}
