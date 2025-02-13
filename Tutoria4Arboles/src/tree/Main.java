package tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        //PRUEBAS DE HEIGHT
//        System.out.println(bst.height());
//
//        bst.insert(1);
//        System.out.println(bst.height());
//
//        for (int i=1; i < 10; i++){
//            bst.insert(i);
//        }
//
//        System.out.println(bst.inorder());
//        System.out.println(bst.height());


        //PRUEBAS DE SUM
        System.out.println(bst.sum());

        bst.insert(8);
        System.out.println(bst.sum());

        for (int i=1; i<6; i++)
            bst.insert(i);
        System.out.println(bst.sum());


        System.out.println(bst.countInRange(4,9));

        for (int i=1; i<11; i++)
            bst.insert(i);

        System.out.println(bst.inorder());
        System.out.println(bst.countInRange(4,9));
    }
}
