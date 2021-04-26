import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
    ArrayList<String> frases;
    ArrayList<Jogador> jogadores;
    Jogador usuario;
    String arquivoRanking;

    public Jogo (String arquivoFrases, String arquivoRanking) {
        this.arquivoRanking = arquivoRanking;
        carregaFrases(arquivoFrases);
        carregaRanking(arquivoRanking);
    }

    private void carregaFrases (String nomeArquivo) {
        // ler textos do banco de frases
        frases = (ArrayList) ManipuladorSerializaveis.desserializa(nomeArquivo);
    }

    private void carregaRanking (String nomeArquivo) {
        // ler os 3 melhores jogadores
        jogadores = (ArrayList) ManipuladorSerializaveis.desserializa(nomeArquivo);
    }

    public void pedeNome () {
        // pedir nome usuario e instanciar jogador
        System.out.println("digite seu nome:");
        Scanner in = new Scanner(System.in);

        String nomeUsuario = in.nextLine();
        usuario = new Jogador(nomeUsuario);
    }

    public void pedeFrase () {
        // selecionar frase e contar tempo de digitacao
        Random rand = new Random();
        String frase = frases.get(rand.nextInt(frases.size()));
        System.out.println("digite: " + frase);

        Scanner in = new Scanner(System.in);
        double startTime = System.nanoTime();

        String fraseDigitada = in.nextLine();

        double endTime = System.nanoTime();
        double timeElapsed = (endTime - startTime) / 1000000000;

        // checar digitacao e contabilizar score
        if (fraseDigitada.equals(frase)) {
            usuario.setScore(frase.length()/timeElapsed);
        }

        else {
            usuario.setScore(0);
            System.out.println("digitacao errada :(");
        }
    }

    public void atualizaRanking () {
        // atualizar e mostrar ranking dos 3 melhores jogadores
        jogadores.add(usuario);
        jogadores.sort(new Ordenador());
        jogadores.remove(3);
    }

    public void mostraRanking () {
        for (Jogador j : jogadores) System.out.println(j);
    }
     
    public void salvaRanking () {
        // salvar novo ranking dos melhores 3 jogadores
        ManipuladorSerializaveis.serializa(arquivoRanking, jogadores);
    }

    public void mostraMenu () {
        System.out.printf("\n");

        System.out.println("=== MENU ===");
        System.out.println("1   jogar");
        System.out.println("2   mostrar ranking");
        System.out.println("3   sair");

        System.out.printf("\n");

        Scanner in = new Scanner(System.in);
        String opcao = in.nextLine();

        boolean check = false;

        while (check == false) {
            if (opcao.equals("1")) {
                check = true;
                pedeFrase();
                atualizaRanking();
                salvaRanking();
            }

            else if (opcao.equals("2")) {
                check = true;
                mostraRanking();
            }

            else if (opcao.equals("3")) {
                System.exit(0);
            }

            else {
                System.out.println("por favor escolha entre as opcoes validas!");
                opcao = in.nextLine();
            }
        }

        mostraMenu();
    }
}
