package ejerciciocorrecto;

public class IntegerMultiset {

    private Integer[] elements;		// Array de soporte
    private int size;				// Número de elementos actuales del conjunto
    private int capacity;			// Capacidad del multiconjunto

    // Constructor
    public IntegerMultiset(int capacity) {
        // CONTROLAR QUE capacity SEA >0
        // SI NO, CREAR MULTISET DE 10 ELEMENTOS

        this.capacity = capacity;			    // Se puede prescindir de este atributo y usar elements.length
        this.elements = new Integer[capacity];	// Creacción del array
        this.size = 0;						    // Inicialización del número de elementos
    }

    // Método para insertar un elemento
    public boolean insert(Integer value) {
        if (size < capacity) {
            elements[size++] = value;
            return true;
        }
        return false;
    }

    // Método para borrar un elemento
    public boolean delete(Integer value) {

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                for (int j = i; j < size - 1; j++) {    // Desplazar los elementos a la izquierda
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // Método para buscar un elemento
    public boolean search(Integer value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Método para vaciar el multiconjunto
    public void empty() {
        size = 0;
    }

    // Método para obtener una representación en formato string del multiconjunto
    public String toString() {

        if (size == 0) {
            return "[Empty multiset]";
        }

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size - 1; i++) {		// Recorrido del array hasta el penúltimo elemento
            sb.append(elements[i]).append("  ");
        }
        sb.append(elements[size - 1]).append("]");

        return sb.toString();
    }
}


