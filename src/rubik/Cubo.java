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
public class Cubo {
    
    FichaRubik[] tablero = new FichaRubik[27];


    public Cubo() {
        tablero[0]= new FichaRubik(0,""+Col.W+Col.B+"xx"+Col.O+"x");
        tablero[1]= new FichaRubik(1,""+Col.W+Col.B+"xxxx");
        tablero[2]= new FichaRubik(2,""+Col.W+Col.B+Col.R+"xxx");
        tablero[3]= new FichaRubik(3,""+Col.W+"xxx"+Col.O+"x");
        tablero[4]= new FichaRubik(4,""+Col.W+"xxxxx");
        tablero[5]= new FichaRubik(5,""+Col.W+"x"+Col.R+"xxx");
        tablero[6]= new FichaRubik(6,""+Col.W+"xx"+Col.G+Col.O+"x");
        tablero[7]= new FichaRubik(7,""+Col.W+"xx"+Col.G+"xx");
        tablero[8]= new FichaRubik(8,""+Col.W+"x"+Col.R+Col.G+"xx");
        
        tablero[9]= new FichaRubik(9,""+"x"+Col.B+"xx"+Col.O+"x");        
        tablero[10]= new FichaRubik(10,""+"x"+Col.B+"xxxx");
        tablero[11]= new FichaRubik(11,""+"x"+Col.B+Col.R+"xxx");
        tablero[12]= new FichaRubik(12,""+"xxxx"+Col.O+"x");
        tablero[13]= new FichaRubik(13,""+"xxxxxx");
        tablero[14]= new FichaRubik(14,""+"xx"+Col.R+"xxx");
        tablero[15]= new FichaRubik(15,""+"xxx"+Col.G+Col.O+"x");
        tablero[16]= new FichaRubik(16,""+"xxx"+Col.G+"xx");
        tablero[17]= new FichaRubik(17,""+"xx"+Col.R+Col.G+"xx");
        
        tablero[18]= new FichaRubik(18,""+"x"+Col.B+"xx"+Col.O+Col.Y);        
        tablero[19]= new FichaRubik(19,""+"x"+Col.B+"xxx"+Col.Y);
        tablero[20]= new FichaRubik(20,""+"x"+Col.B+Col.R+"xx"+Col.Y);
        tablero[21]= new FichaRubik(21,""+"xxxx"+Col.O+Col.Y);
        tablero[22]= new FichaRubik(22,""+"xxxxx"+Col.Y);
        tablero[23]= new FichaRubik(23,""+"xx"+Col.R+"xx"+Col.Y);
        tablero[24]= new FichaRubik(24,""+"xxx"+Col.G+Col.O+Col.Y);
        tablero[25]= new FichaRubik(25,""+"xxx"+Col.G+"x"+Col.Y);
        tablero[26]= new FichaRubik(26,""+"xx"+Col.R+Col.G+"x"+Col.Y);
        
    }
    public void revolver(){
        
        for (int i=0;i<5;i++){
            Mov mov = Mov.values()[(int)(Math.random()*Mov.values().length)];
            int direccion = -1+2*(int)(Math.random()*2);
            System.out.println(mov);
            System.out.println(direccion);
            rotar(mov, direccion);
        }
    }
    public void rotarCubo (){
        
    }
    public void correrAlgoritmo(){
        
    }
    public void rotar(Mov cara, int direccion){
        switch(cara){
            case FRONT:
                rotarFront(direccion);
                break;
            case UP:
                rotarUp(direccion);
                break;
            case RIGHT:
                rotarRight(direccion);
                break;
            case DOWN:
                rotarDown(direccion);
                break;
            case LEFT:
                rotarLeft(direccion);
                break;
            case BACK:
                rotarBack(direccion);
                break;
        }        
    }
    
