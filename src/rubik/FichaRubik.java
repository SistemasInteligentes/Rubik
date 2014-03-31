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
public class FichaRubik {
    
    public int id;
    public String direccion;

    public FichaRubik(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }
    
    public void rotarFichaFront(int direccionGiro ){
        if(direccionGiro>=0){
            String aux = ""+direccion.charAt(4);
            direccion=direccion.charAt(0)+aux+direccion.substring(1, 4)+direccion.charAt(5);
        }else{
            String aux = ""+direccion.charAt(1);
            direccion=direccion.charAt(0)+direccion.substring(2, 5)+aux+direccion.charAt(5);
        }
    }
    public void rotarFichaUp(int direccionGiro ){
        if(direccionGiro>=0){
            direccion=""+direccion.charAt(2)+direccion.charAt(1)+direccion.charAt(5)+direccion.charAt(3)+direccion.charAt(0)+direccion.charAt(4);
        }else{
            direccion=""+direccion.charAt(4)+direccion.charAt(1)+direccion.charAt(0)+direccion.charAt(3)+direccion.charAt(5)+direccion.charAt(2);
        }
    }
    public void rotarFichaRight(int direccionGiro ){
        if(direccionGiro>=0){
            direccion=""+direccion.charAt(3)+direccion.charAt(0)+direccion.charAt(2)+direccion.charAt(5)+direccion.charAt(4)+direccion.charAt(1);
        }else{
            direccion=""+direccion.charAt(1)+direccion.charAt(5)+direccion.charAt(2)+direccion.charAt(0)+direccion.charAt(4)+direccion.charAt(3);
        }
    }
    public void rotarFichaDown(int direccionGiro ){
        if(direccionGiro>=0){
            direccion=""+direccion.charAt(4)+direccion.charAt(1)+direccion.charAt(0)+direccion.charAt(3)+direccion.charAt(5)+direccion.charAt(2);
        }else{
            direccion=""+direccion.charAt(2)+direccion.charAt(1)+direccion.charAt(5)+direccion.charAt(3)+direccion.charAt(0)+direccion.charAt(4);
        }
    }
    public void rotarFichaLeft(int direccionGiro ){
        if(direccionGiro>=0){
            direccion=""+direccion.charAt(1)+direccion.charAt(5)+direccion.charAt(2)+direccion.charAt(0)+direccion.charAt(4)+direccion.charAt(3);
        }else{
            direccion=""+direccion.charAt(3)+direccion.charAt(0)+direccion.charAt(2)+direccion.charAt(5)+direccion.charAt(4)+direccion.charAt(1);
        }
    }
    public void rotarFichaBack(int direccionGiro ){
        if(direccionGiro>=0){
            direccion=""+direccion.charAt(0)+direccion.charAt(2)+direccion.charAt(3)+direccion.charAt(4)+direccion.charAt(1)+direccion.charAt(5);
        }else{
            direccion=""+direccion.charAt(0)+direccion.charAt(4)+direccion.charAt(1)+direccion.charAt(2)+direccion.charAt(3)+direccion.charAt(5);
        }
    }
    
}
