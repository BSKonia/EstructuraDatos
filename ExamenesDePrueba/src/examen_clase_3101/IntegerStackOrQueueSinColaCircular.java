package examen_clase_3101;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ejercicio hecho tratando la cola como cola normal,
 */
public class IntegerStackOrQueueSinColaCircular {
        private Integer[] elementos;
        private int size;
        private int capacity;
        private int first;
        private int last;
        private int top;
        private int mode;

        public IntegerStackOrQueueSinColaCircular() {
            this.capacity = 10;
            this.elementos = new Integer[capacity];
            this.size = 0;
            this.first = 0;
            this.last = 0;
            this.top = -1;
            this.mode = 0; // Por defecto, modo pila
        }

        public void setStackMode() {
            mode = 0;
        }

        public void setQueueMode() {
            mode = 1;
        }

        public int getMode() {
            return mode;
        }

        public void insert(Integer i) {
            capacity = elementos.length;
            if (size == capacity) {
                System.out.println("El array ya está lleno, debes duplicar su tamaño");
                resize();
            }

            if (mode == 0) {
                System.out.println("Vamos a realizar la inserción en modo pila");
                top++;
                elementos[top] = i; // Se añade en la cima de la pila
            }

            if (mode == 1) {
                System.out.println("Vamos a realizar la inserción en modo cola");
                if (last >= capacity) {
                    reorganizeQueue();  // Mueve elementos si hay espacio al inicio
                }
                elementos[last] = i; // Añadimos el elemento al final de la cola
                last = last + 1;
            }
            size++;
        }

        public Integer get() {
            if (size == 0) {
                System.out.println("La estructura está vacía");
                return null;
            }
            Integer element = null;

            if (mode == 0) {
                System.out.println("Extracción de elementos en modo pila");
                element = elementos[top--];
            }

            if (mode == 1) {
                System.out.println("Extracción de elementos en modo cola");
                element = elementos[first];
                first = first + 1;
                if (first == last) { // Si la cola está vacía, reiniciar índices
                    first = 0;
                    last = 0;
                }
            }
            size--;
            return element;
        }

        public ArrayList<Integer> list() {
            ArrayList<Integer> list = new ArrayList<>();
            if (mode == 0) { // Modo pila
                for (int i = top; i >= 0; i--) {
                    list.add(elementos[i]);
                }
            }
            if (mode == 1) { // Modo cola
                for (int i = first; i < last; i++) {
                    list.add(elementos[i]);
                }
            }
            return list;
        }

        private void resize() {
            capacity *= 2;
            elementos = Arrays.copyOf(elementos, capacity);
        }

        private void reorganizeQueue() {
            if (first > 0) {
                System.out.println("Reorganizando la cola para reutilizar espacio...");
                int newSize = last - first;
                for (int i = 0; i < newSize; i++) {
                    elementos[i] = elementos[first + i];
                }
                last = newSize;
                first = 0;
            } else {
                resize();
            }
        }


}
