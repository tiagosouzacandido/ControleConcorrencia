/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

import java.util.Random;
/**
 *
 * @author casa
 */
public class Pote {

    private int moedas = 4;
    private int[] caminho;
    
    public Pote(int[] array){
        this.caminho = array;
    }

    public synchronized void acrescentarMoeda() {
        while (moedas > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        moedas = 1;
        System.out.println("Colocada uma moeda no pote");
        notifyAll();
    }

    public synchronized int tirarMoeda() throws InterruptedException {
        int coletadas = 0;

        while (moedas == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (coletadas < 3 && moedas > 0) {
            Thread.sleep(100);
            moedas--;
            coletadas++;
        }
        notifyAll();
        return coletadas;
    }
    
    public int getCaminho(){
        Random random = new Random();
        int posicao = random.nextInt(caminho.length);
        int i = caminho[posicao];
        return i;
    }
}
