package heapminimo;
//Dado el heap [2, 8, 10, 15, 20, 12], eliminar el mínimo.
import java.util.PriorityQueue;

public class RemoveMinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] initialValues = {2, 8, 10, 15, 20, 12};
        for (int val : initialValues) {
            minHeap.add(val);
        }

        System.out.println("Heap antes de eliminar: " + minHeap);

        int removed = minHeap.poll();  // poll() elimina el mínimo

        System.out.println("Elemento eliminado: " + removed);
        System.out.println("Heap después de eliminar: " + minHeap);
    }
}
