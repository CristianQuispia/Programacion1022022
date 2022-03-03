/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradleproject6;

import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class TresEnRaya {
    public static void main(String[] args){
        char[][] tablero = new char[3][3];
        for(int x=0;x<tablero.length;x++){    
            for(int y=0;y<tablero.length;y++){
                tablero[x][y] = '-';
            }
        }
        boolean x=false;
        Scanner sn = new Scanner(System.in);
        boolean on = false;
        int op;
        char marca = ' ';
        while (!x){
            if(on == true){
                MostrarTablero(tablero);
                System.out.println("Turno: "+marca);
            }
            System.out.println("1. Iniciar juego");
            System.out.println("2. Poner marca");
            System.out.println("3. Detener juego");
            try{
                System.out.println("Escribe una opcion");
                op = sn.nextInt();
                switch(op){
                    case 1:
                        if(on == true){
                            System.out.println("Ya se ha iniciado el juego");
                        }
                        else{
                            on = true;
                            boolean first = Math.random() < 0.5;
                            if (first == true){
                                System.out.println("Inicia X");
                                marca = 'X';
                            }
                            else{
                                System.out.println("Inicia O");
                                marca = 'O';
                            }
                        }
                        break;

                    case 2:
                        if(on != true){
                            System.out.println("Primero inicie el juego");
                        }
                        else{
                            int op2=0;
                            boolean enrango = false;
                            while(!enrango){
                                System.out.println("Escribe una posicion:");
                                System.out.println("1 | 2 | 3");
                                System.out.println("4 | 5 | 6");
                                System.out.println("7 | 8 | 9");
                                op2 = sn.nextInt();
                                if(op2<1 || op2>9){
                                    System.out.println("Escribe una opcion");
                                }
                                else{
                                    enrango = true;
                                }
                            }
                            int[] pos = DetectarPosicion(op2, tablero);
                            boolean sinM = DetectarMarca(pos[0], pos[1], tablero);
                            while(!sinM){
                                System.out.println("Escribe una posicion sin marca:");
                                System.out.println("1 | 2 | 3");
                                System.out.println("4 | 5 | 6");
                                System.out.println("7 | 8 | 9");
                                op2 = sn.nextInt();
                                pos = DetectarPosicion(op2, tablero);
                                sinM = DetectarMarca(pos[0], pos[1], tablero);
                            }
                            tablero[pos[0]][pos[1]] = marca;
                            boolean gano = DetectarTres(tablero, marca);
                            if (gano == true){
                                MostrarTablero(tablero);
                                System.out.println("Gana: "+marca);
                                System.out.println("Juego terminado");
                                x = true;
                                break;
                            }
                            boolean lleno = TableroLleno( tablero);
                            if (lleno == true){
                                MostrarTablero(tablero);
                                System.out.println("Nadie gana");
                                System.out.println("Juego terminado");
                                x = true;
                                break;
                            }
                            if(marca == 'X'){
                                marca = 'O';
                            }
                            else if(marca == 'O'){
                                marca = 'X';
                            }
                        }
                        break;
                    case 3:
                        x = true;
                    default:
                        System.out.println("Escribe una opcion");
                }
            } catch (java.util.InputMismatchException e) {
                 System.out.println("Escribe solo numeros");
                 sn.next();
            }
        }
    }
    public static int[] DetectarPosicion(int number, char[][] tablero){
        int z = 0;
        int[] pos = new int[2];
        for(int x=0;x<tablero.length;x++){    
            for(int y=0;y<tablero.length;y++){
                if(z == number-1){
                    pos[0]= x;
                    pos[1]= y;
                }
                z++;
            }
        }
        return pos;
    }
    public static boolean DetectarMarca(int x, int y, char[][] tablero){
        if (tablero[x][y] == '-'){
            return true;
        }
        else{
        return false;
        }
    }
    public static boolean DetectarTres(char[][]tablero, char marca){
        for (int x=0;x<tablero.length;x++) {
            if (marca == tablero[x][0] && marca == tablero[x][1] && marca == tablero[x][2]) {
                return true;
            }
            else if (marca == tablero[0][x] && marca == tablero[1][x] && marca == tablero[2][x]) {
                return true;
            }
        }
        if (marca == tablero[0][0] && marca == tablero[1][1] && marca == tablero[2][2]) {
            return true;
        }
        else if (marca == tablero[2][0] && marca == tablero[1][1] && marca == tablero[0][2]){
            return true;
        }
        return false;
    }
    public static boolean TableroLleno(char[][] tablero){
        for(int x=0;x<tablero.length;x++){    
            for(int y=0;y<tablero.length;y++){
                if(tablero[x][y] == '-')
                    return false;
            }
        }
        return true;
    }
    public static void MostrarTablero(char[][] tablero){
        for(int x=0;x<tablero.length;x++){
            System.out.println(tablero[x][0]+" | "+tablero[x][1]+" | "+tablero[x][2]);
            if(x<2){
               System.out.println("----------");
            }
        }
    }
}
