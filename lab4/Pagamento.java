public class Pagamento {
    private String data;
    private double valor;

    public Pagamento (String data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    // getters
    public String getData () {
        return data;
    }

    public double getValor () {
        return valor;
    }

    // setters
    public void setData (String data) {
        this.data = data;
    }
    
    public void setValor (double valor) {
        this.valor = valor;
    }
}
