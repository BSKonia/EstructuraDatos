package heapminimo;
//Dado el heap [3, 8, 10, 15, 20, 12], insertar 5.
import java.util.PriorityQueue;

public class InsertMinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] initialValues = {3, 8, 10, 15, 20, 12};
        for (int val : initialValues) {
            minHeap.add(val);
        }

        System.out.println("Heap antes de insertar: " + minHeap);

        minHeap.add(5);

        System.out.println("Heap después de insertar 5: " + minHeap);
    }
}

