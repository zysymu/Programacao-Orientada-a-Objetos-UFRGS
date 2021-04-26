public class ClientePJuridica extends Cliente {
    private String razaoSocial;
    private String cnpj;

    public ClientePJuridica (String data, String razaoSocial, String cnpj) {
        super(data);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public void imprimeDados () {
        System.out.println("Cliente: #" + getIdentificador());
        System.out.println("Data de cadastro: " + getDataCadastro());
        System.out.println("Razao social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
    }

    // getters
    public String getRazaoSocial () {
        return razaoSocial;
    }

    public String getCnpj () {
        return cnpj;
    }
}   
