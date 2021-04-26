import excecoes.*;

public class Estoque{

    private double quantidade;
    private String descricao;

    public Estoque(String descricao, double quantidade){
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void reporEstoque(double quantidade){
        this.quantidade += quantidade;
    }
    
    /* Anunciar e lançar exceção FaltaEstoqueException! */
    public double get100MililitrosOUGramas () throws FaltaEstoqueException {
        if (quantidade < 100)
            throw new FaltaEstoqueException(descricao + " em falta!");
        
        this.quantidade -= 100;
        return 100;
    }
}
