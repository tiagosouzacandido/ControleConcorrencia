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
    public static boolean running = true;

    public Cachorro(Cacador cacador, Bosque bosque, Pote pote, String nome) {
        this.setName(nome);
        this.pote = pote;
        this.bosque = bosque;
        this.cacador = cacador;
    }

    @Override
    public void run() {
        while (contador < 20 && cacador.getMoedas() + contador < 50 && running) {
            try {
                int coletadas = pote.tirarMoeda();
                contador += coletadas;
                System.out.println(getName() + " está com " + contador + " moedas.");
                int caminho = pote.getCaminho();
                pote = bosque.getPote(caminho);
                Thread.sleep(100);
                System.out.println(getName() + " entrou no pote " + caminho + ".");
            } catch (InterruptedException e) {
            }
        }
        if (!cacador.getVenceu()) {
            System.out.println(getName() + " conseguiu " + contador + " moedas. Indo entregar para o caçador.");
            cacador.setMoedas(contador);
            contador = 0;
        }
    }
}
