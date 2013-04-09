/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contconcorrencia;

import java.util.Stack;
/**
 *
 * @author casa
 */
public class Pote {
    public static Stack buffer = new Stack();
    public static final int BUFFER_SIZE = 4;
    
    protected int getSize(){
        return BUFFER_SIZE;
    }
    
    protected Stack getBuffer(){
        return buffer;
    }
}
