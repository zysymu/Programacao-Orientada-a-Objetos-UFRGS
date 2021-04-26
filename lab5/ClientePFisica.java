public class ClientePFisica extends Cliente {
    private String nome;
    private String cpf;

    public ClientePFisica (String data, String nome, String cpf) {
        super(data);
        this.nome = nome;
        this.cpf = cpf;
    }

    public void imprimeDados () {
        System.out.println("Cliente: #" + getIdentificador());
        System.out.println("Data de cadastro: " + getDataCadastro());
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

    // getters
    public String getNome () {
        return nome;
    }

    public String getCpf () {
        return cpf;
    }
}   
