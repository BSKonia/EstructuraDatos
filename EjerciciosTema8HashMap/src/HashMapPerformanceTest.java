import java.util.HashMap;
public class HashMapPerformanceTest {
    public static void main(String[] args) {
// Tamaño del HashMap
        int size = 10000;
// Crear un HashMap para almacenar pares clave-valor
        HashMap<Integer, Integer> test = new HashMap<>(size);
// Medir el tiempo de inserción
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            test.put(i, i);
        }
        long endTime = System.nanoTime();
        long insertionTime = endTime - startTime;
        System.out.println("Tiempo medio de inserción de un elemento de "
                + size + " elementos: " + insertionTime / size + " ns");
    }
}
