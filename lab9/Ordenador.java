import java.util.Comparator;

public class Ordenador implements Comparator<Jogador> {
    public int compare (Jogador jogador1, Jogador jogador2) {
        return Double.compare(jogador2.getScore(), jogador1.getScore());
    }
}
