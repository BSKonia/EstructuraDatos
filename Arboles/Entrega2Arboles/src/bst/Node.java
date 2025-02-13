package bst;

public class Node {

    /**
     * Si pusiese estos atributos como privados me tocaría crear getters y setters,
     * y utilizarlos cada vez que llamase a la clase Node desde otra clase del paquete
     */

    Integer data;
    Node left; // hijo izquierdo del nodo
    Node right; // hijo derecho del nodo

    public Node(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
