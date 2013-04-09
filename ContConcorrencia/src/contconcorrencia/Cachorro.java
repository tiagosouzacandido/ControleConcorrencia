/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

/**
 *
 * @author Tiago
 */
public class Cachorro extends Thread {
    static ThreadLocal moedasColetadas = new ThreadLocal();
    static int contador = 0; 
    private Pote pote;

    public Cachorro(Pote buffer, String nome) {
        this.setName(nome);
	this.pote = buffer;
    }

    @Override
    public void run() {
        
        moedasColetadas.set(new Integer(contador));
        while (contador<20){
            try {
                pote.tirarMoeda();
                contador++;
                System.out.println("Cachorro (" + Thread.currentThread().getName()
		+ ") está com " + contador + " moedas.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        moedasColetadas.set(new Integer(contador));
        System.out.println("Cachorro (" + Thread.currentThread().getName()
		+ ") conseguiu " + contador + " moedas.");
        int valor = ((Integer)moedasColetadas.get()).intValue();
        System.out.println(getName() + "Nº de moedas local = " + valor);
    }
}
