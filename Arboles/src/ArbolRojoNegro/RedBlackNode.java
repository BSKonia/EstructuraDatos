package ArbolRojoNegro;

public class RedBlackNode {
    int data;
    RedBlackNode left, right, parent;
    boolean isRed; // true = rojo, false = negro

    public RedBlackNode(int data) {
        this.data = data;
        this.isRed = true; // Todo nuevo nodo es rojo por defecto
        this.left = this.right = this.parent = null;
    }
}
