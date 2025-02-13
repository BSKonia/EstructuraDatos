package Ejercicio2;

public class TestParameters {

    int[][] a = new int[100][100];

    public void testArray2D(int[][] a) {

        for (int i=0; i<a.length; i++)
            for (int j=0; j<a[i].length; j++)
                a[i][j] = 100;

    }

}
