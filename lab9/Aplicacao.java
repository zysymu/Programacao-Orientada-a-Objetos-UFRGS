import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Aplicacao {
    public static void main (String[] args) {
        String base = "/home/marcostidball/Documents/study-notes/Programacao-Orientada-a-Objetos-INF01057/lab9/";

        Jogo jogo = new Jogo(base + "bancodefrases.poo", base + "top3ranking.poo");

        jogo.pedeNome();
        jogo.mostraMenu();
    }
}
