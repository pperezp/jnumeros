/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonumeros;

import java.util.Random;

/**
 *
 * @author Patricio Pérez Pinto
 */
public class ProyectoNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        int num;
        for(int i=0; i<5000 ; i++){
            num = r.nextInt(99999999);
            
            System.out.println(i+1+") "+num+" = "+Numero.getNumeroAsString(num));
        }
    }
}
