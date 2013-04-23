/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

/**
 *
 * @author Tiago
 */
public class CachorroSalvaVidas extends Thread {

    private Pote pote;
    private Bosque bosque;

    public CachorroSalvaVidas(Bosque bosque) {
        this.bosque = bosque;
    }

    @Override
    public void run() {
        while (Cachorro.running) {
            for (int i = 1; i <= 20; i++) {
                pote = bosque.getPote(i);
                if (pote.isVazio()) {
                    pote.acrescentarMoeda();
                }
            }
        }
    }
}
