package contribuintes;

public class ContribPFisica extends Contribuinte {
    private String cpf;

    public ContribPFisica (String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String toString () {
        return super.getNome() + " (" + cpf + ")";
    }

    public double calculaImposto () {
        double aliquota;
        double valorDeduzir;

        if (rendas <= 22847.76) {
            return 0;
        }

        else if (rendas > 22847.76 && rendas <= 33919.80) {
            aliquota = 0.075; valorDeduzir = 1713.58;
        }

        else if (rendas > 33919.80 && rendas <= 45012.60) {
            aliquota = 0.15; valorDeduzir = 4257.57;
        }

        else if (rendas > 45012.60 && rendas <= 55976.16) {
            aliquota = 0.225; valorDeduzir = 7633.51;
        }

        else {
            aliquota = 0.275; valorDeduzir = 10432.32;
        }

        return rendas * aliquota - valorDeduzir - deducoes;
    }

    public String getCPF () {
        return cpf;
    }
}
