package ColaListaSimplementeEnlazada;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Elemento eliminado: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Elemento en el frente: " + queue.peek());
    }
}
