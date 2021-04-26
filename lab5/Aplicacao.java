public class Aplicacao {
    public static void main (String[] args) {
        Produto produto1 = new Produto("jPhone", 500, 6999.00);
        Produto produto2 = new Produto("airBuds", 1500, 500.00);
        Produto produto3 = new Produto("Pear watch", 800, 2999.00);
        Produto produto4 = new Produto("Carregador sem fio", 250, 250.00);
        Produto produto5 = new Produto("Carregador com fio", 10, 69.90);

        Cliente cliente1 = new ClientePFisica("04/03/2021", "Fulano de Tal", "123.456.789-10");
        Cliente cliente2 = new ClientePJuridica("09/12/2019", "Beltrana & Beltrano comercio de eletronicos", "12.345.678/0009-10");


        int numeroParcelas1 = 2;
        int numeroParcelas2 = 1;

        Venda venda1 = new Venda(cliente1, "04/03/2021", numeroParcelas1);
        Venda venda2 = new Venda(cliente2, "04/03/2021", numeroParcelas2);

        // pessoa fisica
        venda1.registraProduto(produto1, 1);
        venda1.registraProduto(produto5, 1);

        // pessoa juridica
        venda2.registraProduto(produto1, 200);
        venda2.registraProduto(produto3, 200);

        double valorTotal1 = venda1.calculaTotal();
        double valorTotal2 = venda2.calculaTotal();

        // pessoa fisica
        venda1.registraPagamento("09/03/2021", valorTotal1/numeroParcelas1, 0);
        venda1.registraPagamento("09/04/2021", valorTotal1/numeroParcelas1, 1);

        // pessoa juridica
        venda2.registraPagamento("09/03/2021", valorTotal2/numeroParcelas2, 0);

        venda1.imprimeRecibo();
        venda2.imprimeRecibo();
    }
}
