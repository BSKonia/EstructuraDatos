package examen_clase_3101;
import java.util.ArrayList;
import java.util.Arrays;
public class IntegerStackOrQueueDeepSeek {

        private Integer[] elements;
        private int size;
        private int mode; // 0 para pila, 1 para cola

        public IntegerStackOrQueueDeepSeek() {
            elements = new Integer[10];
            size = 0;
            mode = 0;
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
            if (size == elements.length) {
                resize();
            }
            elements[size++] = i;
        }

        public Integer get() {
            if (size == 0) {
                return null;
            }
            if (mode == 0) {
                return elements[--size];
            } else {
                Integer removedElement = elements[0];
                for (int i = 1; i < size; i++) {
                    elements[i - 1] = elements[i];
                }
                size--;
                elements[size] = null; // Ayuda a la recolección de basura
                return removedElement;
            }
        }

        public ArrayList<Integer> list() {
            ArrayList<Integer> result = new ArrayList<>();
            if (mode == 0) {
                for (int i = size - 1; i >= 0; i--) {
                    result.add(elements[i]);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    result.add(elements[i]);
                }
            }
            return result;
        }

        private void resize() {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }

}
