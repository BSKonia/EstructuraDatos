package Ejercicios;

public class IntegerStaticQueue {
    private Integer[] elements;   // Array para almacenar los elementos
    private int first;            // Índice del primer elemento
    private int last;             // Índice del primer elemento
    private int capacity;         // Capacidad de la estructura
    private int count;            // Número de elementos en la cola

    // Constructor
    public IntegerStaticQueue(int size) {
        elements = new Integer[size];
        capacity = size;
        first = 0;
        last = -1;
        count = 0;
    }


    // Método para añadir un elemento al final de la cola
    // Si la cola está llena devuelve false
    public boolean enqueue(Integer item) {
        if (isFull()) {
            return false;
        }
        last = (last + 1) % capacity; // Incremento circular
        elements[last] = item;
        count++;
        return true;
    }

    // Método para extraer un elemento de la cola
    // Si está vacía devuelve null
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        Integer item = elements[first];
        first = (first + 1) % capacity; // Circular increment
        count--;
        return item;
    }

    // Método que devuelve el primer elemento de la cola sin extraerlo
// Si está vacía, devuelve null
    public Integer first() {
        if (isEmpty()) {
            return null;
        }
        return elements[first];
    }

    public void clear(){
        System.out.println("Al usar este método vaciamos la cola");
        first = 0;
        last = -1;
        count = 0;
    }

    public Integer size(){
        return count;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i=first; i<=last; i = (i + 1) % capacity) {

            // Añade el valor del elemento actual a la cadena
            sb.append(elements[i]);

            // Si no es el último nodo, añade una coma
            if (i != last)
                sb.append(",");
        }

        sb.append("]");
        return sb.toString();

    }

    // Método para comprobar si la cola está vacía
    public boolean isEmpty() {
        return count == 0;
    }

    // Método para comprobar si la cola está llena
    public boolean isFull() {
        return count == capacity;
    }

}