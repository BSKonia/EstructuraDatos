package Hashtest;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
//        TreeMap<Integer, Integer> map = new TreeMap<>();

        Random random = new Random();

        // Distintos tamaños de datos que se van a probar
        int[] testSize = {1000, 10000, 100000, 1000000, 10000000};

        System.out.printf("%-15s %-15s\n", "Elementos", "Tiempo (ms)");

        for (int n : testSize) {

            // Llenar el HashMap con n elementos
            for (int i = 0; i < n; i++) {
                map.put(i, i);
            }

            // Tiempo inicial
            long inicio = System.nanoTime();

            // Realizar 100000 búsquedas aleatorias
            for (int i = 0; i < 100000; i++) {
                // Generar clave aleataoria en el intervalo [0, n]
                int key = random.nextInt(n);
                // Acceder a la clave dentro del diccionario
                map.get(key);
            }

            // Tiempo final
            long fin = System.nanoTime();

            // Calcular tiempo de acceso y convertirlo a milisegundos
            double t = (fin - inicio) / 1000000.0;
            System.out.printf("%-15d %-15.3f\n", n, t);
        }
    }
}


