package maximos;

public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(30);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        System.out.println("Valor máximo (extraído): " + maxHeap.extractMax());
        System.out.println("Heap después de extraer el máximo:");
        maxHeap.printHeap();
    }

}
