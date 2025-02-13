package modeloA_2023;

public class ConjuntoEnteros {
    /**
     * Al usar como soporte un array de enteros no hay top (porque es un conjunto). Si fuera una pila o una cola si
     *
     */
    private int capacidad;

    private int [] elementos;

    private int size;


    public ConjuntoEnteros(int capacidad) {
        this.capacidad = capacidad;
        this.size = 0;
        this.elementos = new int[capacidad];
    }

    public boolean insertar(int elemento) {
        // Verificar si el elemento ya existe
        for (int i = 0; i < size; i++) {
            if (elementos[i] == elemento) {
                return false; // Ya existe, no se inserta
            }
        }
        // Verificar si hay espacio
        if (size >= capacidad) {
            return false; // No hay capacidad
        }
        // Insertar el elemento
        elementos[size] = elemento;
        size++;
        return true;
    }

    public boolean borrar (int elemento){
        for (int i = 0; i < size; i++) {
            if (elementos[i]==(elemento)) {
                for (int j = i; j < size - 1; j++) {    // Desplazar los elementos a la izquierda
                    elementos[j] = elementos[j + 1];
                }
                size --;
                return true;
            }
        }
        return false;
    }

    public boolean buscar (int elemento){
        for (int i = 0; i < size; i++) {
            if (elementos[i] == (elemento)) {
            return true;
            }
        }
        return false;
    }

    public int cardinal(){
        return size;
    }

    public int capacidad(){
        return capacidad;
    }

    public void vaciar(){
        size = 0;

    }
}


