
public class Aplicacao {
    public static void main (String[] args) {
        Circulo cA = new Circulo(1, 1, 2);
        Circulo cB = new Circulo(3, 0, 3);
        Circulo cC = new Circulo(2, 2, 2);
        Circulo cD = new Circulo(-5, 4, 5);

        // mais facil que ficar copiar e colando :v
        Circulo cArray[] = {cA, cB, cC, cD};

        // PARTE 4
        loopTarefa(cArray);
        // output:
        /*
        C1 = {(1.0, 1.0), 2.0}
        C2 = {(3.0, 0.0), 3.0}
        C3 = {(2.0, 2.0), 2.0}
        C4 = {(-5.0, 4.0), 5.0}
        C1 e C2 se sobrepoem
        C1 e C3 se sobrepoem
        C1 e C4 se sobrepoem
        C2 e C3 se sobrepoem
        C2 e C4 NAO se sobrepoem
        C3 e C4 NAO se sobrepoem
        */

        cA.move("baixo", 1); cA.move("esquerda", 1); 
        cB.move("direita", 6); cA.move("cima", 5); 
        cC.move("cima", 2);
        cD.move("cima", 2); cD.move("esquerda", 3); cD.move("baixo", 1); cD.move("esquerda", 1);

        // PARTE 5
        loopTarefa(cArray);
        // output:
        /*
        C1 = {(0.0, 5.0), 2.0}
        C2 = {(9.0, 0.0), 3.0}
        C3 = {(2.0, 4.0), 2.0}
        C4 = {(-9.0, 5.0), 5.0}
        C1 e C2 NAO se sobrepoem
        C1 e C3 se sobrepoem
        C1 e C4 NAO se sobrepoem
        C2 e C3 NAO se sobrepoem
        C2 e C4 NAO se sobrepoem
        C3 e C4 NAO se sobrepoem
        */
    }

    public static void imprimeRelacaoCirculos (Circulo c1, Circulo c2) {
        if (Circulo.sobreposicao(c1, c2)) 
            System.out.println("C" + c1.getIdentificador() + " e C" + c2.getIdentificador() + " se sobrepoem");
        else
            System.out.println("C" + c1.getIdentificador() + " e C" + c2.getIdentificador() + " NAO se sobrepoem"); 
    }

    public static void loopTarefa (Circulo cArray[]) {
        for (int k=0; k < cArray.length; k++) cArray[k].imprime();
    
        for (int i=0; i < cArray.length; i++) {
            for (int j=i+1; j < cArray.length; j++) {
                if (i != j) imprimeRelacaoCirculos (cArray[i], cArray[j]);
            }
        }
    }
}

