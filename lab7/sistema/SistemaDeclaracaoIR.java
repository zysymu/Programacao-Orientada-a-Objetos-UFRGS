package sistema;

import contribuintes.*;
import java.util.ArrayList;
import java.io.*;

public class SistemaDeclaracaoIR {
    ArrayList<Contribuinte> contribuintes;

    public SistemaDeclaracaoIR () {
        contribuintes = new ArrayList<Contribuinte>();
    }

    public void adicionaContribuinte (Contribuinte contribuinte) {
        contribuintes.add(contribuinte);
    }

    public double totalRendimentos () {
        double totalRendas = 0;
        double imposto;

        for (Contribuinte c : contribuintes) {
            imposto = c.calculaImposto();
            if (imposto > 0) totalRendas += imposto;
        }

        return totalRendas;
    }

    public double totalRestituicoes () {
        double totalDeducoes = 0;
        double imposto;

        for (Contribuinte c : contribuintes) {
            imposto = c.calculaImposto();
            if (imposto < 0) totalDeducoes -= imposto;
        }

        return totalDeducoes;
    }

    public double balanco () {
        return totalRendimentos() - totalRestituicoes();
    }
}
