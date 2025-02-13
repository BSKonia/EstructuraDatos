package Ejercicio2;

public class Main {
    public static void main(String[] args) {


        TestParameters tester = new TestParameters();


        int[][] b = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        System.out.println("b antes de llamada a método");
        // 1  2  3 / 4  5  6 / 7  8  9
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[i].length; j++)
                System.out.print(b[i][j] + "\t");
            System.out.print("\n");
        }

        tester.testArray2D(b);
        System.out.println("b después de llamada a método");
        // 100  100  100  /100  100  100  /100  100  100
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[i].length; j++)
                System.out.print(b[i][j] + "\t");
            System.out.print("\n");
        }
    }

}

