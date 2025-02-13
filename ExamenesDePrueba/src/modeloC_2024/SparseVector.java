package modeloC_2024;

// TAD VECTOR DISPERSO DE ENTEROS --> LISTA DOBLEMENTE ENLAZADA
public class SparseVector {

    private int size;
    private Node first;

    public SparseVector(Integer size){

      this.size = size;
      this.first = null;
    }

    public boolean setValue(Integer index, Integer value) {
        if (index < 1 || index > size || value == 0) {
            return false;
        }
        // para buscar si el índice existe y actualizar el valor hay que recorrer el vector.
        Node aux = first;
        while (aux != null) { // cuando el nodo auxiliar contenga datos...
            if (aux.index == index) { // si se encuentra el índice...
                aux.value = value; // si el índice existe actualizamos el valor
                return true;
            }
            aux= aux.next; // hay que hacer esto para que no se quede pillado en el bucle
        }
        ////// vamos a insertar un elemento
        // declaramos nuevo nodo
        //Aquí si instanciamos porque tenemos que crear una nueva caja dentro de las cajas que se instancian
        Node newNode = new Node(index,value); // creamos elemento a insertar
        if (first != null){  // si hay nodos en el vector
            first.prev = newNode;
            newNode.next = first;
            first = newNode;

        } else{
            first = newNode;
        }
        //aqui estamos como si la lista estuviese vacía
        return true;
    }
    public boolean resetIndex (Integer index){
        if (index < 1 || index > size){
            return false;
        }
        Node aux = first;
        while (aux != null) { // cuando el nodo auxiliar contenga datos...
            if (aux.index == index) { // si se encuentra el índice...
                if (aux.prev != null){ // si hay nodo previo
                    aux.prev.next = aux.next; // el siguiente a ese nodo previo es el siguiente al nodo auxiliar (elimino el nodo)
                } else {
                    first = aux.next; // si no hay nodo previo first será el siguiente al nodo auxiliar (con lo que elimino el nodo aux)
                }
                if (aux.next != null){
                    aux.next.prev = aux.prev; //el previo del siguiente será el previo del actual (me cargo el actual)
                }
            }
            aux= aux.next;
        }
        return false; // El índice no existe
    }

    // leer (índice). Devuelve el valor del vector en un índice determinado.
    public Integer getValue(Integer index){
        if (index < 1 || index > size){
            return null;
        }
        Node aux = first;
        while (aux != null) { // cuando el nodo auxiliar contenga datos...
            if (aux.index == index) { // si se encuentra el índice...
                return aux.value;
            }
            aux = aux.next;
        }
        return 0; // Si el índice no está en la lista, su valor es 0
    }

    // devolver valores distintos de 0
    public Integer noZeros(){
        int contador = 0;
        Node aux = first;
        while (aux != null){
            contador ++;
            aux = aux.next;
        }

        return contador;
    }

    public String toString(){
        if (first == null){
            return "[zero vector]"; // si no hay primero implica que el vector está vacío
        }
        StringBuilder sb = new StringBuilder();
        Node aux = first;
        while (aux != null) {
            sb.append("[index=").append(aux.index).append(", value=").append(aux.value).append("] ");
            aux = aux.next;
        }
        return sb.toString();
        //return sb.toString().trim();

    }
}

    

