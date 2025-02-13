package maximos;

/**
 * Ejercicio 1: Implementar una Cola de Prioridad de Máximos (Max Heap)
 * Descripción:
 * Implementa una cola de prioridad de máximos usando un heap. En este tipo de cola, el elemento con el valor máximo tiene la mayor prioridad y debe ser extraído primero.
 *
 * Pasos:
 *
 * Implementar las operaciones básicas de un heap: insert(), extractMax(), peek().
 * Implementar una función para construir el heap a partir de un arreglo (heapify).
 */
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
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

    // Función para hacer "heapify" hacia arriba (mientras el elemento sea mayor que su padre)
    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    // Función para hacer "heapify" hacia abajo (mientras los hijos sean mayores que el elemento)
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
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

    // Extraer el valor máximo (raíz)
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // Obtener el valor máximo sin eliminarlo
    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
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
