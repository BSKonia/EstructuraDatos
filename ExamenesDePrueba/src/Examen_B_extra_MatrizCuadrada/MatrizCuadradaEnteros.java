package Examen_B_extra_MatrizCuadrada;

import java.util.Arrays;

public class MatrizCuadradaEnteros {

    /**
     * IMPORTANTE --> La capacidad -1 de una matriz coincidirá con el índice máximo.
     * ejemplo: matriz de capacidad 6 [0][1][2][3][4][5]
     */

    private int [][] matriz;
    private int capacidad;

    private int size;

    public MatrizCuadradaEnteros(int capacidad) {
        this.matriz = new int[capacidad][capacidad];
        this.capacidad = capacidad;
        this.size =0;
    }

    public void actualizar(int valor, int fila, int columna){
        if (fila < 0 ||fila >= capacidad|| columna < 0 || columna >= capacidad){
            throw new IndexOutOfBoundsException("Fila o columna fuera de rango");
        }
        matriz[fila][columna]= valor;
    }

    public void resetear(int fila, int columna){
        if (fila < 0 ||fila >= capacidad|| columna < 0 || columna >= capacidad){
            throw new IndexOutOfBoundsException("Fila o columna fuera de rango");
        }
        matriz[fila][columna] = 0;
    }

    public boolean buscar(int valor){
        for (int i = 0; i < capacidad; i++) {
            for (int j = 0; j < capacidad; j++) {
                if (matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    public int repeticiones (int elemento){
       int contador = 0;
        for (int i = 0; i < capacidad; i++) {
            for (int j = 0; j < capacidad; j++) {
                if (matriz[i][j] == elemento) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int capacidad(){
        return capacidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.capacidad; i++) {
            for (int j = 0; j < this.capacidad; j++) {
                sb.append(matriz[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
