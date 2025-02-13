package examen_A_extra_bipila;

public class Main {
    public static void main(String[] args) {

        Bipila bipila = new Bipila(3);

        // Pruebas para la pila izquierda (enteros)
        System.out.println("Apilando en la pila izquierda:");
        System.out.println("Apilar 10: " + bipila.apilarIzquierda(10));
        System.out.println("Apilar 20: " + bipila.apilarIzquierda(20));
        System.out.println("Apilar 30: " + bipila.apilarIzquierda(30));
        System.out.println("Apilar 40 (debería fallar): " + bipila.apilarIzquierda(40));

        System.out.println("Cima de la pila izquierda: " + bipila.cimaIzquierda());
        System.out.println("Desapilar: " + bipila.desapilarIzquierda());
        System.out.println("Nueva cima de la pila izquierda: " + bipila.cimaIzquierda());
        System.out.println("Vaciar la pila izquierda.");
        bipila.limpiarIzquierda();
        System.out.println("Está vacía la pila izquierda? " + bipila.vaciaIzquierda());

        // Pruebas para la pila derecha (strings)
        System.out.println("\nApilando en la pila derecha:");
        System.out.println("Apilar 'uno': " + bipila.apilarDerecha("uno"));
        System.out.println("Apilar 'dos': " + bipila.apilarDerecha("dos"));
        System.out.println("Apilar 'tres': " + bipila.apilarDerecha("tres"));
        System.out.println("Apilar 'cuatro' (debería fallar): " + bipila.apilarDerecha("cuatro"));

        System.out.println("Cima de la pila derecha: " + bipila.cimaDerecha());
        System.out.println("Desapilar: " + bipila.desapilarDerecha());
        System.out.println("Nueva cima de la pila derecha: " + bipila.cimaDerecha());
        System.out.println("Vaciar la pila derecha.");
        bipila.limpiarDerecha();
        System.out.println("Está vacía la pila derecha? " + bipila.vaciaDerecha());
    }



}
