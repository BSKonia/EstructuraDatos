package Ejercicio1y2;

public class Student {
    //atributos
    private String name;
    private String surname;
    private int age;
    private double averageGrade;

    //constructor
    public Student(String name, String surname, int age, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    //getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    //método aprobado mío (igual variable boolean no sirve para nada
    public void aprobado(){
        boolean b = false;
        if (averageGrade>=5){
            b = true;
            System.out.println("Aprobaste");
        }else {
            b = false;
            System.out.println("Suspendiste");
        }

    }
    public boolean passed() {
        return this.averageGrade >= 5;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
