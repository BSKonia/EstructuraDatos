package heapminimo;
import java.util.Arrays;
public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return (2 * i) + 1; }
    private int rightChild(int i) { return (2 * i) + 2; }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap está lleno");
        }
        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap vacío");
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        int[] values = {12, 5, 20, 8, 15, 2, 25};
        for (int val : values) {
            minHeap.insert(val);
        }
        minHeap.printHeap();
        System.out.println("Elemento mínimo eliminado: " + minHeap.extractMin());
        minHeap.printHeap();
    }
}

