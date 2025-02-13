package ArbolB;

import java.util.Collections;

/**
 * 📚 3️⃣ Implementación de un Árbol B de Orden 3
 * 📌 Características:
 *
 * Cada nodo puede tener 2 o 3 claves.
 * Inserción ordenada y división de nodos.
 */

class BTree {
    private BTreeNode root;
    private final int T = 2; // Orden 3 (T define el mínimo grado)

    public BTree() {
        root = new BTreeNode(true); // Inicializa la raíz como hoja
    }

    public void insert(int key) {
        BTreeNode r = root;
        if (r.keys.size() == (2 * T - 1)) { // Si la raíz está llena
            BTreeNode newRoot = new BTreeNode(false);
            newRoot.children.add(r);
            splitChild(newRoot, 0);
            root = newRoot;
            insertNonFull(root, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(BTreeNode node, int key) {
        int i = node.keys.size() - 1;
        if (node.isLeaf) { // Caso base: insertar en una hoja
            node.keys.add(key);
            Collections.sort(node.keys);
        } else {
            while (i >= 0 && key < node.keys.get(i)) i--;
            i++;
            if (node.children.get(i).keys.size() == (2 * T - 1)) { // Si el hijo está lleno
                splitChild(node, i);
                if (key > node.keys.get(i)) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    private void splitChild(BTreeNode parent, int index) {
        BTreeNode y = parent.children.get(index);
        BTreeNode z = new BTreeNode(y.isLeaf);
        parent.keys.add(index, y.keys.get(T - 1)); // Sube la clave media
        parent.children.add(index + 1, z);

        z.keys.addAll(y.keys.subList(T, y.keys.size())); // Copia las claves mayores a z
        y.keys.subList(T - 1, y.keys.size()).clear(); // Borra las claves movidas en y

        if (!y.isLeaf) {
            z.children.addAll(y.children.subList(T, y.children.size()));
            y.children.subList(T, y.children.size()).clear();
        }
    }

    public void printTree(BTreeNode node, int level) {
        System.out.print("Nivel " + level + ": ");
        System.out.println(node.keys);
        for (BTreeNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    public void display() {
        if (root != null) printTree(root, 0);
    }
}
