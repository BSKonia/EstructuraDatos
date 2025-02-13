package colaestudiantesconlinkedlist;

import java.util.LinkedList;

public class StudentQueue {
    public static void main(String[] args) {
        LinkedList<Student> queue = new LinkedList<>();
        Student s1 = new Student("Alba", "Coloma");
        Student s2 = new Student("Alberto", "Fontán");
        Student s3 = new Student("Alfonso", "Ruíz");

        System.out.println(queue);   // la cola está vacía

        queue.add(s1);
        System.out.println(queue);   // la cola tiene 1 estudiante
        queue.add(s2);
        System.out.println(queue);   // la cola tiene 2 estudiantes
        queue.add(s3);
        System.out.println(queue);   // la cola tiene 3 estudiantes


        queue.remove();
        System.out.println(queue);   // la cola tiene 2 estudiantes

        queue.remove();
        System.out.println(queue);   // la cola tiene 1 estudiante

        queue.remove();
        System.out.println(queue);   // la cola está vacía
    }
}
