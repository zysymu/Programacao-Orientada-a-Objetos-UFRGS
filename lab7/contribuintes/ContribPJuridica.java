package contribuintes;

public class ContribPJuridica extends Contribuinte {
    private String cnpj;

    public ContribPJuridica (String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String toString () {
        return super.getNome() + " (" + cnpj + ")";
    }

    public double calculaImposto () {
        double aliquota;
        double valorDeduzir;

        if (rendas <= 180000) {
            aliquota = 0.04; return rendas * aliquota;
        }

        else if (rendas > 180000 && rendas <= 360000) {
            aliquota = 0.079; valorDeduzir = 5940;
        }

        else if (rendas > 360000 && rendas <= 720000) {
            aliquota = 0.1; valorDeduzir = 13860;
        }

        else if (rendas > 720000 && rendas <= 1800000) {
            aliquota = 0.112; valorDeduzir = 22500;
        }

        else if (rendas > 1800000 && rendas <= 3600000) {
            aliquota = 0.147; valorDeduzir = 85500;
        }

        else {
            aliquota = 0.3; valorDeduzir = 720000;
        }

        return rendas * aliquota - valorDeduzir - deducoes;
    }

    public String getCNPJ () {
        return cnpj;
    }
}
