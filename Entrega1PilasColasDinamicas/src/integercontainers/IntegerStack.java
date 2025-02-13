package integercontainers;

public class IntegerStack {
    private Node top; // Nodo en la cima de la pila
    private int size; // Número de elementos en la pila

    //constructor de la clase
    public IntegerStack() {
        this.top = null;
        this.size = 0;
    }

    // Apilar un elemento
    public void push(Integer i) {
        Node newNode = new Node(i);
        newNode.next = top; // Apunta al antiguo "top"
        top = newNode;      // Ahora este es el nuevo "top"
        size++;
    }

    // Desapilar un elemento
    public Integer pop() {
        if (top == null) {
            return null; // Pila vacía
        }
        Integer value = top.data; // Valor del nodo en la cima
        top = top.next;           // Mueve la cima al siguiente nodo
        size--;
        return value;
    }

    // Obtener el elemento en la cima
    public Integer top() {
        return (top == null) ? null : top.data;
    }

    // Contar numero de elementos
    public int size() {
        return size;
    }

    // Comprobar si un elemento está en la pila
    public boolean search(Integer i) {
        Node current = top;
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
        if (top == null) {
            return "Empty stack";
        }
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
