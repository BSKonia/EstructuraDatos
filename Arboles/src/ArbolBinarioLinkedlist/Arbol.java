package ArbolBinarioLinkedlist;

import java.util.LinkedList;

public class Arbol {
    private LinkedList<Integer> tree;

    public Arbol() {
        tree = new LinkedList<>();
    }

    public void insert(Integer i) {
        if (!tree.contains(i)) {  // Evitar duplicados
            if (tree.isEmpty()) {
                tree.add(i);
            } else {
                int pos = 0;
                while (pos < tree.size() && tree.get(pos) < i) {
                    pos++;
                }
                tree.add(pos, i);
            }
        }
    }

    public void delete(Integer i) {
        tree.remove(i);
    }

    public LinkedList<Integer> inorder() {
        // En una LinkedList ordenada, el recorrido inorden es la lista tal cual
        return new LinkedList<>(tree);
    }

    public LinkedList<Integer> preorder() {
        LinkedList<Integer> result = new LinkedList<>();
        if (!tree.isEmpty()) {
            // En un BST, el preorden comenzará con la raíz (primer elemento)
            int root = tree.getFirst();
            result.add(root);

            // Añadir elementos menores que la raíz
            LinkedList<Integer> leftSubtree = new LinkedList<>();
            LinkedList<Integer> rightSubtree = new LinkedList<>();

            for (Integer value : tree) {
                if (value < root) leftSubtree.add(value);
                else if (value > root) rightSubtree.add(value);
            }

            result.addAll(leftSubtree);
            result.addAll(rightSubtree);
        }
        return result;
    }

    public LinkedList<Integer> postorder() {
        LinkedList<Integer> result = new LinkedList<>();
        if (!tree.isEmpty()) {
            // En un BST, el postorden terminará con la raíz
            int root = tree.getFirst();

            // Añadir elementos menores que la raíz
            LinkedList<Integer> leftSubtree = new LinkedList<>();
            LinkedList<Integer> rightSubtree = new LinkedList<>();

            for (Integer value : tree) {
                if (value < root) leftSubtree.add(value);
                else if (value > root) rightSubtree.add(value);
            }

            result.addAll(leftSubtree);
            result.addAll(rightSubtree);
            result.add(root);
        }
        return result;
    }
}
