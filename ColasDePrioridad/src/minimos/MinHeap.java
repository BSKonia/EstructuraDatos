package minimos;

/**
 * Implementa una cola de prioridad de mínimos usando un min heap. En este tipo de cola, el elemento con el valor mínimo tiene la mayor prioridad y debe ser extraído primero.
 *
 * Pasos:
 *
 * Implementar las operaciones básicas de un heap: insert(), extractMin(), peek().
 * Implementar una función para construir el heap a partir de un arreglo (heapify).
 */

public class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }

        // Función para obtener el índice del padre
        private int parent(int index) {
            return (index - 1) / 2;
        }

        // Función para obtener el índice del hijo izquierdo
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        // Función para obtener el índice del hijo derecho
        private int rightChild(int index) {
            return 2 * index + 1;
        }

        // Función para intercambiar dos elementos
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Función para hacer "heapify" hacia arriba (mientras el elemento sea menor que su padre)
        private void heapifyUp(int index) {
            while (index > 0 && heap[parent(index)] > heap[index]) {
                swap(parent(index), index);
                index = parent(index);
            }
        }

        // Función para hacer "heapify" hacia abajo (mientras los hijos sean menores que el elemento)
        private void heapifyDown(int index) {
            int left = leftChild(index);
            int right = rightChild(index);
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }

        // Insertar un nuevo elemento en el heap
        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full");
                return;
            }

            heap[size] = value;
            size++;
            heapifyUp(size - 1);
        }

        // Extraer el valor mínimo (raíz)
        public int extractMin() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return Integer.MAX_VALUE;
            }

            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return min;
        }

        // Obtener el valor mínimo sin eliminarlo
        public int peek() {
            if (size == 0) {
                System.out.println("Heap is empty");
                return Integer.MAX_VALUE;
            }
            return heap[0];
        }

        // Imprimir el contenido del heap
        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

}
