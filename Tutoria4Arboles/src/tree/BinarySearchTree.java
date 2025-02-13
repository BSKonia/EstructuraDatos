package tree;

import java.util.ArrayList;

public class BinarySearchTree {
    private Node root;

    // CONSTRUCTOR DE ÁRBOL VACÍO
    public  BinarySearchTree() {

        root = null;
    }

    // INSERCIÓN DE UN NUEVO VALOR
    public void insert(Integer v) {

        // Se podría comprobar el valor de v, y si es null, no invocar al método recursivo de inserción

        root = recursiveInsert(root, v);
    }

    // MÉTODO RECURSIVO DE APOYO
    // LA DEFINICIÓN DEL PROPIO MÉTODO GARANTIZA QUE NO HAYA DUPLICADOS EN EL ABB
    private Node recursiveInsert(Node node, int v) {

        if (node == null)
            node = new Node(v);

        else if (v < node.value)
            node.left = recursiveInsert(node.left, v);
        else if (v > node.value)
            node.right = recursiveInsert(node.right, v);

        return node;

    }


    // RECORRIDO EN INORDEN
    public ArrayList<Integer> inorder() {

        ArrayList<Integer> list = new ArrayList<>();

        recursiveInorder(root, list);

        return list;
    }

    private void recursiveInorder(Node node, ArrayList<Integer> list) {

        if (node != null) {
            recursiveInorder(node.left, list);
            list.add(node.value);
            recursiveInorder(node.right, list);
        }
    }

    //ALTURA DE UN ÁRBOL
    public int height(){
        return recursiveHeight(root);
    }

    private int recursiveHeight(Node node) {
        if (node == null)
            return -1;

        int rightHeight = recursiveHeight(node.right);
        int leftHeight = recursiveHeight(node.left);

        return 1 + Math.max(rightHeight, leftHeight);
    }

    //SUMA DE LOS NODOS DEL ÁRBOL
    public Integer sum() {
        return recursiveSum(root);
    }

    private Integer recursiveSum(Node node){
        if (node == null)
            return 0; // si fuera el producto de los nodos en lugar de la suma devolverá 1
        return node.value + recursiveSum(node.left) + recursiveSum(node.right);
    }

    //CONTAR NODOS QUE PERTENEZCAN A UN RANGO

    public Integer countInRange(Integer min, Integer max){
        return recursiveCountinRange (root, min, max);
    }

    private Integer recursiveCountinRange(Node node, Integer min, Integer max){ // El parámetro node (de tipo Node) es el que indica donde iniciar la llamada recursiva

        Integer count = 0;

        if (node == null)
            return 0; // si el nodo es nulo se acaba la recursividad

        if ((node.value >= min) && (node.value <= max))
                count =1;

        return count + recursiveCountinRange(node.left, min, max) + recursiveCountinRange(node.right, min, max);
    }

    //contar número de nodos

    public Integer numNodes(){
        return recursiveNumNodes(root);
    }

    private Integer recursiveNumNodes(Node node){
        if (node == null)
            return 0;

        return 1 + recursiveNumNodes(node.left) + recursiveNumNodes(node.right);
    }

    //valor medio de los nodos

    public double avg(){
        if (root == null)
            return 0;

        Integer sum = sum();
        Integer numNodes = numNodes();

        return (double) sum/numNodes; //casteo en sum para convertir la división en double
    }







}
