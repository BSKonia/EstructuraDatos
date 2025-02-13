package Exam;

public class Node {

    //Si estos atributos fueran private todos los metodos de SparseArray tendrían que usar getters y setters
    // al no poner nada es accesibilidad a nivel de paquete, todas las clases del paquete pueden acceder
    Integer row;
    Integer column;
    Integer value;
    Node next;
    Node prev;

    public Node(Integer row, Integer column, Integer value){
        this.row = row;
        this.column = column;
        this.value = value;
        next = null;
        prev = null;
    }

    @Override
    public String toString() {
        return "[row=" + row + ", column=" + column + ", value=" + value + ']';
    }
}
