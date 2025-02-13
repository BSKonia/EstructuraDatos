package colaprioridad;

public class Nodo {
    public String valor;
    public int prioridad;


    // Constructor
    public Nodo(String nombre, int valorPrioridad) {
        valor = nombre;
        prioridad = valorPrioridad;
    }

    // Método para imprimir el contenido del nodo
    public String toString() {
        return "(" + valor + ", " + prioridad + ")";
    }

}
