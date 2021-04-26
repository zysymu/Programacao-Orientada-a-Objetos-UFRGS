public class Veiculo {
    int ano;
    String marca;
    String modelo;
    double motor;
    double preco;
    char combustivel; // 'g' (gasolina) ou 'f' (flex)

    public void imprimeDados () {
        System.out.printf("\nano: %d; marca: %s; modelo: %s; motor: %f; preco: %f; combustivel: %s",
        ano, marca, modelo, motor, preco, combustivel);

        // nao usei println pois pareceu que precisava usar "string1" + var + "string2"
    }

    public void deprecia (double valor) {
        preco -= valor;
    }

    double calculaImposto () {
        if (motor <= 1) return (preco * (30.6/100)); // motor sempre vai ser ou 'g' ou 'f'
            
        else if (motor <= 2) {
            if (combustivel == 'g') return (preco * (36.6/100)); 
            else return (preco * (34.6/100));
        }

        else { // motor > 2
            if (combustivel == 'g') return (preco * (48.6/100));
            else return (preco * (41.6/100));
        }
    }
}
