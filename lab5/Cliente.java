public class Cliente {
    private static int contador = 1;
    private int identificador;
    private String dataCadastro;

    public Cliente (String dataCadastro) {
        this.dataCadastro = dataCadastro;
        identificador = contador;
        contador++;
    }

    public void imprimeDados () {
        System.out.println("Cliente: #" + getIdentificador());
        System.out.println("Data de cadastro: " + getDataCadastro());
    }

    // getters
    public String getDataCadastro () {
        return dataCadastro;
    }
    
    public int getIdentificador () {
        return identificador;
    }
}
