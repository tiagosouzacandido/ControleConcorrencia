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
    private String nome;
    
    public Cacador(String nome){
        moedas = 0;
        venceu = false;
        this.nome=nome;
    }
    
    public boolean getVenceu(){
        return venceu;
    }
    
    public void setVenceu(){
        venceu = true;
        Cachorro.running=false;
        System.out.println("---------------Caçador "+nome+" venceu.------------------");
    }
    
    public void setMoedas(int quant){
        moedas+=quant;
        if (moedas >= 50){
            setVenceu();
        }
        System.out.println("Caçador "+nome+" está com " + moedas +" moedas.");
    }
    
    public int getMoedas(){
        return moedas;
    }
}
