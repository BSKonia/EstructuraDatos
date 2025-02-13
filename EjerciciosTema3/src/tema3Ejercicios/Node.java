package tema3Ejercicios;

public class Node {
    String data;
    Node next;
    Node(String str) {
        data = str;
        next = null;
    }
    public String toString() {
        return data;
    }
}
