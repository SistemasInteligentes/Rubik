/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rubik;

/**
 *
 * @author samsung
 */
public class Rubik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cubo cubo = new Cubo();
        cubo.print();
        String a=cubo.revolver(5);
        //cubo.rotar(Mov.FRONT, 1);
        //cubo.rotar(Mov.FRONT, 1);
        //cubo.rotar(Mov.DOWN, -1);
        //cubo.rotar(Mov.LEFT, 1);
        cubo.print();
        AgenteRubikBasico juanito= new AgenteRubikBasico(cubo);
        System.out.println("Algoritmo de desordenamiento: "+a);
        juanito.ordenarCubo();
        cubo.print();
    }
}
