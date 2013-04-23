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

    private int numeroPote;
    private int moedas = 4;
    private int[] caminho;
    
    public Pote(int[] array,int numPote){
        this.caminho = array;
        this.numeroPote=numPote;
    }

    /**
     * Metodo utilizado pelo cachorro salva vidas 
     * para acrescentar uma moeda ao pote.
     */
    public synchronized void acrescentarMoeda() {
        moedas = 1;
        System.out.println("Colocada uma moeda no pote " + numeroPote);
        notifyAll();
    }

    /**
     * Metodo utilizado pelos cachorros para coletar ate tres moedas do pote
     * @return numero de moedas coletadas
     * @throws InterruptedException 
     */
    public synchronized int tirarMoeda() throws InterruptedException {
        int coletadas = 0;

        while (moedas == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        while (coletadas < 3 && moedas > 0) {
            moedas--;
            coletadas++;
        }
        Thread.sleep(100);
        notifyAll();
        return coletadas;
    }
    
    /**
     * Metodo para pegar um dos caminhos para o proximo pote de forma aleatoria
     * @return numero do proximo pote
     */
    public int getCaminho(){
        Random random = new Random();
        int posicao = random.nextInt(caminho.length);
        int numPote = caminho[posicao];
        return numPote;
    }
    
    /**
     * Metodo para saber se pote esta vazio.
     * @return true para vazio e false para nao vazio
     */
    public boolean isVazio(){
        if (moedas == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
