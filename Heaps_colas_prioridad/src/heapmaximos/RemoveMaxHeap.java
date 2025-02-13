package heapmaximos;
//Dado el heap [50, 40, 30, 5, 10, 20], eliminar el máximo.
import java.util.PriorityQueue;
import java.util.Collections;

public class RemoveMaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] initialValues = {50, 40, 30, 5, 10, 20};
        for (int val : initialValues) {
            maxHeap.add(val);
        }

        System.out.println("Heap antes de eliminar: " + maxHeap);

        int removed = maxHeap.poll();

        System.out.println("Elemento eliminado: " + removed);
        System.out.println("Heap después de eliminar: " + maxHeap);
    }
}
