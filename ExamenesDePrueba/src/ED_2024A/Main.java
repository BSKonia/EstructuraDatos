package ED_2024A;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        IntegerOrderedDoubleList numeros = new IntegerOrderedDoubleList();
        numeros.insert(2);
        numeros.insert(4);
        numeros.insert(7);
        numeros.insert(1);

        System.out.println(numeros.toString());
    }
}
