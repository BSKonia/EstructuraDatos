package ColaListaDoblementeEnlazada;

/**
 *  Cola con Lista Doblemente Enlazada en Java
 * 📌 Operaciones implementadas:
 *
 * enqueue(int data): Agregar un elemento al final de la cola.
 * dequeue(): Remover y devolver el primer elemento (FIFO).
 * peek(): Consultar el primer elemento sin extraerlo.
 * isEmpty(): Verificar si la cola está vacía.
 * printQueue(): Imprimir todos los elementos de la cola.
 */
public class DoublyLinkedQueue {
    private Node front, rear;

    public DoublyLinkedQueue() {
        this.front = this.rear = null;
    }

    // Insertar en la cola (enqueue)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) { // Si la cola está vacía
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        newNode.prev = rear;
        rear = newNode;
    }

    // Extraer de la cola (dequeue)
    public int dequeue() {
        if (front == null) {
            System.out.println("Cola vacía");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null; // La cola queda vacía
        }
        return value;
    }

    // Consultar el primer elemento (peek)
    public int peek() {
        if (front == null) {
            System.out.println("Cola vacía");
            return -1;
        }
        return front.data;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Imprimir la cola
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
