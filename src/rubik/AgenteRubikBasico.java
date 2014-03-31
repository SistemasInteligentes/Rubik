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
    Cubo cuboBase;
    Cubo cubo;

    public AgenteRubikBasico(Cubo c) {
        this.ruta = "";
        cuboBase = new Cubo();
        cubo = c;
    }
    

    @Override
    public void ordenarCubo() {
        ruta = "";
        paso1();
        
        
    }
    
    public void paso1(){
        caso0();
    }
    
    public void caso0(){
        String orientacion="";
        for(int i=0;i<27;i++){
            if (cubo.tablero[i].id==1){
                
                if(
                        cubo.tablero[i].direccion.equals(cuboBase.tablero[1].direccion) &&
                        cubo.tablero[i].id==cuboBase.tablero[1].id
                        ){
                    System.out.println("La ficha esta organizada.");
                }else{
                    //System.out.println("La ficha 1 esta en: "+i);
                    //System.out.println("La dirección es: "+cubo.tablero[i].direccion);
                    //System.out.println("La ubicación es:");
                    orientacion = cubo.tablero[i].getOrientacion(
                            cubo.tablero[4].direccion.charAt(0),
                            cubo.tablero[10].direccion.charAt(1)
                    );
                    //System.out.println(orientacion);
                    
                    for(int j=0;j<memoria.length;j++){
                        if(memoria[j][0].equals(""+i)){
                            if(memoria[j][1].equals(orientacion)){
                                //System.out.println("El algoritmo es: ["+memoria[j][2]+"]");
                                cubo.correrAlgoritmo(armarAlgoritmo(j));
                                break;
                            }
                        }
                        
                    }
                    
                }
                       
            }
        }
    }

    private String armarAlgoritmo(int i){
        String algo=memoria[i][2];
        int aux=0;
        try{
            aux = Integer.parseInt(memoria[i][3]);
            algo+=armarAlgoritmo(aux);
        }catch(java.lang.ArrayIndexOutOfBoundsException e){}
        return algo;
    }
    @Override
    public String getRuta() {
        return ruta;
    }

    
    
    
    
    
    
    
    
    
    
    private String [][]memoria={
        {"9",	"LU",	"U'"},      //Subcaso 0
        {"11",	"RU",	"U"},       //Subcaso 1
        {"19",	"BU",	"UU"},      //Subcaso 2
        {"3",	"FL",	"F"},       //Subcaso 3
        {"5",	"FR",	"F'"},      //Subcaso 4
        {"7",	"FD",	"FF"},       //Subcaso 5
        {"3",	"LF",	"L'", "0"},
        {"15",	"LD",	"LL",	"0"},
        {"21",	"LB",	"L",	"0"},
        {"5",	"RF",	"R",	"1"},
        {"17",	"RD",	"RR",	"1"},
        {"23",	"RB",	"R'",	"1"},
        {"21",	"BL",	"B'",	"2"},
        {"23",	"BR",	"B",	"2"},
        {"25",	"BD",	"BB",	"2"},
        {"17",	"DR",	"R",	"4"},
        {"15",	"DL",	"L'",	"3"},
        {"25",	"DB",	"D'",	"15"},
        {"7",	"DF",	"D",	"15"},
        {"1",	"UF",	"F",	"9"},
        {"9",	"UL",	"L",	"3"},
        {"11",	"UR",	"R'",	"4"},
        {"19",	"UB",	"B",	"8"}
};
    /*
    
    */
    
    
}
