
import java.util.PriorityQueue;
public class Main {

    public static void main(String[] args) {
        /**
         * Consultar en la documentación oficial de Java (ver web de Oracle, que es la
         * empresa actualmente propietaria de Java) la clase PriorityQueue que implementa
         * una cola de prioridad basada en un heap de mínimos. Codificar un programa que
         * utilice la clase PriorityQueue para ordenar la secuencia de números 24, 13, 56, 72,
         * 100, 89, 3, 8.
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(24);
        pq.add(13);
        pq.add(56);
        pq.add(72);
        pq.add(100);
        pq.add(89);
        pq.add(3);
        pq.add(8);

        System.out.println(pq.toString());

        int size = pq.size();
        System.out.println("Tamaño inicial de la cola de prioridad: "+size);

        //extraccion de elementos de la cola
        //recorremos la cola y usamos remove

        for (int i= 0; i<size; i++){
            System.out.println(pq.remove());
        }

        // Mostrar el tamaño final de la cola de prioridad (debe de ser 0
        // porque se han extraido todos los elementos)
        System.out.println("Tamaño de la cola de prioridad después de la extracción de elementos " + pq.size());
    }
}

