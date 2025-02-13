import integercontainers.IntegerQueue;
import integercontainers.IntegerStack;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------Probando la estructura IntegerStack--------");

        IntegerStack stack = new IntegerStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Pila después de apilar 10, 20, 30: " + stack);
        System.out.println("Desapilando elemento: " + stack.pop());
        System.out.println("Pila tras desapilar elemento de la cabecera: " + stack);
        System.out.println("Elemento en la cima: " + stack.top());
        System.out.println("Tamaño de la pila: " + stack.size());
        System.out.println("¿Contiene 20? " + stack.search(20));
        System.out.println("¿Mostrando contenido de la pila: " + stack);

        System.out.println("\n----------Probando la estructura IntegerQueue ---------------");
        IntegerQueue queue = new IntegerQueue();
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        System.out.println("Cola después de insertar 10, 20, 30: " + queue);
        System.out.println("Sacando elemento: " + queue.remove());
        System.out.println("Cola tras extraer elemento de la cabecera: " + queue);
        System.out.println("Elemento en la cabecera: " + queue.seek());
        System.out.println("Tamaño de la cola: " + queue.size());
        System.out.println("¿Contiene 60? " + queue.search(60));
        System.out.println("¿Mostrando contenido de la cola: " + queue);
    }
}
