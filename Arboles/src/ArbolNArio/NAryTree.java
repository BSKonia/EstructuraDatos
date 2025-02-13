package ArbolNArio;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 🌲 2️⃣ Implementación de un Árbol N-ario
 * 📌 Estructura: Un nodo tiene una lista de hijos.
 */
public class NAryTree {
    NAryNode root;

    public NAryTree(String rootValue) {
        root = new NAryNode(rootValue);
    }

    public void addChild(NAryNode parent, String value) {
        parent.children.add(new NAryNode(value));
    }

    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<NAryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NAryNode node = queue.poll();
            System.out.print(node.value + " ");
            queue.addAll(node.children);
        }
        System.out.println();
    }

}
