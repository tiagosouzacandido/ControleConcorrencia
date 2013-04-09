/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author casa
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final Pote buffer = new Pote();
        
        Runnable salvaVidas = new Runnable() {  // Código do Cão Salva-Vidas
            public void run() {
                for (int i=0; i<100; i++) {         
                    synchronized(buffer.getBuffer()) {
                        if (buffer.getBuffer().size() >= buffer.getSize())
                            try { buffer.wait(); } catch (InterruptedException e) {}
                        buffer.getBuffer().push(new Integer(i));
                        System.out.println("Colocada uma moeda no pote. No. moedas no pote: "+buffer.getBuffer().size());
                        buffer.notify();
                    }
                }
            }
        };
        
        Runnable cao = new Runnable() { // Código do Cão
            public void run() {
                for (int i=0; i<100; i++) {
                    synchronized(buffer) {
                        if (buffer.getBuffer().size() == 0)
                            try { buffer.wait(); } catch (InterruptedException e) {}
                        int item = ((Integer)buffer.getBuffer().pop()).intValue();
                        System.out.println("Uma moeda consumida do pote. No. de moedas no pote: " + buffer.getBuffer().size());
                        buffer.notify();
                    }
                }
            }
        };
        
        new Thread(salvaVidas).start(); // Inicia o Produtor
        new Thread(cao).start(); // Inicia o Consumidor
        
        ScheduledExecutorService caoSalvaVidas = Executors.newSingleThreadScheduledExecutor();
        caoSalvaVidas.schedule(new CachorroSalvaVidas(), 200, TimeUnit.MILLISECONDS);
    }
}
