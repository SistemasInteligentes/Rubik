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
//        String a="RFRFD'UFDL'";
///*probar el P5*/        String a="R'R'FBU'B'LF'L'BR'FUU'BB'B'FF'D'U'RF'U'RURD'R'B'UBFFBLDLFDFBB'UU'L'D'LB'F'UDDRR'R'B'B'B'BBFLF'FF'B'DR'LFB'B'L'B'BD'LFLU'DD'DUR'LRB'R'BR'LR'D'F'L'BBF";
///*probar el P5*/        String a="D'RD'R'BLBFU'FUFL'LL'LB'FULF'D'UBF'RFDUU'RUU'B'U'U'UL'LLDU'B'LBF'LDDF'";
///*probar el P4*/        String a= "D'U'D'R'L'LUD'R'B'F'D'DLRBB'DR'LBU'R'F'FLR'R'LDBR'R'F'R'BR'FU'R'B'FDF'D'R'DD'RD'";  
//        cubo.correrAlgoritmo(a);
        System.out.println(cubo.revolver(50));
        
//        cubo.rotar(Mov.FRONT, 1);
//        cubo.rotar(Mov.RIGHT, -1);
//        cubo.rotar(Mov.DOWN, -1);
//        cubo.rotar(Mov.FRONT, 1);
//        cubo.rotar(Mov.FRONT, 1);
//        cubo.print();
                
//        cubo.rotar(Mov.FRONT, 1);
//        cubo.rotarCubo(Mov.FRONT, 1);
//        cubo.print();
//        cubo.rotarCubo(Mov.UP, 1);
//        cubo.print();
//        cubo.rotarCubo(Mov.UP, -1);
//        cubo.print();
        //cubo.rotar(Mov.FRONT, 1);
        //cubo.rotar(Mov.DOWN, -1);
        //cubo.rotar(Mov.LEFT, 1);
        cubo.print();
        
        AgenteRubikBasico juanito= new AgenteRubikBasico(cubo);
//        System.out.println("Algoritmo de desordenamiento: "+a);
        juanito.ordenarCubo();
        cubo.print();
        System.out.println("ruta: "+juanito.ruta);
    }
}
