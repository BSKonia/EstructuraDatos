package Ejercicio1y2;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Juanito", "Sánchez", 32, 7.6);

        System.out.println(student.getAverageGrade());

        student.passed();
        student.aprobado();

    }
}
