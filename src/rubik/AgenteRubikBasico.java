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
public class AgenteRubikBasico implements AgenteRubik {

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
        paso3();
        paso4();
        paso5();
    }

    public void paso1() {
        System.out.println("Paso 1");
        buscarEjecutarCasos("P1", "C0", 1, 4, 10);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C1", 9, 4, 10);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C1", 19, 4, 10);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasos("P1", "C2", 11, 4, 10);
        cubo.print();
        System.out.println("Paso 1 terminado\n");
        cubo.rotarCubo(Mov.UP, -1);
    }

    public void paso2() {
        System.out.println("Paso 2");
        buscarEjecutarCasosEsquinas("P2", "C0", 0, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosEsquinas("P2", "C0", 18, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosEsquinas("P2", "C0", 20, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosEsquinas("P2", "C0", 2, 4, 10, 12);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.rotarCubo(Mov.FRONT, 1);
        cubo.rotarCubo(Mov.FRONT, 1);
        cubo.print();
        System.out.println("Paso 2 terminado\n");
    }

    public void paso3() {
        System.out.println("Paso 3");
        buscarEjecutarCasosCorona("P3", "C0", 3, 4, 14);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosCorona("P3", "C0", 5, 4, 14);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosCorona("P3", "C0", 23, 4, 14);
        cubo.rotarCubo(Mov.UP, -1);
        buscarEjecutarCasosCorona("P3", "C0", 21, 4, 14);
        cubo.rotarCubo(Mov.UP, -1);
        cubo.print();
        System.out.println("Paso 3 terminado\n");
    }

    public void paso4() {
        System.out.println("Paso 4");
        int rotar = 0;
        int centro = 10;
        int numChar = 1;

        int fichaFrente = 1;
        int fichaIzq = 9;
        int fichaDer = 11;
        int fichaAtras = 19;

        if (estaSegundaCruz(centro, numChar)) {
                return;
            }
        
        while (noOrdenadaUP(fichaFrente, centro, numChar) && rotar < 4) {
            cubo.rotar(Mov.UP, 1);
            rotar++;
        }
        if (rotar == 4) {
            buscarEjecutarCasosSegundaCruz("C3");
            estaSegundaCruz(centro, numChar);
        } else if (!noOrdenadaUP(fichaFrente, centro, numChar)) {
            if (estaSegundaCruz(centro, numChar)) {
                return;
            } else {
                if (!noOrdenadaUP(fichaDer, centro, numChar)) {
                    cubo.rotar(Mov.UP, 1);
                    cubo.rotar(Mov.UP, 1);
                    buscarEjecutarCasosSegundaCruz("C1");
                    estaSegundaCruz(centro, numChar);
                } else if (!noOrdenadaUP(fichaIzq, centro, numChar)) {
                    cubo.rotar(Mov.UP, 1);
                    buscarEjecutarCasosSegundaCruz("C1");
                    estaSegundaCruz(centro, numChar);
                } else if (!noOrdenadaUP(fichaAtras, centro, numChar)) {
                    cubo.rotar(Mov.UP, 1);
                    buscarEjecutarCasosSegundaCruz("C2");
                    estaSegundaCruz(centro, numChar);
                }
            }
        }
        cubo.print();
        System.out.println("Paso 4 terminado\n");
    }
    
    public void paso5(){
        System.out.println("Paso 5");
        int rotar = 0;
        int centroF = 4;
        int centroR = 14;
        int centroB = 22;
        int centroL = 12;
        int numCharF = 0;
        int numCharR = 2;
        int numCharB = 5;
        int numCharL = 4;

        int fichaFrente = 1;
        int fichaIzq = 9;
        int fichaDer = 11;
        int fichaAtras = 19;
        
        
        while (!estaSegundaCruzCompleta()&& rotar<10) {
            
            if(!noOrdenada(fichaFrente, centroF, numCharF)){
                System.out.println("1if(!noOrdenada("+fichaFrente+", "+centroF+", "+numCharF+") rotar "+rotar);
                
                if(!noOrdenada(fichaDer,centroR,numCharR)){
               
                    System.out.println("2if(!noOrdenada("+fichaDer+", "+centroR+", "+numCharR+") rotar "+rotar);
                    buscarEjecutarCasosSegundaCruzCompleta("C1");
                    //caso 1 
                }else if(!noOrdenada(fichaIzq,centroL,numCharL)){
            
                    System.out.println("3if(!noOrdenada("+fichaIzq+", "+centroL+", "+numCharL+") rotar "+rotar);
                    cubo.rotar(Mov.UP, -1);
                    buscarEjecutarCasosSegundaCruzCompleta("C1");
                    // U' + caso 1 
                }else if(!noOrdenada(fichaAtras,centroB,numCharB)){
                    
                    System.out.println("4if(!noOrdenada("+fichaAtras+", "+centroB+", "+numCharB+") rotar "+rotar);
                    buscarEjecutarCasosSegundaCruzCompleta("C2");
                    cubo.rotarCubo(Mov.UP, 1);
                    buscarEjecutarCasosSegundaCruzCompleta("C1");
                    //caso 2 + rotarCuboUP + caso 1
                }else {
                   
                    System.out.println("else rotarCubo rotar "+rotar);
                    cubo.rotarCubo(Mov.UP, 1);                    
                }
            }else{
        
                
                System.out.println("else rotarCara rotar "+rotar);
                cubo.rotar(Mov.UP, 1); 
            }
            
            rotar++;
            System.out.println("\n\n");
        }
        System.out.println("rotar "+rotar);
        cubo.print();
        System.out.println("Paso 5 terminado\n");       
    }
    
    public boolean noOrdenada(int posicion, int centro, int numChar) {
        return (cubo.tablero[centro].direccion.charAt(numChar)) != (cubo.tablero[posicion].direccion.charAt(numChar));
    }

    public boolean noOrdenadaUP(int posicion, int centroArriba, int numChar) {
        return (cubo.tablero[centroArriba].direccion.charAt(numChar)) != (cubo.tablero[posicion].direccion.charAt(numChar));
    }

    public boolean estaSegundaCruz(int centroArriba, int numChar) {
        boolean flag = (!noOrdenadaUP(1, centroArriba, numChar))
                && (!noOrdenadaUP(11, centroArriba, numChar))
                &&  (!noOrdenadaUP(9, centroArriba, numChar))
                &&  (!noOrdenadaUP(19, centroArriba, numChar));
        System.out.println("segunda cruz? " + flag);
        return flag;
    }

    public boolean estaSegundaCruzCompleta() {
        boolean flag ;
//        (!noOrdenada(1, 4, 0)) 
//                && (!noOrdenadaUP(11, 14, 2)) 
//                && (!noOrdenadaUP(9, 12, 4)) 
//                && (!noOrdenadaUP(19, 22, 5));
        boolean flag1 =(!noOrdenada(1, 4, 0));
        System.out.println("1 completa? " + flag1);
        boolean flag2 =(!noOrdenadaUP(11, 14, 2));
        System.out.println("11 completa? " + flag2);
        boolean flag3 =(!noOrdenadaUP(9, 12, 4)) ;
        System.out.println("9 completa? " + flag3);
        boolean flag4 =(!noOrdenadaUP(19, 22, 5));
        System.out.println("19 completa? " + flag4);
        
        flag = flag1 && flag2 && flag3 && flag4;
        System.out.println("segunda cruz completa? " + flag);
        return flag;
    }
    public void buscarEjecutarCasosSegundaCruzCompleta(String caso) {

        for (int j = 0; j < memoria.length; j++) {
            if (memoria[j][0].equals("P5") && memoria[j][1].equals(caso)) {
                System.out.println("El algoritmo es: Caso:" + caso + " [" + memoria[j][4] + "]");
                String aux = armarAlgoritmo(j);
                ruta = ruta.concat(aux);
                cubo.correrAlgoritmo(aux);
                break;
            }
        }
    }
    
    public void buscarEjecutarCasosSegundaCruz(String caso) {

        for (int j = 0; j < memoria.length; j++) {
            if (memoria[j][0].equals("P4") && memoria[j][1].equals(caso)) {
                System.out.println("El algoritmo es: Caso:" + caso + " [" + memoria[j][4] + "]");
                String aux = armarAlgoritmo(j);
                ruta = ruta.concat(aux);
                cubo.correrAlgoritmo(aux);
                break;
            }
        }
    }

    public void buscarEjecutarCasos(String paso, String caso, int id, int centroFrente, int centroArriba) {
        String orientacion = "";
        for (int i = 0; i < 27; i++) {
            if (cubo.tablero[i].id == id) {

                System.out.println("La ficha " + id + " esta en: " + i);
                System.out.println("La dirección es: " + cubo.tablero[i].direccion);
                System.out.print("La ubicación es: ");
                orientacion = cubo.tablero[i].getOrientacion(
                        cubo.tablero[centroFrente].direccion.charAt(0),
                        cubo.tablero[centroArriba].direccion.charAt(1)
                );
                System.out.println(orientacion);

                for (int j = 0; j < memoria.length; j++) {
                    if (memoria[j][0].equals(paso) && memoria[j][1].equals(caso)) {
                        if (memoria[j][2].equals("" + i)) {
                            if (memoria[j][3].equals(orientacion)) {
                                System.out.println("El algoritmo es: [" + memoria[j][4] + "]");
                                String aux = armarAlgoritmo(j);
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

    public void buscarEjecutarCasosCorona(String paso, String caso, int id, int centroFrente, int centroDerecha) {
        String orientacion = "";
        for (int i = 0; i < 27; i++) {
            if (cubo.tablero[i].id == id) {

                System.out.println("La ficha " + id + " esta en: " + i);
                System.out.println("La dirección es: " + cubo.tablero[i].direccion);
                System.out.print("--> La ubicación es: ");
                orientacion = cubo.tablero[i].getOrientacion(
                        cubo.tablero[centroFrente].direccion.charAt(0),
                        cubo.tablero[centroDerecha].direccion.charAt(2)
                );
                System.out.println(orientacion);

                for (int j = 0; j < memoria.length; j++) {
                    if (memoria[j][0].equals(paso) && memoria[j][1].equals(caso)) {
                        if (memoria[j][2].equals("" + i)) {
                            if (memoria[j][3].equals(orientacion)) {
                                System.out.println("El algoritmo es: " + j + " [" + memoria[j][4] + "]");
                                String aux = armarAlgoritmo(j);
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
    
    public void buscarEjecutarCasosEsquinas(String paso, String caso, int id, int centroFrente, int centroArriba, int centroIzquierda) {
        String orientacion = "";
        for (int i = 0; i < 27; i++) {
            if (cubo.tablero[i].id == id) {
                orientacion = cubo.tablero[i].getOrientacionEsquinas(
                        cubo.tablero[centroFrente].direccion.charAt(0),
                        cubo.tablero[centroArriba].direccion.charAt(1),
                        cubo.tablero[centroIzquierda].direccion.charAt(4)
                );
                System.out.println(orientacion);

                for (int j = 0; j < memoria.length; j++) {
                    if (memoria[j][0].equals(paso) && memoria[j][1].equals(caso)) {
                        if (memoria[j][2].equals("" + i)) {
                            if (memoria[j][3].equals(orientacion)) {
                                String aux = armarAlgoritmo(j);
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

    private String armarAlgoritmo(int i) {
        String algo = memoria[i][4];
        int aux = 0;
        try {
            aux = Integer.parseInt(memoria[i][5]);
            algo += armarAlgoritmo(aux);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        return algo;
    }

    @Override
    public String getRuta() {
        return ruta;
    }

    private String[][] memoria = {
        //Caso 0	Sin 1, 3, 5 o 7 ubicados
        /*  0   */{"P1", "C0", "9", "LU", "U'"}, //Subcaso 0
        /*  1   */ {"P1", "C0", "11", "RU", "U"}, //Subcaso 1
        /*  2   */ {"P1", "C0", "19", "BU", "UU"}, //Subcaso 2
        /*  3   */ {"P1", "C0", "3", "FL", "F"}, //Subcaso 3
        /*  4   */ {"P1", "C0", "5", "FR", "F'"}, //Subcaso 4
        /*  5   */ {"P1", "C0", "7", "FD", "FF"}, //Subcaso 5
        /*  6   */ {"P1", "C0", "3", "LF", "L'", "0"},
        /*  7   */ {"P1", "C0", "15", "LD", "LL", "0"},
        /*  8   */ {"P1", "C0", "21", "LB", "L", "0"},
        /*  9   */ {"P1", "C0", "5", "RF", "R", "1"},
        /*  10  */ {"P1", "C0", "17", "RD", "RR", "1"},
        /*  1   */ {"P1", "C0", "23", "RB", "R'", "1"},
        /*  2   */ {"P1", "C0", "21", "BL", "B'", "2"},
        /*  3   */ {"P1", "C0", "23", "BR", "B", "2"},
        /*  4   */ {"P1", "C0", "25", "BD", "BB", "2"},
        /*  5   */ {"P1", "C0", "17", "DR", "R", "4"},
        /*  6   */ {"P1", "C0", "15", "DL", "L'", "3"},
        /*  7   */ {"P1", "C0", "25", "DB", "D'", "15"},
        /*  8   */ {"P1", "C0", "7", "DF", "D", "15"},
        /*  9   */ {"P1", "C0", "1", "UF", "F", "9"},
        /*  20  */ {"P1", "C0", "9", "UL", "L", "3"},
        /*  1   */ {"P1", "C0", "11", "UR", "R'", "4"},
        /*  2   */ {"P1", "C0", "19", "UB", "B", "8"},//Caso 1	Armar 1, sin mover 11 y 19
        /*  3   */ {"P1", "C1", "9", "UL", "LF"},
        /*  4   */ {"P1", "C1", "3", "FL", "F"},
        /*  5   */ {"P1", "C1", "5", "FR", "F'"},
        /*  6   */ {"P1", "C1", "7", "FD", "FF"},
        /*  7   */ {"P1", "C1", "3", "LF", "UL'U'"},
        /*  8   */ {"P1", "C1", "9", "LU", "L", "27"},
        /*  9   */ {"P1", "C1", "15", "LD", "L'", "27"},
        /*  30  */ {"P1", "C1", "21", "LB", "ULU'"},
        /*  1   */ {"P1", "C1", "5", "RF", "U'RU"},
        /*  2   */ {"P1", "C1", "17", "RD", "U'RRU"},
        /*  3   */ {"P1", "C1", "23", "RB", "U'R'U"},
        /*  4   */ {"P1", "C1", "7", "DF", "F'", "31"},
        /*  5   */ {"P1", "C1", "15", "DL", "L'FL"},
        /*  6   */ {"P1", "C1", "17", "DR", "D'F'", "31"},
        /*  7   */ {"P1", "C1", "25", "DB", "DDF'", "31"},
        /*  8   */ {"P1", "C1", "21", "BL", "UUB'UU"},
        /*  9   */ {"P1", "C1", "23", "BR", "UUBUU"},
        /*  40  */ {"P1", "C1", "25", "BD", "UUBBUU"},
        /*  1   */ {"P1", "C1", "19", "BU", "B", "38"},
        /*  2   */ {"P1", "C1", "19", "UB", "B", "30"},
        /*  3   */ {"P1", "C1", "1", "UF", "F", "31"},//Caso 2	Armar 1, sin mover 9, 11 y 19
        /*  4   */ {"P1", "C2", "3", "FL", "F"},
        /*  5   */ {"P1", "C2", "7", "FD", "FF"},
        /*  6   */ {"P1", "C2", "5", "FR", "F'"},
        /*  7   */ {"P1", "C2", "3", "LF", "", "27"},
        /*  8   */ {"P1", "C2", "15", "LD", "ULLU'"},
        /*  9   */ {"P1", "C2", "21", "LB", "", "30"},
        /*  50  */ {"P1", "C2", "5", "RF", "", "31"},
        /*  1   */ {"P1", "C2", "17", "RD", "", "32"},
        /*  2   */ {"P1", "C2", "23", "RB", "", "33"},
        /*  3   */ {"P1", "C2", "7", "DF", "", "34"},
        /*  4   */ {"P1", "C2", "15", "DL", "", "35"},
        /*  5   */ {"P1", "C2", "17", "DR", "", "36"},
        /*  6   */ {"P1", "C2", "25", "DB", "", "37"},
        /*  7   */ {"P1", "C2", "21", "BL", "", "38"},
        /*  8   */ {"P1", "C2", "23", "BR", "", "39"},
        /*  9   */ {"P1", "C2", "25", "BD", "", "40"},
        /*  60  */ {"P1", "C2", "1", "UF", "F", "31"},/*61 pasos hasta este punto (de 0 a 60). Fin del paso 1*/
        /*  1   */ {"P2", "C0", "6", "FLD", "D'F'DF"},
        /*  2   */ {"P2", "C0", "6", "DFL", "F'D'F"},
        /*  3   */ {"P2", "C0", "6", "LDF", "F'D'D'FD", "62"},
        /*  4   */ {"P2", "C0", "8", "RFD", "D'", "61"},
        /*  5   */ {"P2", "C0", "8", "DRF", "D'", "62"},
        /*  6   */ {"P2", "C0", "8", "FDR", "D'", "63"},
        /*  7   */ {"P2", "C0", "24", "LBD", "D", "61"},
        /*  8   */ {"P2", "C0", "24", "DLB", "D", "62"},
        /*  9   */ {"P2", "C0", "24", "BDL", "D", "63"},
        /*  70  */ {"P2", "C0", "26", "BRD", "DD", "61"},
        /*  1   */ {"P2", "C0", "26", "DBR", "DD", "62"},
        /*  2   */ {"P2", "C0", "26", "RDB", "DD", "63"},
        /*  3   */ {"P2", "C0", "0", "ULF", "F'DF", "61"},
        /*  4   */ {"P2", "C0", "0", "LFU", "F'DF", "63"},
        /*  5   */ {"P2", "C0", "2", "RUF", "FDF'", "64"},
        /*  6   */ {"P2", "C0", "2", "FRU", "FDF'", "65"},
        /*  7   */ {"P2", "C0", "2", "UFR", "FDF'", "66"},
        /*  8   */ {"P2", "C0", "18", "UBL", "L'DL", "67"},
        /*  9   */ {"P2", "C0", "18", "LUB", "L'DL", "68"},
        /*  80  */ {"P2", "C0", "18", "BLU", "L'DL", "69"},
        /*  1   */ {"P2", "C0", "20", "BUR", "RD'R'", "70"},
        /*  2   */ {"P2", "C0", "20", "RBU", "RD'R'", "71"},
        /*  3   */ {"P2", "C0", "20", "URB", "RD'R'", "72"},/*84 pasos hasta este punto, paso2(de 61 a 83). Fin del paso 2*/
        /*  4   */ {"P3", "C0", "1", "FU", "URUR'U'F'U'F"},
        /*  5   */ {"P3", "C0", "11", "UR", "U'F'U'FURUR'"},
        /*  6   */ {"P3", "C0", "19", "UB", "U", "85"},
        /*  7   */ {"P3", "C0", "9", "UL", "UU", "85"},
        /*  8   */ {"P3", "C0", "1", "UF", "U'", "85"},
        /*  9   */ {"P3", "C0", "11", "RU", "U", "84"},
        /*  90  */ {"P3", "C0", "19", "BU", "UU", "84"},
        /*  1   */ {"P3", "C0", "9", "LU", "U'", "84"},
        /*  2   */ {"P3", "C0", "5", "RF", "URUR'U'F'U'FUU", "84"},
        /*  3   */ {"P3", "C0", "23", "BR", "UBUB'U'R'URR'UUR", "91"},
        /*  4   */ {"P3", "C0", "23", "RB", "UBUB'U'R'URR'UUR", "87"},
        /*  5   */ {"P3", "C0", "3", "LF", "UFUF'U'L'U'L", "85"},
        /*  6   */ {"P3", "C0", "3", "FL", "UFUF'U'L'U'LU", "84"},
        /*  7   */ {"P3", "C0", "21", "BL", "ULUL'U'B'UBB'UUBU'", "85"},
        /*  8   */ {"P3", "C0", "21", "LB", "ULUL'U'B'UBB'UUB", "84"},
        /*  9   */ {"P4", "C1", "x", "x", "FURU'R'F'"},
        /*  100 */ {"P4", "C2", "x", "x", "FRUR'U'F'"},
        /*  1   */ {"P4", "C3", "x", "x", "FURU'R'F'U", "100"},
        /*  100 */ {"P5", "C1", "x", "x", "R'U'RU'R'UURU'"},
        /*  1   */ {"P5", "C2", "x", "x", "R'U'RU'R'UUR"}

    };
    /*
    
     */

}
