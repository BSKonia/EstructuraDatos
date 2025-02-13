package modeloC_2024;

public class Main {
    public static void main(String[] args) {

        SparseVector vector = new SparseVector(5);

        vector.setValue(1, 5);
        vector.setValue(2, 6);
        vector.setValue(3, 7);
        vector.setValue(4, 8);
        vector.setValue(5, 9);

        System.out.println(vector.noZeros());
        System.out.println(vector.getValue(3));
        System.out.println(vector.toString());


    }

}
