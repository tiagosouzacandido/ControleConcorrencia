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
        int[] cPote1 = {2,15};
        int[] cPote2 = {1,3,4,5};
        int[] cPote3 = {2,9};
        int[] cPote4 = {2,9,10};
        int[] cPote5 = {2,6};
        int[] cPote6 = {7,8};
        int[] cPote7 = {6};
        int[] cPote8 = {6};
        int[] cPote9 = {3,4,15,18};
        int[] cPote10 = {4,12};
        int[] cPote11 = {12,14,17};
        int[] cPote12 = {10,11,13};
        int[] cPote13 = {12};
        int[] cPote14 = {11,16};
        int[] cPote15 = {1,9};
        int[] cPote16 = {14,17,18,20};
        int[] cPote17 = {11,16};
        int[] cPote18 = {9,16,19};
        int[] cPote19 = {18,20};
        int[] cPote20 = {16,19};
                                                                
        Pote pote = new Pote(cPote1);

        ScheduledExecutorService salvaVidas = Executors.newSingleThreadScheduledExecutor();
        salvaVidas.schedule(new CachorroSalvaVidas(pote), 200, TimeUnit.MILLISECONDS);

        ExecutorService cacadorAmarelo = Executors.newFixedThreadPool(1);
        ExecutorService cacadorVerde = Executors.newFixedThreadPool(1);
        ExecutorService cacadorAzul = Executors.newFixedThreadPool(1);

        for (int j = 1; j < 3; j++) {
            cacadorAmarelo.execute(new Cachorro(pote,"Cachorro Amarelo " +j));
            cacadorVerde.execute(new Cachorro(pote,"Cachorro Verde " +j));
            cacadorAzul.execute(new Cachorro(pote,"Cachorro Azul " +j));
        }
        
        //salvaVidas.shutdown();
        //cacadorAmarelo.shutdown();
        //cacadorVerde.shutdown();
        //cacadorAzul.shutdown();
    }
}
