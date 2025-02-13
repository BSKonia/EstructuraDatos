package bst;

import java.util.ArrayList;

public class BynarySearchTree {

    private Node root; // nodo raíz. Sería equivalente al first de las listas

    public BynarySearchTree() { // creamos constructor árbol vacío
        this.root = null;
    }

    // INSERCIÓN DE ELEMENTOS AL ÁRBOL
    public void insert(Integer i){ // creamos método insert
        root= recursiveInsert (root, i);
    }

    /**
     * tenemos que usar recursividad porque no tenemos un nodo a partir del cual insertar3
     *
     */
    private Node recursiveInsert(Node node, Integer i) { //creamos método auxiliar para la inserción, el cual debe recibir 2 argumentos

        if (node == null) {
            node = new Node(i); // si el nodo es nulo directamente que le inserte el valor de i
            return node;
        }

        if (i < node.data) {
            node.left = recursiveInsert(node.left, i);
        } else if (i > node.data) {
            node.right = recursiveInsert(node.right, i);
        } else {
            return node;
        }
        return node;
    }

    // ELIMINACION DE ELEMENTOS DEL ÁRBOL
    public void delete(Integer i){
        root= recursiveDelete (root, i);
    }
    /**
     * método para eliminar un nodo con valor i
     * llamamos al método auxiliar recurivedelete pasándole la raíz del árbol (root) y el valor i a eliminar
     * El resultado del método recursivo recursiveDelete se asigna de nuevo a root para actualizar el árbol tras la operación de eliminación.
     *
     * EL MÉTODO INSERT ES LO MISMO PERO AÑADIENDO UN ELEMENTO
     */

    private Node recursiveDelete(Node node, int i) {
        //Caso 1: Árbol vacío o nodo no encontrado
        if (node == null) { // si el árbol está vacío devuelve nulo, no hay nada que eliminar
            return null; // Si node es null, significa que el árbol está vacío o que hemos llegado a una hoja sin encontrar el valor que se desea eliminar. Por tanto, no hay nada más que hacer y simplemente se devuelve null.
        }

        //Caso 2: Navegación por el árbol
        if (i < node.data) { // Si el valor i es menor que el valor almacenado en el nodo actual (node.data), se busca en el subárbol izquierdo. Si el valor i es mayor, se busca en el subárbol derecho.
            node.left = recursiveDelete(node.left, i); //buscamos en el subárbol izquierdo
        } else if (i > node.data) {
            node.right = recursiveDelete(node.right, i); // buscamos en el subárbol derecho
            // Caso 3: Nodo encontrado
        } else { // si encontramos el nodo. Si llegamos al caso en el que i == node.data, hemos encontrado el nodo que queremos eliminar. A continuación, se evalúan los casos según los hijos del nodo.
            //Subcaso 3.1: Nodo sin hijos
            if (node.left == null && node.right == null) {
                return null; // si el nodo encontrado que queremos eliminar no tiene hijos, lo elimina directamente. Si el nodo no tiene hijos, simplemente se elimina devolviendo null.
                //Subcaso 3.2: Nodo con un solo hijo
            } else if (node.left == null) { //Si el nodo tiene un único hijo:Si no tiene hijo izquierdo (node.left == null), se devuelve el subárbol derecho.Si no tiene hijo derecho (node.right == null), se devuelve el subárbol izquierdo.Esto efectivamente elimina el nodo actual y conecta su hijo directamente con su padre.
                return node.right;
            } else if (node.right == null) { // si el nodo sólo tiene hijo izquierdo...
                return node.left;
                //Subcaso 3.3: Nodo con dos hijos
                // Se encuentra el sucesor inorden (el nodo con el menor valor en el subárbol derecho). Esto se realiza con la función findMin.
                //Se reemplaza el valor del nodo actual (node.data) con el valor del sucesor.
                //Finalmente, se elimina el sucesor inorden del subárbol derecho llamando a recursiveDelete recursivamente.
            } else { // si el nodo tiene 2 hijos hay que buscar sucesor inorden (el menor del suárbol derecho)
                Node minNode = findMin(node.right);
                node.data = minNode.data; // reemplazamos valor del nodo por el valor del sucesor
                node.right = recursiveDelete(node.right, minNode.data); // eliminar al sucesor
            }

        }
        return node; //Devuelve el nodo actual (posiblemente modificado) después de cualquier operación de eliminación.
    }
    /**
     * Resumen del flujo general
     * Busca el nodo a eliminar navegando por el árbol.
     * Si el nodo no tiene hijos, lo elimina directamente.
     * Si el nodo tiene un único hijo, lo reemplaza con su único subárbol.
     * Si el nodo tiene dos hijos, encuentra el sucesor inorden, lo reemplaza, y elimina el sucesor del subárbol derecho.
     */

    // BÚSQUEDA DEL NODO CON EL VALOR MÁS PEQUEÑO
    private Node findMin(Node node) {    // Encuentra el nodo con el valor más pequeño (más a la izquierda)
        while (node.left != null) {
            node = node.left;   // mientras que el nodo de la parte izquierda tenga datos, adjudicamos al nodo creado su valor
        }
        return node;
    }
    // RECORRIDO INORDEN
    public ArrayList<Integer> inorder(){ // primero visita subárbol izdo, luego root y luego subárbol izdo
        ArrayList<Integer> listinorder = new ArrayList<>(); //creo ArrayList de tipo Integer llamado listinorder
        inorderRecursive(root, listinorder);
        return listinorder;
    }

    private void inorderRecursive(Node node, ArrayList<Integer> listinorder) { 
        if (node != null) {
            inorderRecursive(node.left, listinorder);      // Recorrer el subárbol izquierdo
            listinorder.add(node.data);                    // Visitar el nodo actual
            inorderRecursive(node.right, listinorder);  // Recorrer el subárbol derecho
        }
    }

    // RECORRIDO PREORDEN
    public ArrayList<Integer> preorder() { // primero visita root, luego subárbol izdo y luego subárbol dcho
        ArrayList<Integer> listpreorder = new ArrayList<>(); // creo Arraylist llamado listpreorder
        preorderRecursive(root, listpreorder);
        return listpreorder;
    }

    private void preorderRecursive(Node node, ArrayList<Integer> listpreorder) {
        if (node != null) {
            listpreorder.add(node.data);                    // Visitar el nodo actual
            preorderRecursive(node.left, listpreorder);      // Recorrer el subárbol izquierdo
            preorderRecursive(node.right, listpreorder);  // Recorrer el subárbol derecho
        }
    }

    //RECORRIDO POSTORDEN
    public ArrayList<Integer> postorder() { // primero visita subárbol izdo, luego subárbol dcho y por último root
        ArrayList<Integer> listpostorder = new ArrayList<>(); // creo Arraylist llamado listpostorder
        postorderRecursive(root, listpostorder);
        return listpostorder;
    }

    private void postorderRecursive(Node node, ArrayList<Integer> listpostorder) {
        if (node != null) {
            postorderRecursive(node.left, listpostorder);      // Recorrer el subárbol izquierdo
            postorderRecursive(node.right, listpostorder);  // Recorrer el subárbol derecho
            listpostorder.add(node.data);                    // Visitar el nodo actual
        }
    }




}