    private void rotarFront(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[j+6-(3*i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(3*j)+i] = matrizAux[(3*j)+i];
                    tablero[(3*j)+i].rotarFichaFront(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[2-j+(3*i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(3*j)+i] = matrizAux[(3*j)+i];
                    tablero[(3*j)+i].rotarFichaFront(direccion);
                }
            }
        }
    }
    
    
    private void rotarUp(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[i*9+j];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*(2-j))+i] = matrizAux[(3*j)+i];
                    tablero[(9*(2-j))+i].rotarFichaUp(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[9*(2-i)+2-j];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*(2-j))+i] = matrizAux[(3*j)+i];
                    tablero[(9*(2-j))+i].rotarFichaUp(direccion);
                }
            }
        }
    }

    private void rotarRight(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[2+3*(2-i)+9*j];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*i)+2+(j*3)] = matrizAux[(3*j)+i];
                    tablero[(9*i)+2+(j*3)].rotarFichaRight(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[3*i+2+9*(2-j)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*i)+2+(j*3)] = matrizAux[(3*j)+i];
                    tablero[(9*i)+2+(j*3)].rotarFichaRight(direccion);
                }
            }
        }
    }
    private void rotarDown(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[j+6+9*(2-i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*j)+6+i] = matrizAux[(3*j)+i];
                    tablero[(9*j)+6+i].rotarFichaDown(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[8-j+9*i];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*j)+6+i] = matrizAux[(3*j)+i];
                    tablero[(9*j)+6+i].rotarFichaDown(direccion);
                }
            }
        }
    }
    private void rotarLeft(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[9*(2-j)+3*(2-i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*(2-i))+(3*j)] = matrizAux[(3*j)+i];
                    tablero[(9*(2-i))+(3*j)].rotarFichaLeft(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[9*j+3*i];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(9*(2-i))+(3*j)] = matrizAux[(3*j)+i];
                    tablero[(9*(2-i))+(3*j)].rotarFichaLeft(direccion);
                }
            }

        }
    }
    private void rotarBack(int direccion){
        
        FichaRubik[] matrizAux= new FichaRubik[9];
        
        if(direccion>=0){
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[2+9*2-j+3*(2-i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(3*j)+18+(2-i)] = matrizAux[(3*j)+i];
                    tablero[(3*j)+18+(2-i)].rotarFichaBack(direccion);
                }
            }
        }else{
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    matrizAux[(3*j)+i] = tablero[j+18+(3*i)];
                }
            }
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    tablero[(3*j)+18+(2-i)] = matrizAux[(3*j)+i];
                    tablero[(3*j)+18+(2-i)].rotarFichaBack(direccion);
                }
            }
        }
    }


    
    public void determinarPosFichaMal(){
        
    }
    public void verificarEstado(){
        
    }
    
    
    
    
    
    public void print(){
        String resultadoF ="";
        String resultadoU ="";
        String resultadoR ="";
        String resultadoD ="";
        String resultadoL ="";
        String resultadoB ="";
        
        String general="";
        String aux="    ";
        String cara1="";
        String cara2="";
        String cara3="";
        
        for(int j=0;j<3;j++){
            resultadoU += aux;
            resultadoD += aux;
            resultadoF = "";
            resultadoR = "";
            resultadoB = "";
            resultadoL = "";
            for(int i=0;i<3;i++){
                cara1 += " "+tablero[(3*j)+i].id;
                cara2 += " "+tablero[9+(3*j)+i].id;
                cara3 += " "+tablero[18+(3*j)+i].id;
                resultadoF += ""+tablero[(3*j)+i].direccion.charAt(0);
                resultadoU += ""+tablero[(9*(2-j))+i].direccion.charAt(1);
                resultadoR += ""+tablero[(9*i)+2+(j*3)].direccion.charAt(2);
                resultadoD += ""+tablero[(9*j)+6+i].direccion.charAt(3);
                resultadoL += ""+tablero[(9*(2-i))+(3*j)].direccion.charAt(4);
                resultadoB += ""+tablero[(3*j)+18+(2-i)].direccion.charAt(5);
            }
            
            general += ""+resultadoL+" "+resultadoF+" "+resultadoR+" "+resultadoB+"\n";
            resultadoU += "\n";
            resultadoD += "\n";
            cara1 += "\n"; 
            cara2 += "\n"; 
            cara3 += "\n"; 
        }
        general= resultadoU+general+resultadoD+"\n";

        System.out.println(cara1);
        System.out.println(cara2);
        System.out.println(cara3);
        System.out.println(general);
        
    }

    public void printBasico(){
        String resultadoF ="";
        String resultadoU ="";
        String resultadoR ="";
        String resultadoD ="";
        String resultadoL ="";
        String resultadoB ="";
        String cara1="";
        String cara2="";
        String cara3="";
        
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                cara1 += " "+tablero[(3*j)+i].id;
                cara2 += " "+tablero[9+(3*j)+i].id;
                cara3 += " "+tablero[18+(3*j)+i].id;
                resultadoF += tablero[(3*j)+i].direccion.charAt(0);
                resultadoU += tablero[(9*j)+i].direccion.charAt(1);
                resultadoR += tablero[(9*j)+2+(i*3)].direccion.charAt(2);
                resultadoD += tablero[(9*j)+6+i].direccion.charAt(3);
                resultadoL += tablero[(9*j)+(3*i)].direccion.charAt(4);
                resultadoB += tablero[(3*j)+18+i].direccion.charAt(5);
            }
            resultadoF+="\n";
            resultadoU += "\n";
            resultadoR += "\n";
            resultadoD += "\n";
            resultadoL += "\n";
            resultadoB += "\n";
            cara1 += "\n"; 
            cara2 += "\n"; 
            cara3 += "\n"; 
        }
        
        System.out.println(cara1);
        System.out.println(cara2);
        System.out.println(cara3);
        
        System.out.println("F : \n"+resultadoF);
        System.out.println("U : \n"+resultadoU);
        System.out.println("R : \n"+resultadoR);
        System.out.println("D : \n"+resultadoD);
        System.out.println("L : \n"+resultadoL);
        System.out.println("B : \n"+resultadoB);
        
        System.out.println("-----------------");
    }
        
}
