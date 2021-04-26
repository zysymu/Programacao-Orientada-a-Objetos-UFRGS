import java.lang.Math;

public class Circulo {
    // atributos de instancia
    private double x;
    private double y;
    private double raio;
    private int identificador;

    // atributos de classe
    private static int numCirculos = 0;
    private static final double PI = 3.1415;

    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;

        Circulo.numCirculos++;
        identificador = numCirculos;
    }

    public void move(String direcao, double deslocamento) {
        if (direcao.equals("direita")) x += deslocamento;
        else if (direcao.equals("esquerda")) x -= deslocamento;
        else if (direcao.equals("cima")) y += deslocamento;
        else if (direcao.equals("baixo")) y -= deslocamento;
    }

    public double area() {
        return Circulo.PI * raio;
    }

    public double circunferencia() {
        return 2*Circulo.PI*raio;
    }

    public void imprime() {
        System.out.printf("C%d = {(%.1f, %.1f), %.1f}\n", identificador, x, y, raio);
    }

    public int getIdentificador() {
        return identificador;
    }

    public static boolean sobreposicao (Circulo c1, Circulo c2) {
        if (Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2) <= Math.pow(c1.raio + c2.raio, 2)) return true;
        else return false;
    }
}
