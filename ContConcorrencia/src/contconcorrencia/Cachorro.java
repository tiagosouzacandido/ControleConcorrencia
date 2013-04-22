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

    //static ThreadLocal moedasColetadas = new ThreadLocal();
    private int contador = 0;
    private Pote pote;
    private Bosque bosque;
    private Cacador cacador;

    public Cachorro(Cacador cacador, Bosque bosque, Pote pote, String nome) {
        this.setName(nome);
        this.pote = pote;
        //moedasColetadas.set(0);
        this.bosque = bosque;
        this.cacador = cacador;
    }

    @Override
    public void run() {

        //moedasColetadas.set(new Integer(contador));

        //while (!cacador.getVenceu()) {
        while (contador < 20 && cacador.getMoedas() + contador < 50) {
            try {
                int coletadas = pote.tirarMoeda();
                contador += coletadas;
                System.out.println(getName() + " está com " + contador + " moedas.");
                int caminho = pote.getCaminho();
                pote = bosque.getPote(caminho);
                System.out.println(getName() + " entrou no pote " + caminho + ".");
            } catch (InterruptedException e) {
            }
        }
        if (!cacador.getVenceu()) {
            //moedasColetadas.set(new Integer(contador));
            System.out.println(getName() + " conseguiu " + contador + " moedas. Indo entregar para o caçador.");
            cacador.setMoedas(contador);
            contador = 0;

            //this.interrupt();
            //this.yield();
            //Thread.yield();
        }
 
        //cacador.setMoedas(contador);
        //interrupt();
        //try {
        //    this.finalize();
        //} catch (Throwable e) {
        //}
    }
}
