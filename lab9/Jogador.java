import java.io.Serializable;
import java.lang.Math;

public class Jogador implements Serializable {
    private String nome;
    private double score = 0.0;

    public Jogador (String nome, double score) {
        this.nome = nome;
        this.score = score;
    }

    public Jogador (String nome) {
        this.nome = nome;
        //this.score = null;
    }

    public void setScore (double score) {
        score = Math.round(score * 100.0) / 100.0;

        if (score > this.score)
            this.score = score;
    }

    public double getScore () {
        return score;
    }

    public String toString() {
        return nome + " (" + score + ") c/s"; // caracteres por segundo
    }
}
