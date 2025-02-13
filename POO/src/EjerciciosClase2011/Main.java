package EjerciciosClase2011;

public class Main {
    public static void main(String[] args) {

        Subclass1 s1 = new Subclass1();
        Subclass2 s2 = new Subclass2();
        Subclass3 s3 = new Subclass3();

        s1.print();
        s2.print();
        s3.print(); // como aquí no hemos sobreescrito el método print invoca al de la clase padre

    }
}
