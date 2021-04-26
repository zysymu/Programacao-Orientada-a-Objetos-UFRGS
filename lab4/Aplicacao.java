public class Aplicacao {
    public static void main (String[] args) {
        Produto produto1 = new Produto("jPhone", 500, 6999.00);
        Produto produto2 = new Produto("airBuds", 1500, 500.00);
        Produto produto3 = new Produto("Pear watch", 800, 2999.00);
        Produto produto4 = new Produto("Carregador sem fio", 250, 250.00);
        Produto produto5 = new Produto("Carregador com fio", 10, 69.90);

        int numeroParcelas = 4;
        Venda venda = new Venda("123.456.789-10", "04/03/2021", numeroParcelas);
        venda.registraProduto(produto1, 2);
        venda.registraProduto(produto2, 2);
        venda.registraProduto(produto3, 1);
        venda.registraProduto(produto4, 1);
        venda.registraProduto(produto5, 2);

        double valorTotal = venda.calculaTotal();

        venda.registraPagamento("04/03/2021", valorTotal/numeroParcelas, 0);
        venda.registraPagamento("04/04/2021", valorTotal/numeroParcelas, 1);
        venda.registraPagamento("04/05/2021", valorTotal/numeroParcelas, 2);
        venda.registraPagamento("04/06/2021", valorTotal/numeroParcelas, 3);

        venda.imprimeRecibo();
    }
}
