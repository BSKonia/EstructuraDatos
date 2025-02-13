package Calculator;

public class Main {
    public static void main(String[] args) {
        double m1, m2;
        Complex c1 = new Complex(4,3);
        Complex c2 = new Complex();
        Complex c3 = new Complex();

        for (int i=0; i<5; i++){
            c3 = new Complex(i, i);
            System.out.println(c3);
        }

        m1 = c1.modulus();
        m2 = c2.modulus();

        System.out.println("Módulo de c1 " + m1);
        System.out.println("Módulo de c2 " + m2);

        System.out.println(c1);
        System.out.println(c2);
    }

}
