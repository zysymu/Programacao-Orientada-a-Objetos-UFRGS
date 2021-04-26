public class ProgramaPrincipal {
    public static void main (String[] args) {
    double imposto;

    // declaracao e instanciacao do objeto
    Veiculo v1, v2, v3;
    v1 = new Veiculo();
    //v2 = new Veiculo();
    //v3 = new Veiculo();

    // atributos
    v1.ano = 2017;
    v1.marca = "GM";
    v1.modelo = "Onix";
    v1.motor = 1.0;
    v1.preco = 42000;
    v1.combustivel = 'f';

    // metodos
    v1.imprimeDados();
    v1.deprecia(540);
    v1.imprimeDados();
    imposto = v1.calculaImposto();
    System.out.printf("\no imposto sera de: %f R$", imposto);

    // PARTE 5
    // os veiculos sao iguais!
    v2 = v1;
    
    if (v1 == v2) System.out.println("\nveiculos sao iguais");
    else System.out.println("\nveiculos sao diferentes");

    // PARTE 6
    // temos que tanto v1 quanto v3 ficam com o preco = 0!

    v3 = v1;
    v3.preco = 0;
    v3.imprimeDados();
    v1.imprimeDados();
    }
}
