package tema3Ejercicios;

import java.util.LinkedList;
//ejercicio 4 --> Lista de tickets. Es tipo Cola, pero a veces hay que insertar delante en lugar de al final.
public class Main {
    public static void main(String[] args) {
        LinkedList<String> tickets = new LinkedList<>();

        tickets.addLast("Ticket 1 - Problema de servidor de correo");
        tickets.addLast("Ticket 2 - Error de conexión");
        tickets.addLast("Ticket 3 - Problema de acceso al sistema");

        System.out.println("A continuación se muestran los tickets existentes por orden de llegada");
        for (String ticket:tickets) {
            System.out.println(ticket);
        }

        // añadimos ticket urgente al inicio de la lista --> nos saltamos el orden --> ticket urgente

        tickets.addFirst("Ticket urgente - Servidor de correo electrónico caído");
        System.out.println("\nTickets actualizados");
        for (String ticket:tickets) {
            System.out.println(ticket);
        }

        //eliminamos primer elemento
        String ticketprocesado = tickets.removeFirst();
        System.out.println("Procesando " + ticketprocesado);

    }


}
