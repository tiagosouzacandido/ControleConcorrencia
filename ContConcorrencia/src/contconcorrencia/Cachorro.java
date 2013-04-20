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
    private int contador = 0; 
    private Pote pote;
    private Bosque bosque;

    public Cachorro(Bosque bosque,Pote pote, String nome) {
        this.setName(nome);
	this.pote = pote;
        moedasColetadas.set(0);
        this.bosque = bosque;
    }

    @Override
    public void run() {
        
        moedasColetadas.set(new Integer(contador));
        while (contador<20){
            try {
                int coletadas = pote.tirarMoeda();
                contador+=coletadas;
                System.out.println( getName() + " está com " + contador + " moedas.");
                int caminho = pote.getCaminho();
                pote = bosque.getPote(caminho);
                System.out.println( getName() + " entrou no pote " + caminho + ".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        moedasColetadas.set(new Integer(contador));
        System.out.println( getName() + " conseguiu " + contador + " moedas.");
        int valor = ((Integer)moedasColetadas.get()).intValue();
        System.out.println(getName() + " Nº de moedas local = " + valor);
    }
}
