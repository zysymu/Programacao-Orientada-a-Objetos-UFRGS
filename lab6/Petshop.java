import java.lang.Math;

public class Petshop{

    private Animal[] animais; /* Array de Animais do Petshop */
    private Cliente[] clientes; /* Array de Clientes do Petshop */
    private double[] aPagar; /* Array de valores a serem pagos pelos Clientes do Petshop */
    private int[] indiceDonosAnimais; /* Array de indices dos donos (Clientes) dos Animais do Petshop */

    private static final int maxAnimais = 400; /* Número máximo de Animais do Petshop */
    private static final int maxClientes = 200; /* Número máximo de Clientes do Petshop */

    private int contadorAnimais; /* Atributo para controlar o tamanho útil do array de Animais */
    private int contadorClientes; /* Atributo para controlar o tamanho útil do array de Clientes */
      
    /* 
       Construtor
       Implementar inicializações/instanciações 
    */
    public Petshop () {
        animais = new Animal[maxAnimais];
        clientes = new Cliente[maxClientes];
        aPagar = new double[maxClientes];
        indiceDonosAnimais = new int[maxAnimais];

        contadorAnimais = 0;
        contadorClientes = 0;
    }
   
    /* 
       Método: encontraAnimal
       Implementar funcionalidade de encontrar um Animal no array de Animais. 
       Lembre-se que o identificador de um Animal é único. 
       O método retorna -1 se não encontrar o Animal passado por argumento. 
    */
    public int encontraAnimal (int identificador) {
        if (animais == null) return -1;

        for (int i=0; i<contadorAnimais; i++) {
            if (animais[i].getIdentificador() == identificador) {
                return i;
            }
        }

        return -1;
    }
    
    /* 
       Método: encontraCliente
       Implementar funcionalidade de encontrar um Cliente no array de Clientes. 
       Lembre-se que o cpf de um Cliente é único. 
       O método retorna -1 se não encontrar o Cliente passado por argumento.
    */  
    public int encontraCliente (String cpf) {
        for (int i=0; i<contadorClientes; i++) {
            if (clientes[i].getCPF().equals(cpf)) {
                return i;
            }
        }

        return -1;
    }

    /* 
       Método: banho
       Implementar funcionalidade 'banho' em um Animal previamente registrado. 
       O método deve adicionar na posição adequada do array aPagar o valor a ser 
       pago pelo serviço. O serviço 'banho' em Gatos, Cachorros e outros Animais 
       custam 65,00, 70,00 e 50,00 reais, respectivamente. 
       Se o Animal não estiver registrado, não fazer nada além informar na tela 
       (usando System.err.println("Animal " + animal + " não registrado!");).
    */
    public void banho (Animal animal) {
        int idxAnimal = encontraAnimal(animal.getIdentificador());

        if (idxAnimal != -1) {
            double custo = animal.custoBanho();
            aPagar[indiceDonosAnimais[idxAnimal]] += custo;
        }

        else System.err.println("Animal " + animal + " não registrado!");
    }

    /* 
       Método: tosa
       Implementar funcionalidade 'tosa' em um Animal previamente registrado. 
       O método deve adicionar na posição adequada do array aPagar o valor a ser 
       pago pelo serviço. O serviço 'tosa' em Gatos, Cachorros e outros Animais 
       custam 80,00, 100,00 e 75,00 reais, respectivamente. 
       Se o Animal não estiver registrado, não fazer nada além informar na tela 
       (usando System.err.println("Animal " + animal + " não registrado!");).
    */ 
    public void tosa (Animal animal) {
        int idxAnimal = encontraAnimal(animal.getIdentificador());

        if (idxAnimal != -1) {
            double custo = animal.custoTosa();
            aPagar[indiceDonosAnimais[idxAnimal]] += custo;
        }

        else System.err.println("Animal " + animal + " não registrado!");
    }
    
