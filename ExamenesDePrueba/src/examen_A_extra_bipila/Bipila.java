package examen_A_extra_bipila;

import java.io.IOException;

public class Bipila {

    private int[] pilaIzquierda;
    private String[] pilaDerecha;
    private int topeIzquierda;
    private int topeDerecha;

    public Bipila(int capacidad) {
        this.pilaIzquierda = new int[capacidad];
        this.pilaDerecha = new String[capacidad];
        this.topeIzquierda = -1; // cuando el tope es -1 indica pila vacía
        this.topeDerecha = -1;
    }

    public boolean apilarIzquierda(int elemento) {
        if (topeIzquierda < pilaIzquierda.length -1) {
            topeIzquierda++; // aumento una posición al topeizquierda
            pilaIzquierda[topeIzquierda] = elemento; // ACCEDEMOS A LA POSICIÓN TOPEIZQUIERDA DEL ARRAY PILAIZQUIERDA. COMO SI FUERA [0]
            return true;
        }
        return false; // Pila llena
    }

    public boolean apilarDerecha(String elemento) {
        if (topeDerecha < pilaDerecha.length -1) {
            topeDerecha++;
            pilaDerecha[topeDerecha] = elemento;
            return true;
        }
        return false; // Pila llena
    }

    public int desapilarIzquierda(){
        if (topeIzquierda < 0){ //no habrá nada que extraer porque la pila estará vacía
            throw new IllegalStateException();
        }
        int elemento = pilaIzquierda[topeIzquierda]; // Obtén el valor actual
        topeIzquierda--; // Ahora decrece el índice
        return elemento; // Devuelve el valor
    }

    public String desapilarDerecha(){
        if (topeDerecha < 0){
            throw new IllegalStateException();
        }
        String elemento = pilaDerecha[topeDerecha];
        topeDerecha--;
        return elemento;
    }

    public int cimaIzquierda(){
        if (topeIzquierda < 0){ //no habrá nada que extraer porque la pila estará vacía
            throw new IllegalStateException();
        }
        return pilaIzquierda[topeIzquierda];
    }

    public String cimaDerecha(){
        if (topeDerecha < 0){
            throw new IllegalStateException();
        }
        return pilaDerecha[topeDerecha];
    }

    public void limpiarIzquierda(){
        if (topeIzquierda < 0){
            System.out.println("La pila ya está vacía, no se puede vaciar");
        }
        topeIzquierda = -1;
    }

    public void limpiarDerecha(){
        if (topeDerecha < 0) {
            System.out.println("La pila ya está vacía, no se puede vaciar");
        }
        topeDerecha = -1;
    }

    public boolean vaciaIzquierda(){
        if (topeIzquierda < 0){
            return true;
        }
        else return false;
    }

    public boolean vaciaDerecha(){
        if (topeDerecha < 0){
            return true;
        }
        else return false;
    }
}
