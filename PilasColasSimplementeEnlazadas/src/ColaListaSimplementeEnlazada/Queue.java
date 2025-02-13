package ColaListaSimplementeEnlazada;

public class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Insertar en la cola (enqueue)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Extraer de la cola (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return value;
    }

    // Consultar el primer elemento (peek)
    public int peek() {
        if (isEmpty()) {
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
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