    /* 
       Método: hospedagem
       Implementar funcionalidade 'hospedagem' de um Animal previamente registrado. 
       O método deve adicionar na posição adequada do array aPagar o valor a ser 
       pago pelo serviço. O serviço 'hospedagem' custa 
       (50,00 + 5 x quantidade de alimento diário do Animal(em quilogramas)) reais.
       Se o Animal não estiver registrado, não fazer nada além informar na tela 
       (usando System.err.println("Animal " + animal + " não registrado!");).
    */ 
    public void hospedagem (Animal animal, int dias) {
        int idxAnimal = encontraAnimal(animal.getIdentificador());

        if (idxAnimal != -1) {
            double custo = animal.custoHospedagem(dias);
            aPagar[indiceDonosAnimais[idxAnimal]] += custo;
        }

        else System.err.println("Animal " + animal + " não registrado!");
    }
    
    public void hospedagem (Animal animal) {
        hospedagem(animal, 1);
    }

    /* 
       Método: hospedagem
       Implementar funcionalidade 'hospedagem' de um Animal previamente registrado. 
       O método deve adicionar na posição adequada do array aPagar o valor a ser 
       pago pelo serviço. O serviço 'hospedagem' custa 
       ((50,00 + 5 x quantidade de alimento diário do Animal (em quilogramas)) x dias) reais.
       Se o Animal não estiver registrado, não fazer nada além informar na tela 
       (usando System.err.println("Animal " + animal + " não registrado!");).
    */   
       
    /* 
       Método: registraCliente
       Implementar funcionalidade de registrar um Cliente no array de Clientes. 
       Lembre-se de, antes, verificar se o Cliente a ser adicionado já não está registrado.
    */ 
    public void registraCliente (Cliente cliente) {
        int idxCliente = encontraCliente(cliente.getCPF());

        if (idxCliente == -1) {
                clientes[contadorClientes] = cliente;
                contadorClientes++;
        }
    }
    
    /* 
       Método: registraAnimal
       Implementar funcionalidade de registrar um Animal no array de Animais. 
       Lembre-se de, antes, verificar se o Animal a ser adicionado já não está registrado.
       Caso o Cliente associado não esteja registrado, deve-se registrá-lo adequadamente.
       O método deve manter o array indiceDonosAnimais. 
       O índice do Animal recém registrado no array de Animais serve como índice de
       indiceDonosAnimais, que armazena, nessa posição, o índice de seu dono (Cliente)
       no array de Clientes.
    */
    public void registraAnimal (Cliente clienteAssociado, Animal animal) {
        int idxAnimal = encontraAnimal(animal.getIdentificador());
        int idxCliente = encontraCliente(clienteAssociado.getCPF());
    
        if (idxCliente == -1) {
            registraCliente(clienteAssociado);
            idxCliente = contadorClientes - 1;
        }
        if (idxAnimal == -1) {
            animais[contadorAnimais] = animal;
            indiceDonosAnimais[contadorAnimais] = idxCliente;
            contadorAnimais++;
        }
    }
    
    /* 
       Método: imprimeAnimaisXClientes
       O método exibe na tela todos os animais registrados no Petshop juntamente de
       seus donos (Cliente). Clientes que não possuem animais registrados não são exibidos.
    */
    public void imprimeAnimaisXClientes(){
        System.out.println("Cliente\t\tAnimal");
        for(int indiceAnimal = 0; indiceAnimal < contadorAnimais; indiceAnimal++)
            System.out.println(clientes[indiceDonosAnimais[indiceAnimal]] + "\t" + animais[indiceAnimal]);
    }
    
    /* 
       Método: pagamento
       O método retorna o valor devido (isto é, o que foi gasto com os serviços 
       contratados para seu(s) animal(is)); O método também zera o valor a ser 
       pago no devido registro em aPagar.
    */ 
    public double pagamento(Cliente cliente){
        double valorPagamento = 0;
        int indiceCliente = encontraCliente(cliente.getCPF());
        if (indiceCliente != -1){
            valorPagamento = aPagar[indiceCliente];
            aPagar[indiceCliente] = 0;
        } 
        return Math.round(valorPagamento * 100.0) / 100.0;
    }
    
}
