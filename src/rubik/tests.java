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
public class tests {
    public static void main(String[] args) {
//        System.out.println("prueba cara up");
//        for(int j=0;j<3;j++){
//            for(int i=0;i<3;i++){
//                System.out.println("matrizAux[(3*j)+i]: "+((3*j)+i));
//                System.out.println("tablero1[i*9+j]: "+(i*9+j));
//                System.out.println("tablero2[(9*(2-j))+i] ="+((9*(2-j))+i));
//            }
//        }
//        System.out.println("prueba centro front");
//        for(int j=0;j<3;j++){
//            for(int i=0;i<3;i++){
//                System.out.println("matrizAux[(3*j)+i]:     "+((3*j)+i));
//                System.out.println("tablero1[j+15-3*i]:     "+(j+15-3*i));
//                System.out.println("tablero2[3*j+9+i]:      "+(3*j+9+i));
//            }
//        }
        System.out.println("prueba centro up");
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                System.out.println("matrizAux[(3*j)+i]:     "+((3*j)+i));
                System.out.println("tablero1[21+j-(9*i)]:     "+(21+j-(9*i)));
                System.out.println("tablero2[3+i+(9*j)]:      "+(3+i+(9*j)));
            }
        }
    }
    
}
