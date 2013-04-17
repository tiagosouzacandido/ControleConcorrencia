/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

/**
 *
 * @author Tiago
 */
public class Cacador {
    
    private int moedas;
    private boolean venceu;
    
    public Cacador(){
        moedas = 0;
        venceu = false;
    }
    
    public boolean getVenceu(){
        return venceu;
    }
    
    public void setVenceu(){
        venceu = true;
    }
    
    public void setMoedas(int quant){
        moedas+=quant;
        if (moedas >= 50){
            setVenceu();
        }
    }
    
    public int getMoedas(){
        return moedas;
    }
}
