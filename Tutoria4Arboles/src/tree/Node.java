package tree;

public class Node {
    Integer value;	// Valor del nodo
    Node left;		// Referencia al hijo izquierdo
    Node right;		// Referencia al hijo derecho

    public Node(Integer value) {
        this.value = value;
        left = null;
        right = null;
    }

}


