package ColaListaDoblementeEnlazada;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedQueue queue = new DoublyLinkedQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Cola después de encolar elementos:");
        queue.printQueue();

        System.out.println("Elemento eliminado: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Elemento en el frente: " + queue.peek());

        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Cola después de encolar más elementos:");
        queue.printQueue();

        System.out.println("Eliminando todos los elementos...");
        while (!queue.isEmpty()) {
            System.out.println("Elemento eliminado: " + queue.dequeue());
        }

        System.out.println("Estado final de la cola:");
        queue.printQueue();
    }
}
