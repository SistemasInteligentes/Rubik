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
        paso2();
        
        
    }
    
    public void paso1(){
//        System.out.println("Caso 0");
        buscarEjecutarCasos("P1", "C0", 1, 4, 10);
//        cubo.print();
//        System.out.println("Caso 1");
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C1", 9, 4, 10);
//        cubo.print();
//        System.out.println("Caso 1");
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C1", 19, 4, 10);
//        cubo.print();
        //System.out.println("Caso 2");
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C2", 11, 4, 10);
        //cubo.print();
        System.out.println("Paso 1 terminado");
        
        cubo.rotarCubo(Mov.UP, -1);
        
    }
    
    public void paso2(){
        System.out.println("Paso 2");
        cubo.print();
        buscarEjecutarCasosEsquinas("P2", "C0", 0, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.print();
        buscarEjecutarCasosEsquinas("P2", "C0", 18, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.print();
        buscarEjecutarCasosEsquinas("P2", "C0", 20, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.print();
        buscarEjecutarCasosEsquinas("P2", "C0", 2, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.print();
        cubo.rotarCubo(Mov.FRONT, 1);
        cubo.rotarCubo(Mov.FRONT, 1);
        System.out.println("Paso 2 terminado");
    }
    
    public void paso3(){
        cubo.rotarCubo(Mov.FRONT, 1);
        cubo.rotarCubo(Mov.FRONT, 1);
        
        
        
        
    }
    
    public void buscarEjecutarCasos(String paso, String caso, int id, int centroFrente, int centroArriba){
        String orientacion="";
        for(int i=0;i<27;i++){
            if (cubo.tablero[i].id==id){
                
//                System.out.println("La ficha "+id+" esta en: "+i);
//                System.out.println("La dirección es: "+cubo.tablero[i].direccion);
//                System.out.println("La ubicación es:");
                orientacion = cubo.tablero[i].getOrientacion(
                        cubo.tablero[centroFrente].direccion.charAt(0),
                        cubo.tablero[centroArriba].direccion.charAt(1)
                );
//                System.out.println(orientacion);

                for(int j=0;j<memoria.length;j++){
                    if (memoria[j][0].equals(paso) && memoria[j][1].equals(caso)){
                        if(memoria[j][2].equals(""+i)){
                            if(memoria[j][3].equals(orientacion)){
//                                System.out.println("El algoritmo es: ["+memoria[j][4]+"]");
                                String aux =armarAlgoritmo(j);
                                ruta = ruta.concat(aux);
                                cubo.correrAlgoritmo(aux);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    //buscar csos de las esquinas ya que hay un nuevo color que dbemos tener en cuenta
    
    public void buscarEjecutarCasosEsquinas(String paso, String caso, int id, int centroFrente, int centroArriba, int centroIzquierda){
        String orientacion="";
        for(int i=0;i<27;i++){
            if (cubo.tablero[i].id==id){
                
//                System.out.println("PASO 2 La ficha "+id+" esta en: "+i);
//                System.out.println("La dirección es: "+cubo.tablero[i].direccion);
//                System.out.println("La ubicación es:");
                orientacion = cubo.tablero[i].getOrientacionEsquinas(
                        cubo.tablero[centroFrente].direccion.charAt(0),
                        cubo.tablero[centroArriba].direccion.charAt(1),
                        cubo.tablero[centroIzquierda].direccion.charAt(4)
                );
                System.out.println(orientacion);

                for(int j=0;j<memoria.length;j++){
                    if (memoria[j][0].equals(paso) && memoria[j][1].equals(caso)){
                        if(memoria[j][2].equals(""+i)){
                            if(memoria[j][3].equals(orientacion)){
                                //System.out.println("El algoritmo es: ["+memoria[j][4]+"]");
                                String aux =armarAlgoritmo(j);
                                ruta = ruta.concat(aux);
                                cubo.correrAlgoritmo(aux);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private String armarAlgoritmo(int i){
        String algo=memoria[i][4];
        int aux=0;
        try{
//            System.out.println("[[[Memoria]]]: "+i);
            aux = Integer.parseInt(memoria[i][5]);
            algo+=armarAlgoritmo(aux);
        }catch(java.lang.ArrayIndexOutOfBoundsException e){}
        return algo;
    }
    @Override
    public String getRuta() {
        return ruta;
    }

     
      
    private String [][]memoria={
        //Caso 0	Sin 1, 3, 5 o 7 ubicados
        {"P1", "C0", "9",	"LU",	"U'"},      //Subcaso 0
        {"P1", "C0", "11",	"RU",	"U"},       //Subcaso 1
        {"P1", "C0", "19",	"BU",	"UU"},      //Subcaso 2
        {"P1", "C0", "3",	"FL",	"F"},       //Subcaso 3
        {"P1", "C0", "5",	"FR",	"F'"},      //Subcaso 4
        {"P1", "C0", "7",	"FD",	"FF"},       //Subcaso 5
        {"P1", "C0", "3",	"LF",	"L'",   "0"},
        {"P1", "C0", "15",	"LD",	"LL",	"0"},
        {"P1", "C0", "21",	"LB",	"L",	"0"},
        {"P1", "C0", "5",	"RF",	"R",	"1"},
        {"P1", "C0", "17",	"RD",	"RR",	"1"},
        {"P1", "C0", "23",	"RB",	"R'",	"1"},
        {"P1", "C0", "21",	"BL",	"B'",	"2"},
        {"P1", "C0", "23",	"BR",	"B",	"2"},
        {"P1", "C0", "25",	"BD",	"BB",	"2"},
        {"P1", "C0", "17",	"DR",	"R",	"4"},
        {"P1", "C0", "15",	"DL",	"L'",	"3"},
        {"P1", "C0", "25",	"DB",	"D'",	"15"},
        {"P1", "C0", "7",	"DF",	"D",	"15"},
        {"P1", "C0", "1",	"UF",	"F",	"9"},
        {"P1", "C0", "9",	"UL",	"L",	"3"},
        {"P1", "C0", "11",	"UR",	"R'",	"4"},
        {"P1", "C0", "19",	"UB",	"B",	"8"},
        //Caso 1	Armar 1, sin mover 11 y 19
        {"P1", "C1", "9",	"UL",	"LF"},
        {"P1", "C1", "3",	"FL",	"F"},
        {"P1", "C1", "5",	"FR",	"F'"},
        {"P1", "C1", "7",	"FD",	"FF"},
        {"P1", "C1", "3",	"LF",	"UL'U'"},
        {"P1", "C1", "9",	"LU",	"L",	"27"},
        {"P1", "C1", "15",	"LD",	"L'",	"27"},
        {"P1", "C1", "21",	"LB",	"ULU'"},
        {"P1", "C1", "5",	"RF",	"U'RU"},
        {"P1", "C1", "17",	"RD",	"U'RRU"},
        {"P1", "C1", "23",	"RB",	"U'R'U"},
        {"P1", "C1", "7",	"DF",	"F'",	"31"},
        {"P1", "C1", "15",	"DL",	"L'FL"},
        {"P1", "C1", "17",	"DR",	"D'F'",	"31"},
        {"P1", "C1", "25",	"DB",	"DDF'",	"31"},
        {"P1", "C1", "21",	"BL",	"UUB'UU"},
        {"P1", "C1", "23",	"BR",	"UUBUU"},
        {"P1", "C1", "25",	"BD",	"UUBBUU"},
        {"P1", "C1", "19",	"BU",	"B",	"38"},
        {"P1", "C1", "19",	"UB",	"B",	"30"},
        {"P1", "C1", "1",	"UF",	"F",	"31"},        
        //Caso 2	Armar 1, sin mover 9, 11 y 19
        {"P1", "C2", "3",	"FL",	"F"},	
        {"P1", "C2", "7",	"FD",	"FF"},	
        {"P1", "C2", "5",	"FR",	"F'"},	
        {"P1", "C2", "3",	"LF",	"",	"27"},
        {"P1", "C2", "15",	"LD",	"ULLU'"	},
        {"P1", "C2", "21",	"LB",	"",	"30"},
        {"P1", "C2", "5",	"RF",	"",	"31"},
        {"P1", "C2", "17",	"RD",	"",	"32"},
        {"P1", "C2", "23",	"RB",	"",	"33"},
        {"P1", "C2", "7",	"DF",	"",	"34"},
        {"P1", "C2", "15",	"DL",	"",	"35"},
        {"P1", "C2", "17",	"DR",	"",	"36"},
        {"P1", "C2", "25",	"DB",	"",	"37"},
        {"P1", "C2", "21",	"BL",	"",	"38"},
        {"P1", "C2", "23",	"BR",	"",	"39"},
        {"P1", "C2", "25",	"BD",	"",	"40"},
        {"P1", "C2", "1",	"UF",	"F",	"31"},
/*61 pasos hasta este punto (de 0 a 60). Fin del paso 1*/
        
        {"P2", "C0", "6",	"FLD",	"D'F'DF"},
        {"P2", "C0", "6",	"DFL",	"F'D'F"},	
        {"P2", "C0", "6",	"LDF",	"F'D'D'FD",	"62"},
        {"P2", "C0", "8",	"RFD",	"D'",	"61"},
        {"P2", "C0", "8",	"DRF",	"D'",	"62"},
        {"P2", "C0", "8",	"FDR",	"D'",	"63"},
        {"P2", "C0", "24",	"LBD",	"D",	"61"},
        {"P2", "C0", "24",	"DLB",	"D",	"62"},
        {"P2", "C0", "24",	"BDL",	"D",	"63"},
        {"P2", "C0", "26",	"BRD",	"DD",	"61"},
        {"P2", "C0", "26",	"DBR",	"DD",	"62"},
        {"P2", "C0", "26",	"RDB",	"DD",	"63"},
        {"P2", "C0", "0",	"ULF",	"F'DF",	"61"},
        {"P2", "C0", "0",	"LFU",	"F'DF",	"63"},
        {"P2", "C0", "2",	"RUF",	"FDF'",	"64"},
        {"P2", "C0", "2",	"FRU",	"FDF'",	"65"},
        {"P2", "C0", "2",	"UFR",	"FDF'",	"66"},
        {"P2", "C0", "18",	"UBL",	"L'DL",	"67"},
        {"P2", "C0", "18",	"LUB",	"L'DL",	"68"},
        {"P2", "C0", "18",	"BLU",	"L'DL",	"69"},
        {"P2", "C0", "20",	"BUR",	"RD'R'",	"70"},
        {"P2", "C0", "20",	"RBU",	"RD'R'",	"71"},
        {"P2", "C0", "20",	"URB",	"RD'R'",	"72"}
            
};
    /*
    
    */
    
    
}
