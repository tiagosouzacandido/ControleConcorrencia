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

        Cacador cacadorAmarelo = new Cacador("Amarelo");
        Cacador cacadorVerde = new Cacador("Verde");
        Cacador cacadorAzul = new Cacador("Azul");

        ExecutorService exAmarelo = Executors.newFixedThreadPool(1);
        ExecutorService exVerde = Executors.newFixedThreadPool(1);
        ExecutorService exAzul = Executors.newFixedThreadPool(1);
        
        ScheduledExecutorService salvaVidas = Executors.newSingleThreadScheduledExecutor();
        salvaVidas.scheduleAtFixedRate(new CachorroSalvaVidas(bosque), 0, 200, TimeUnit.MILLISECONDS);
        
        
        Cachorro amarelo1 = new Cachorro(cacadorAmarelo, bosque, bosque.getPote(1), "Cachorro Amarelo 1");
        Cachorro verde1 = new Cachorro(cacadorVerde, bosque, bosque.getPote(1), "Cachorro Verde 1");
        Cachorro azul1 = new Cachorro(cacadorAzul, bosque, bosque.getPote(1), "Cachorro Azul 1");
        Cachorro amarelo2 = new Cachorro(cacadorAmarelo, bosque, bosque.getPote(1), "Cachorro Amarelo 2");    
        Cachorro verde2 = new Cachorro(cacadorVerde, bosque, bosque.getPote(1), "Cachorro Verde 2");  
        Cachorro azul2 = new Cachorro(cacadorAzul, bosque, bosque.getPote(1), "Cachorro Azul 2");

        exAmarelo.execute(amarelo1);
        exVerde.execute(verde1);
        exAzul.execute(azul1);
        exAmarelo.execute(amarelo2);
        exVerde.execute(verde2);     
        exAzul.execute(azul2);
        exAmarelo.execute(amarelo1);
        exVerde.execute(verde1);
        exAzul.execute(azul1);

        
        /*if(cacadorAmarelo.getVenceu() || cacadorVerde.getVenceu() || cacadorAzul.getVenceu()){       
        }*/
        //exAmarelo.shutdownNow();
        //exVerde.shutdownNow();
        //exAzul.shutdownNow();
        //salvaVidas.shutdown();
    }
}
