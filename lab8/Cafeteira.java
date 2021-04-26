import excecoes.*;

public class Cafeteira{

    private double nivelCafe;
    private double nivelAgua;
    private double nivelLeite;
    
    public Cafeteira(){
        this.nivelCafe = 0; 
        this.nivelAgua = 0;
        this.nivelLeite = 0;
    }
    
    /* Anunciar e lançar exceções: NivelMuitoBaixoCafeException, NivelMuitoBaixoAguaException e NivelMuitoBaixoLeiteException! */
    public void pedir (String cafe) throws NivelMuitoBaixoCafeException, NivelMuitoBaixoAguaException, NivelMuitoBaixoLeiteException {
        double quantCafe, quantAgua, quantLeite;
        if (cafe.equals("Latte")) {
             quantCafe = 30;
             quantAgua = 40;
             quantLeite = 130;
        }
        else if (cafe.equals("Expresso")) {
             quantCafe = 30;
             quantAgua = 70;
             quantLeite = 0;
        }
        else{
             quantCafe = 40;
             quantAgua = 160;
             quantLeite = 0;
        }

        if (nivelCafe < quantCafe)
            throw new NivelMuitoBaixoCafeException();
        if (nivelAgua < quantAgua)
            throw new NivelMuitoBaixoAguaException();
        if (nivelLeite < quantLeite)
            throw new NivelMuitoBaixoLeiteException();

        this.nivelCafe -= quantCafe;
        this.nivelAgua -= quantAgua;
        this.nivelLeite -= quantLeite;        
    }
    
    /* Anunciar e lançar exceção NivelMuitoAltoCafeException! */
    public void completarNivelCafe (double quantidade) throws NivelMuitoAltoCafeException {
        if(this.nivelCafe < 400) // Cabe 0,5 quilograma (Se o nível atual é menor que 400g, então adicionamos quantidade! Senão, considera-se quase cheio! )
           this.nivelCafe += quantidade;

        else throw new NivelMuitoAltoCafeException();
    }

    /* Anunciar e lançar exceção NivelMuitoAltoAguaException! */
    public void completarNivelAgua (double quantidade) throws NivelMuitoAltoAguaException {
        if(this.nivelAgua < 900) // Cabe 1 litro (Se o nível atual é menor que 900ml, então adicionamos quantidade! Senão, considera-se quase cheio! )
           this.nivelAgua += quantidade;

        else throw new NivelMuitoAltoAguaException();
    }

    /* Anunciar e lançar exceção NivelMuitoAltoLeiteException! */
    public void completarNivelLeite (double quantidade) throws NivelMuitoAltoLeiteException {
        if(this.nivelLeite < 400) // Cabe 0,5 litro (Se o nível atual é menor que 400ml, então adicionamos quantidade! Senão, considera-se quase cheio! )
           this.nivelLeite += quantidade;

        else throw new NivelMuitoAltoLeiteException();
    }
    
    public String toString(){
        return "Café: " + this.nivelCafe + " | Água: " + this.nivelAgua + " | Leite: " + this.nivelLeite;
    }

}
