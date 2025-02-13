package integercontainers;

public class IntegerQueue {
    private Node head; // Nodo al inicio de la cola
    private Node tail; // Nodo al final de la cola
    private int size;  // Número de elementos en la cola

    public IntegerQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insertar un elemento
    public void insert(Integer i) { // i ES EL DATO QUE QUEREMOS INSERTAR
        Node newNode = new Node(i);
        if (tail == null) { // La cola está vacía
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Añade al final
            tail = newNode;      // Actualiza el final
        }
        size++;
    }

    // Sacar un elemento
    public Integer remove() {
        if (head == null) {
            return null; // Cola vacía
        }
        Integer value = head.data; // Valor en la cabecera
        head = head.next;          // Mueve la cabecera al siguiente nodo
        if (head == null) {        // Si la cola quedó vacía
            tail = null;
        }
        size--;
        return value;
    }

    // Obtener el elemento en la cabecera
    public Integer seek() {
        return (head == null) ? null : head.data;
    }

    // Contar elementos
    public int size() {
        return size;
    }

    // Comprobar si un elemento está en la cola
    public boolean search(Integer i) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(i)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Mostrar contenido
    @Override
    public String toString() {
        if (head == null) {
            return "Empty queue";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
