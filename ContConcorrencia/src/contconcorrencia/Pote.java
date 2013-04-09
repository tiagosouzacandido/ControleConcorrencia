/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

/**
 *
 * @author casa
 */
public class Pote {

    private int moedas = 4;

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
	while (moedas == 0) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
        Thread.sleep(100);
	System.out.println("Cachorro (" + Thread.currentThread().getName()
		+ ") pegou uma moeda ");
	moedas--;
	notifyAll();
	return 1;
    } 
}
