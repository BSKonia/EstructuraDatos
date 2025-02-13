package examen_clase_3101;

/**
 *
 * Importante --> si la estructura fuese dinámica no se puede usar cola circular
 */

import java.util.ArrayList;
import java.util.Arrays;
public class IntegerStackOrQueue {
    private Integer[] elementos;
    private int size;
    private int capacity;
    private int first;
    private int last;
    private int top;
    private int mode;

    public IntegerStackOrQueue(){
        this.capacity = 10;
        this.elementos = new Integer[capacity];
        this.size = 0;
        this.first = 0;
        this.last = 0;
        this.top = -1;
        this.mode = 0; // Por defecto, modo pila
    }

    public void setStackMode(){
        mode = 0;
    }
    public void setQueueMode(){
        mode = 1;
    }
    public int getMode(){
        return mode;
    }
    public void insert(Integer i){

        capacity = elementos.length;
        if (size == capacity) {
            System.out.println("El array ya está lleno, debes duplicar su tamaño");
            resize();
        }
        if (mode == 0){
            System.out.println("Vamos a realizar la inserción en modo pila");
                top++;
                elementos[top] = i; // en una pila sólo se pueden añadir elementos en la cima de la pila
            }
        if (mode == 1){
            System.out.println("Vamos a realizar la inserción en modo cola");
            elementos[last] = i; // añadimos el elemento al final de la cola
            last = (last + 1) % capacity; // tratamos la cola como si fuera cola circular.
            // first y last avanzan dentro del array de manera que, al llegar al final, vuelven al inicio si hay espacio disponible.
            // Esto evita la necesidad de mover todos los elementos al extraer datos de la cola.
            //last = (last + 1) % capacity asegura que si last llega al final del array (capacity - 1), vuelva a 0 en lugar de desbordarse.
        }
        size ++;
    }

    public Integer get() {
        if (size ==0){
            System.out.println("La estructura está vacía");
            return null;
        }
        Integer element = null;
        if (mode == 0) {
            System.out.println("extracción de elementos en modo pila");
            element= elementos[top--];
        }
        if (mode == 1){
            System.out.println("extracción de elementos en modo cola");
            element = elementos[first];
            first = (first + 1) % capacity;
        }
        size--;
        return element;
    }
    public ArrayList<Integer> list() {
        ArrayList<Integer> list = new ArrayList<>();
        if (mode == 0) { // modo pila
            for (int i = top; i >= 0; i--) {
                list.add(elementos[i]);
            }
        }
        if (mode == 1){ // modo cola
            int index = first;
            for (int i = 0; i < size; i++) {
                list.add(elementos[index]);
                index = (index + 1) % capacity;
            }
        }
        return list;
    }

    private void resize() {
        capacity *= 2;
        elementos = Arrays.copyOf(elementos, capacity);
    }


}
