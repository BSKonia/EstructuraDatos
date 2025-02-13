package modeloC_2024;

public class Node {

    public int index;

    public int value;

    Node next;

    Node prev;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
