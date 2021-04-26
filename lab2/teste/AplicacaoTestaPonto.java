package teste;

import java.util.Scanner;
import ponto.PontoPainel8x6;

public class AplicacaoTestaPonto {
    public static void main (String[] args) {
        PontoPainel8x6 p1, p2;

        // PARTE 3
        p1 = new PontoPainel8x6();
        p1 = entradaXY(p1, "1");
        p1.imprime();

        p2 = new PontoPainel8x6();
        p2 = entradaXY(p2, "2");
        p2.imprime();

        // PARTE 4
        int d = p1.distancia(p2);
        System.out.printf("distancia entre p1 e p2 eh: %d\n", d);

        int MAXY = 8, MAXX = 6;
        for (int y=0; y<MAXY; y++) {
            for (int x=0; x<MAXX; x++) {
                if ((p1.getX() == x && p1.getY() == y) || (p2.getX() == x && p2.getY() == y)) System.out.print(" x ");

                else System.out.print(" - ");
            }
        System.out.println("");
        }
    }

    static PontoPainel8x6 entradaXY (PontoPainel8x6 p, String s) {
        int x, y;
        boolean x_b, y_b;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.println("digite um inteiro para o x do ponto " + s);
            x = leitor.nextInt();
            System.out.println("digite um inteiro para o y do ponto " + s);        
            y = leitor.nextInt();

            x_b = p.setX(x); 
            y_b = p.setY(y);
        } while (x_b == false || y_b == false);

        return p;
    }
}
