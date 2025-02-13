package ArbolBinarioLinkedlist;

public class Main {
    public static void main(String[] args) {
        Arbol bst = new Arbol();

        // Pruebas de inserción
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        System.out.println("Recorrido inorden:");
        System.out.println(bst.inorder());

        System.out.println("\nRecorrido preorden:");
        System.out.println(bst.preorder());

        System.out.println("\nRecorrido postorden:");
        System.out.println(bst.postorder());

        // Prueba de borrado
        System.out.println("\nBorrando el elemento 30:");
        bst.delete(30);
        System.out.println("Recorrido inorden después del borrado:");
        System.out.println(bst.inorder());
    }
}
