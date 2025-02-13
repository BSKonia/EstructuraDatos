package PilaListaEnlazadaSimple;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        System.out.println("Elemento eliminado: " + stack.pop());
        stack.printStack();

        System.out.println("Elemento en la cima: " + stack.peek());
    }
}
