package EjerciciosDeAprendizaje;

import java.util.Random;
import java.util.Scanner;

/*
Dadas dos matrices cuadradas de n√∫meros enteros, la matriz M de 10x10 y la matriz P de
3x3, se solicita escribir un programa en el cual se compruebe si la matriz P est√° contenida
dentro de la matriz M. Para ello se debe verificar si entre todas las submatrices de 3x3
que se pueden formar en la matriz M, desplaz√°ndose por filas o columnas, existe al
menos una que coincida con la matriz P. En ese caso, el programa debe indicar la fila y la
columna de la matriz M en la cual empieza el primer elemento de la submatriz P.
*/
public class Ejercicio21 {
    public Ejercicio21(){

        int [][] matriz1 = new int[10][10];
        int [][] matriz2 = new int[3][3];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean first=false;
        boolean content=false;
        int count=0;

        //Crear y mostrar matriz de 10
        for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) matriz1[i][j]= random.nextInt(30)+1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) System.out.print(matriz1[i][j]+" ");
            System.out.println("");
        }
        //crear y mostrar matriz de 3
        System.out.println("Ingrese los valores de la matriz que desee buscar");
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) matriz2[i][j]= scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print(matriz2[i][j]+" ");
            System.out.println("");
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (matriz1[i][j]==matriz2[0][0]) first=true;

                if (first){
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            if (matriz1[k][l]==matriz2[k-i][l-j]) count++;
                        }
                    }
                    if (count==9) content=true;
                    else count=0;
                }
                first=false;
            }
        }

        if (content) System.out.println("La matriz 3x3 est· contenida");
        else System.out.println("La matriz 3x3 no est· contenida");
    }

}
