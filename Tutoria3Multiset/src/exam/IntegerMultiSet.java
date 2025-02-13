package exam;

public class IntegerMultiSet {


    // EJERCICIO HECHO COMO UN ARRAYLIST, HAY QUE HACERLO COMO UN ARRAY SIMPLE

    private Node head;
    private Integer capacity; // capacidad máxima del multiconjunto
    private Integer size; // tamaño que tendrá cuando se consulte

    private Integer[] elements;

    public IntegerMultiSet(int capacity) {
        if (capacity <= 0) {
            System.out.println("La capacidad es 0, estás creando un multiset vacío");
            this.head = null;
            this.capacity = 0;
            this.size = 0;
            System.out.println("Introduce una capacidad válida para el multiset");
        } else {
            this.head = null;
            this.capacity = capacity;
            this.size = 0;
            System.out.println("Has creado un multiset de tamaño " + capacity + "que actualmente tiene 0 registros");
        }
    }
    public boolean insert(Integer value){
           while(size < capacity){
               Node newNode = new Node(value);
               newNode.next = head; // el siguiente nodo será el head porque insertaré por delante
               head = newNode;
               size ++;
               return true;
           }
           System.out.println("El multiset está completo");
           return false;
    }

    // otra opción para hacer el método insert:

//    public boolean insert(Integer value) {
//        if (size >= capacity) {
//            return false; // No hay espacio disponible
//        }
//        Node newNode = new Node(value);
//        newNode.next = head;
//        head = newNode;
//        size++;
//        return true;
//    }

    public boolean delete (Integer value){
            Node current = head;
            Node previous = null;
            // current apunta al nodo actual que se está evaluando en la lista. Inicialmente, comienza en head (la cabeza de la lista).
            //previous apunta al nodo anterior a current. Comienza como null porque al inicio no hay un nodo previo.

           while (current != null){
               if (current.equals(value)){ //Se compara el valor del nodo actual (current) con el valor que se desea eliminar (value).
                   //Si coinciden, se procede a eliminar el nodo actual.
                   if (previous == null){
                       head = current.next;
                       //Si previous es null, significa que el nodo actual (current) es la cabeza de la lista.
                       //La cabeza se actualiza para que apunte al siguiente nodo (current.next), eliminando efectivamente el nodo actual de la lista.
                   }else {
                       previous.next = current.next;
                       //Si previous no es null, significa que el nodo a eliminar no es la cabeza.
                       //En este caso, el puntero next del nodo anterior (previous) se actualiza para saltarse el nodo actual (current) y apuntar directamente al siguiente nodo (current.next).
                   }
                   size --;
                   return true;
               }
               previous = current;
               current = current.next;
               //Si el nodo actual no coincide con el valor a eliminar, se avanza al siguiente nodo:
               //previous se actualiza para apuntar al nodo actual.
               //current se mueve al siguiente nodo.

           }
           return false;

           //Busca en la lista el nodo que contiene el valor value.
        //Si lo encuentra:
        //Actualiza los punteros para eliminar ese nodo de la lista.
        //Ajusta el tamaño de la lista (size--).
        //Devuelve true.
        //Si no lo encuentra, devuelve false.
        //Ejemplo
        //Supongamos que la lista es: 10 -> 20 -> 30 -> 40, y llamas a delete(20):
        //
        //current comienza en 10, no coincide con 20. Avanza.
        //current apunta a 20, coincide con el valor. El nodo se elimina ajustando los punteros:
        //10 ahora apunta a 30.
        //Devuelve true y la lista queda: 10 -> 30 -> 40.

    }

    public boolean search (Integer elemento) {

        Node current = head;

        while (current != null) {
            if (current.value.equals(elemento)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size(){

        return size;
    }

    public void empty(){
        Node current = head;

        while (head !=null) {
            head = current.next;
        }
        head = null;
        size =0;
        System.out.println("El multiset está vacío");
    }
    public String toString(){
        if (size == 0) {
            return "[Empty multiset]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append("  ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
