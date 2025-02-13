package Exam;

public class SparseArray {

    private Node first; // este si lo ponemos como privado para que nadie pueda modificarlo
    // ahora creamos atributos rows y columns para almacenar filas y columnas
    private Integer rows;
    private Integer columns;

    public SparseArray(Integer rows, Integer columns) {
        first = null; // creamos la lista enlazada, siempre el primero apunta a vacío
        this.rows = rows;
        this.columns = columns; // aquí si que se utiliza this para diferenciarlos de los de arriba
        /**
         * Cuando los parámetros son iguales que los atributos es obligatorio utilizar this.
         */
    }
    public boolean setValue (Integer row, Integer column, Integer value) {
        if (row < 1 || column < 1 || row > rows || column > columns || value.equals(0)) {
            return false;
        }
        Node aux = first; // las variables que se declaran que pertenecen a una clase no hace falta instanciarlas
        //Esas variables no contienen nada, sólo una referencia a la clase object
        while (aux != null) {
            if ((aux.row.equals(row)) && (aux.column.equals(column))) { //se ha encontrado la posicion
                aux.value = value; //pisamos los valores con el nodo auxiliar
                return true;
            }
            aux = aux.next;
        }

        ////// vamos a insertar un elemento
        // declaramos nuevo nodo
        //Aquí si instanciamos porque tenemos que crear una nueva caja dentro de las cajas que se instancian

        Node newNode = new Node(row, column, value);

        if (first != null){ // quiere decir que la lista enlazada tendrá al menos 1 elemento
            first.prev = newNode;
            newNode.next = first;
            first = newNode;

        } else first = newNode;
        //aqui estamos como si la lista estuviese vacía
        return true;

    }
    // resetear (fila, columna)
    boolean resetPosition (Integer row, Integer column) {

        // Si la posición (row, column) es incorrecta termina el método devolviendo false
        if(row < 1 || row> rows || column < 1 || column > columns){
            return false;
        }

        Node aux = first;

        while(aux != null){
            if(aux.row.equals(row) && aux.column.equals(column)){
                // SE elimina el Nodo
                // Se distinguen dos casos:
                // 1: el nodo que se va a eliminar es el primero de la lista
                // 2: ese nodo no es el primero de la lista
                if (aux == first) { // es el primer elemento de la lista
                    first = aux.next;
                    if(first != null){
                        first.prev = null; // ajustar la referencia prev de first
                    }
                }
                else {
                    aux.prev.next = aux.next; // enlace hacia la derecha saltando el nodo eliminado
                    if(aux.next != null) {
                        aux.next.prev = aux.prev; //enlace hacia la izquierda saltando el nodo eliminado
                    }
                }
                return true;
            }
            aux = aux.next; // avanzar el nodo aux para recorrer la lista
        }
        // En este punto se ha recorrido la lista y no se ha encointrado el elemento
        return true;
    }

   // Leer (fila, columna)
    public Integer getvalue (Integer row, Integer column){
        // Si la posición (row, column) es incorrecta termina el método devolviendo null
        if(row < 1 || column < 1 || row > rows || column > columns){
            return null;
        }

        Node aux = first;

        // se recorre la lista y si se encuentra la posición se devuelve el valor
        while(aux != null){
            if(aux.row.equals(row) && aux.column.equals(column)) {
                return aux.value;
            }

            aux = aux.next;
        }
        // en este punto no se ha encontrado la posición en la lista.
        // eso quiere decir que el valor del array en esa posición vale 0.
        return 0;
    }

    // valores distintos de cero
    public Integer noZeros(){
        int contadorZeros = 0;

        Node aux = first;

        //Se cuentan los elementos de la lista
        while(aux != null){
            contadorZeros++;
            aux = aux.next;
        }

        return contadorZeros;
    }

    //Contenido de la lista en formato string:

    @Override
    public String toString(){

        Node aux;

        if(first == null) {
            return "[Zero array]";
        }

        StringBuilder Sb = new StringBuilder();

        aux = first;

        while (aux != null) {
            Sb.append(aux).append(" "); // aux es de tipo Node --> En la clase Node hay que definirn toString
            aux = aux.next;
        }
        return Sb.toString();

    }
}
