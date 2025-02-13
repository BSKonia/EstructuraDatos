package PilaListaEnlazadaSimple;

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Insertar en la pila (push)
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Extraer de la pila (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // Consultar el elemento en la cima (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
            return -1;
        }
        return top.data;
    }

    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Imprimir la pila
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
