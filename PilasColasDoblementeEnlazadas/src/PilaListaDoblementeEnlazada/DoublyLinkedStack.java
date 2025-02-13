package PilaListaDoblementeEnlazada;

/**
 * 💡 Descripción: Implementa una pila (stack) con una lista doblemente enlazada.
 *
 * 📌 Operaciones:
 *
 * push(int data): Agrega un elemento a la pila.
 * pop(): Extrae el último elemento ingresado (LIFO).
 * peek(): Devuelve el último elemento sin extraerlo.
 */
public class DoublyLinkedStack {
    private Node top;

    public DoublyLinkedStack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top != null) {
            newNode.next = top;
            top.prev = newNode;
        }
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Pila vacía");
            return -1;
        }
        int value = top.data;
        top = top.next;
        if (top != null) {
            top.prev = null;
        }
        return value;
    }

    public int peek() {
        return top != null ? top.data : -1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
