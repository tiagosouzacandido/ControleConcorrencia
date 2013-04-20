/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

import java.util.concurrent.ExecutorService;
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
                                                                
        Bosque bosque = new Bosque();

        ScheduledExecutorService salvaVidas = Executors.newSingleThreadScheduledExecutor();
        salvaVidas.schedule(new CachorroSalvaVidas(bosque.getPote(0)), 200, TimeUnit.MILLISECONDS);

        ExecutorService cacadorAmarelo = Executors.newFixedThreadPool(1);
        ExecutorService cacadorVerde = Executors.newFixedThreadPool(1);
        ExecutorService cacadorAzul = Executors.newFixedThreadPool(1);

        for (int j = 1; j < 3; j++) {
            cacadorAmarelo.execute(new Cachorro(bosque,bosque.getPote(0),"Cachorro Amarelo " +j));
            cacadorVerde.execute(new Cachorro(bosque,bosque.getPote(0),"Cachorro Verde " +j));
            cacadorAzul.execute(new Cachorro(bosque,bosque.getPote(0),"Cachorro Azul " +j));
        }
        
        //salvaVidas.shutdown();
        //cacadorAmarelo.shutdown();
        //cacadorVerde.shutdown();
        //cacadorAzul.shutdown();
    }
}
