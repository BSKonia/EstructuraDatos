package Ejercicios;

public class Mainprofe {
    public static void main(String[] args) {
        System.out.println("probando la estructura de la cola de enteros");

        IntegerStaticQueue cola = new IntegerStaticQueue(10);

        cola.enqueue(7);
        cola.enqueue(4);
        cola.enqueue(3);
//        cola.enqueue(2);
//        cola.enqueue(1);
//        cola.enqueue(9);
//        cola.enqueue(3);
//        cola.enqueue(8);
//        cola.enqueue(6);
//        cola.enqueue(5);

        System.out.println(cola.first());
        System.out.println(cola.enqueue(5)); // me da false, la he llenado y no me deja encolar
        System.out.println(cola.dequeue()); // me imprime el 7, el primero que sale de la cola es el primer elemento
        System.out.println(cola.enqueue(4)); // encolamos el numero 4

        System.out.println(cola.size());

        System.out.println(cola.toString());
        //probamos el metodo clear
        if (cola.dequeue() != null)
            cola.clear();

        if (!cola.isEmpty())
            cola.clear();
        System.out.println(cola.toString());
    }
}



