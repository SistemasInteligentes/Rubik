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
public class AgenteRubikBasico implements AgenteRubik{
    
    String ruta;

    @Override
    public void ordenarCubo() {
        ruta = "";
    }

    @Override
    public String getRuta() {
        return ruta;
    }
    
}
