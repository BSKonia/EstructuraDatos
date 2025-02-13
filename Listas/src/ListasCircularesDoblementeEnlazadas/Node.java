package ListasCircularesDoblementeEnlazadas;

public class Node {
    Integer data;
    Node next;
    Node prev;

    public Node(Integer data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
