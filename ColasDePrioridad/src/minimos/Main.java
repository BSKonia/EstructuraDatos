package minimos;

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);

        System.out.println("Min Heap:");
        minHeap.printHeap();

        System.out.println("Valor mínimo (extraído): " + minHeap.extractMin());
        System.out.println("Heap después de extraer el mínimo:");
        minHeap.printHeap();
    }
}
