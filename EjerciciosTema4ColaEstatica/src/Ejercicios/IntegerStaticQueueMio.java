package Ejercicios;

import java.util.Arrays;

public class IntegerStaticQueueMio {

    /**
     * Como es una cola tenemos que almacenar 1º y último elemento, porque extraigo por delante y saco por atrás
     * Si fuera una pila NO, porque inserto y extraigo por el mismo sitio
     */
    private Integer[] queue;
    private int first;
    private int last;
    private int size;
    private int capacity;


    public IntegerStaticQueueMio(int capacity){
        queue = new Integer[capacity];
        first = 0;
        last = -1;
        size = 0; // tamaño de la cola es 0 inicialmente, no hay elementos
        this.capacity = capacity; // capacidad es dada por la ejecución del constructor
    }
    public boolean enqueue(Integer element){
        if (size< capacity){
            last = (last + 1) % capacity; // Incremento circular
            queue[last] = element;
            size ++;
            return true;
        }
        else
            return false;
//        if (capacity == size){
//            System.out.println("La cola está llena");
//            return false;
//        }

    }

    public Integer dequeue() {
        if (size == 0){
            System.out.println("No puedes extraer nada porque la cola está vacía");
            return null;
        }
            Integer element = queue[first];
            first = (first + 1) % capacity; // Circular incremento
            size--;
            return element;
    }

    public Integer first() {
        if (size == 0){
            System.out.println("No hay primer elemento, la cola está vacía");
            return null;
        }
        return queue[first];
    }

    public void clear(){
        System.out.println("Al usar este método vaciamos la cola");
        first = 0;
        last = -1;
        size = 0;
    }

    public Integer size(){
        return size;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity; // Índice circular. Asegura que nos mantengamos siempre dentro del rango
            sb.append(queue[index]);

            // Añade una coma si no es el último elemento
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
