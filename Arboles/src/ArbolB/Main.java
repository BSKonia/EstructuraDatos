package ArbolB;

public class Main {
    public static void main(String[] args) {
        BTree tree = new BTree();
        int[] values = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int val : values)
            tree.insert(val);

        System.out.println("Árbol B de orden 3:");
        tree.display();
    }
}
