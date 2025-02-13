package Ejercicio1;

import Ejercicio3.Book;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [] a = new int [10];//no es necesario, se puede hacer directo como abajo
        //int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] b = new int[10];
        int [] c = new int[10];

        for (int i=0; i<10; i++) {
            a[i] = i+1;
            b[i] = -a[i];
            c[i] = a[i] + b[i];
        }

        //PROBANDO PUBLIC --> Si nhay un método públic en alguna de las clases puedes acceder desde cualquier parte del proyecto



        System.out.println(Arrays.toString(a)); // si no uso el toString me imprime el espacio en memoria
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

    }
}
