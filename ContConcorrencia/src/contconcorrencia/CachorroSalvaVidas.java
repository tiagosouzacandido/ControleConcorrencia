/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;


/**
 *
 * @author Tiago
 */
public class CachorroSalvaVidas  extends Thread {
    
    /*public void run() {
        System.out.println(getName() + " executada.");
    }*/
    
    private Pote pote;

    public CachorroSalvaVidas(Pote buffer) {
	this.pote = buffer;
    }

    @Override
    public void run() {
        while(true){
            pote.acrescentarMoeda();
        }
    }
    
}
