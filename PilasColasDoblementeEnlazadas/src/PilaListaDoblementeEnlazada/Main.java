package PilaListaDoblementeEnlazada;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedStack stack = new DoublyLinkedStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        System.out.println("Elemento eliminado: " + stack.pop());
        stack.printStack();
    }

}
