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
    static ThreadLocal valorLocal = new ThreadLocal();
    static int contador = 0;
    
    public void run() {
        System.out.println(getName() + ": Nº de moedas = " + contador);
        valorLocal.set(new Integer(contador++));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int valor = ((Integer)valorLocal.get()).intValue();
        System.out.println(getName() + ": Nº de moedas = " + valor);
    }
    
    public static void main (String args[]) {
        for (int i =0; i<10; i++)
            new Cachorro().start();
    }
}
