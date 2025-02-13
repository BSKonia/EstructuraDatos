package tema3Ejercicios;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringList {
    protected Node first;
    protected Node last;
    protected int numElems;
    public StringList() {
        first= null;
        last= null;
        numElems = 0;
    }
    // append
    public void add(String str) {
        Node node= new Node(str); // Crear el nuevo nodo
        if(first== null) { // la lista está vacía
            first= node;
            last= node;
        }
        else{ // la lista NO está vacía
            last.next= node;

            last= node;
        }

        numElems++;
    }


    // get
    public String get(int index) {

        int i;

        if ( index <0  || index >= numElems)
            return null;
        else {

            i = 0;
            Node aux = first;

            for (i=0; i<index; i++)
                aux = aux.next;

            return aux.data;
        }
    }

    // indexOf
    public int indexOf(String str) {

        int index = 0;
        Node aux = first;

        while ( aux != null && aux.data != str) {

            aux = aux.next;
            index++;
        }

        if (aux == null)
            return -1;
        else
            return index;

    }

    public boolean delete(int index) {

        Node prev, current;
        int i;


        if ((index<0) || (index >= numElems))
            return false;

        // Caso especial lista de un elemento
        if (numElems == 1) {

            first = null;
            last = null;
            return true;
        }

        // Caso especial: borrado del primer elemento
        // Recordar que en este punto, la lista es de más de un elemento
        if (index == 0) {
            first = first.next;
            return true;
        }

        // A partir de aquí, la lista es de más de un elemento
        // y el índice que se quiere borrar no es el primero
        prev = first;
        current = first;

        // Bucle para posicionar los punteros current y prev
        for (i = 0; i<index; i++) {
            prev = current;
            current = current.next;
        }

        // current apunta al nodo que se quiere borrar
        // prev apunta a nodo anterior
        // enlazar el prev con el next de current
        prev.next = current.next;

        // ajustar el puntero last si es necesario
        if (last == current)
            last = prev;

        return true;
    }

    /**
     * Implementamos metodo size --> Ejercicio 1
     *  implementar el método size de manera que recorra la
     * lista contando el número de elementos, y finalmente devuelva el valor acumulado.
     *
     * En primer lugar, dentro del método size se define la variable elements que se
     * utilizará como contador durante el recuento de los elementos de la lista. Por otra
     * parte, se usa la variable aux para recorrer la lista. Inicialmente aux apunta al
     * primer elemento de la lista (first), y dentro del bucle while de recorrido de la lista,
     * la operación aux = aux.next hace que el puntero aux avance una posición en la
     * lista. Por cada posición avanzada, se incrementa una unidad el contador elements.
     *
     */
    public int size(){
        int elements = 0;
        Node aux = first;

        while(aux != null){
            elements ++;
            aux = aux.next;

        }
        return elements;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node aux = this.first;
        while (aux != null) {
            // Añade el valor del nodo actual a la cadena
            sb.append(aux); // siempre que haya algo en el nodo (que no sea null) lo añade a la cadena.
            // Si no es el último nodo, añade una coma
            if (aux.next != null) {
                sb.append(",");
                // Avanza al siguiente nodo
            }
            aux = aux.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String method() { //Ejercicio 3

        if (this.first != null)
            return this.first.data;
        else
            return null;
    }
    /**
     * En primer lugar, se comprueba si la lista tiene al menos un elemento, y en ese
     * caso, se devuelve el primer elemento:
     * if (this.first != null)
     *   return this.first.data;
     *
     * Por otra parte, si la lista está vacía, devuelve null:
     *  else
     *   return null; 
     */

    //Ejercicio 4 --> método arraylist
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = new ArrayList<>();

        // creo nodo auxiliar para recorrer la lista
        Node aux = this.first;

        // recorro la lista
        while(aux != null){
            aux = aux.next;
            list.add(aux.data);
        }
        return list;

    }

    //ejercicio 4 --> Lista de tickets. Es tipo Cola, pero a veces hay que insertar delante en lugar de al final.

}
