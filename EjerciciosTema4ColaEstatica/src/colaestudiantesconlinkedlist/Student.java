package colaestudiantesconlinkedlist;

public class Student {
    private String firtsName;
    private String lastName;

    public Student(String firtsName, String lastName) {
        super();
        this.firtsName = firtsName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[firtsName=" + firtsName + ", lastName=" + lastName + "]";
    }
}
