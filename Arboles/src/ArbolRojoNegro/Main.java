package ArbolRojoNegro;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] values = {10, 18, 7, 15, 16, 30, 25, 40, 60, 2, 1, 70};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("Recorrido Inorden (con colores):");
        tree.inOrderTraversal();

        System.out.println("Eliminando 15...");
        tree.delete(15);
    }
}
