package ponto;

public class PontoPainel8x6 {
    private int x;
    private int y;

    // reset
    private void reset () {
        x = 0;
        y = 0;
    }

    // setters
    public boolean setX (int x) {
        if (x >= 0 && x < 6) {
            this.x = x;
            return true;
        }

        else {
            reset();
            return false;
        }
    }

    public boolean setY (int y) {
        if (y >= 0 && y < 8) {
            this.y = y;
            return true;
        }
    
        else {
            reset();
            return false;
        }
    }

    // getters
    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    // misc
    public void imprime () {
        System.out.printf("(%d, %d)\n", x, y);
    }

    private int intAbs (int x) {
        if (x < 0) return -x;
        else return x;
    }

    public int distancia (PontoPainel8x6 p) {
        return intAbs(this.x - p.getX()) + intAbs(this.y - p.getY());
    }
}
