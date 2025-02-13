package lists;

public class Student {
    private String firstName;	// Nombre
    private String lastName;	// Apellido
    private int age;			// Edad
    private double grade;     	// Nota


    public Student(String firstName, String lastName, int age, double grade) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", grade=" + grade + "]";
    }

}


