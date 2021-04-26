package app;

import contribuintes.*;
import sistema.*;

public class Aplicacao {
    public static void main(String[] args) {
        SistemaDeclaracaoIR sistema = new SistemaDeclaracaoIR();

        Contribuinte c1 = new ContribPFisica("Fulano de Tal", "123.456.789-10");
        Contribuinte c2 = new ContribPFisica("Cicrana de Tal", "123.456.789-11");
        Contribuinte c3 = new ContribPFisica("Beltrano de Tal", "123.456.789-12");
        Contribuinte c4 = new ContribPJuridica("ABC Fabrica de Roupas", "12.345.678/0009-10");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        c1.registraRendimento(40000);
        c2.registraRendimento(12000); c2.registraRendimento(5000); c2.registraRendimento(5000);
        c3.registraRendimento(36570);
        c4.registraRendimento(160000);

        c3.registraDeducao(1230);
        c4.registraDeducao(10500);

        sistema.adicionaContribuinte(c1);
        sistema.adicionaContribuinte(c2);
        sistema.adicionaContribuinte(c3);
        sistema.adicionaContribuinte(c4);

        System.out.format("Rendimentos: %.2f\n", sistema.totalRendimentos());
        System.out.format("Restituicoes: %.2f\n", sistema.totalRestituicoes());
        System.out.format("Balanco: %.2f\n", sistema.balanco());
    }
}
