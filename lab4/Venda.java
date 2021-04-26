public class Venda {
    private String cpf;
    private String data;
    private int contador;
    private int numeroParcelas;

    // atributo de classe
    private static int numeroNFe = 1;

    private int quantidades[];
    private Produto[] produtos;
    private Pagamento[] parcelas;

    private static final int maxVendas = 15;

    // construtor
    public Venda (String cpf, String data, int numeroParcelas) {
        this.cpf = cpf;
        this.data = data;
        
        if (1 <= numeroParcelas && numeroParcelas <= 10) this.numeroParcelas = numeroParcelas;
        else System.out.println("ERRO: numeroParcelas deve ser entre 1 e 10");

        quantidades = new int[Venda.maxVendas];
        produtos = new Produto[Venda.maxVendas];
        parcelas = new Pagamento[this.numeroParcelas+1];

        Venda.numeroNFe++;
        this.contador = 0;
    }

    public void registraProduto (Produto produto, int quantidade) {
        if (contador < Venda.maxVendas && quantidade <= produto.getQuantidadeEstoque()) {
            produtos[contador] = produto;
            quantidades[contador] = quantidade;
            
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            contador++;
        }

        else System.out.println("ERRO: numero maximo de vendas atingido ou produto esta fora de estoque");
    }

    public void registraPagamento (String data, double valor, int identificador) {
        if (identificador < numeroParcelas) {
            Pagamento pagamento = new Pagamento(data, valor);
            parcelas[identificador] = pagamento;
        }

        else System.out.println("ERRO: identificaor nao consta no numero de parcelas previstas");
    }

    public double calculaTotal () {
        double total = 0;

        for (int i=0; i<contador; i++) total += produtos[i].getValor() * quantidades[i];

        return total;
    }
    
    public void imprimeRecibo () {
        // primeira parte
        System.out.printf("Dados da venda\nCPF: %s\nData: %s\nTotal de produtos: %d\n", cpf, data, contador);

        // listando produtos
        double valorTotalProd;
        for (int i=0; i<contador; i++) {
            valorTotalProd = produtos[i].getValor() * quantidades[i];
            System.out.printf("%d.  %s  %d  %.2f\n", i, produtos[i].getDescricao(), quantidades[i], valorTotalProd);
        }

        // valor total
        System.out.printf("Valor total: R$ %.2f\n", calculaTotal());

        // parcelas
        System.out.printf("Parcelas:\n");
        for (int i=0; i<numeroParcelas; i++) {
            System.out.printf("%d.  %s  %.2f\n", i, parcelas[i].getData(), parcelas[i].getValor());
        }
    }
}
