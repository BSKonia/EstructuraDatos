package BST;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values)
            tree.insert(val);

        System.out.print("Recorrido Inorden: ");
        tree.inOrder();

        System.out.println("¿Está el 40 en el árbol? " + tree.search(40));
    }
}
