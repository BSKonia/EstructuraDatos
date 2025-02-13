package bst;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BynarySearchTree bt = new BynarySearchTree(); // creamos árbol binario llamado bt
        bt.insert(6); //insertamos datos
        bt.insert(4);
        bt.insert(8);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
        bt.insert(9);
        bt.insert(14);
        bt.insert(17);
        bt.insert(11);

        System.out.println("Lista completa. Se muestra el inorden, preorden y postorden");
        ArrayList<Integer> inorder= bt.inorder(); // creamos arraylist inorder para poder mostrar el contenido de bt.inorder como un array
        System.out.println(inorder);

        ArrayList<Integer> preorder= bt.preorder();
        System.out.println(preorder);

        ArrayList<Integer> postorder= bt.postorder();
        System.out.println(postorder);

        System.out.println("\nAhora mostraremos el inorden, preorden y postorden eliminando el nodo 7:");
        // eliminando el nodo 7:
        bt.delete(7);
        ArrayList<Integer> inorder2= bt.inorder();
        System.out.println(inorder2);

        ArrayList<Integer> preorder2= bt.preorder();
        System.out.println(preorder2);

        ArrayList<Integer> postorder2= bt.postorder();
        System.out.println(postorder2);

        System.out.println("\nAhora mostraremos el inorden, preorden y postorden añadiendo el nodo 18:" );
        //añadiendo el nodo 18
        bt.insert(18);
        ArrayList<Integer> inorder3= bt.inorder();
        System.out.println(inorder3);

        ArrayList<Integer> preorder3= bt.preorder();
        System.out.println(preorder3);

        ArrayList<Integer> postorder3= bt.postorder();
        System.out.println(postorder3);



    }
}
