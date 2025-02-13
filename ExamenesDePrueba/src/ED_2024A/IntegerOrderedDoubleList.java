package ED_2024A;

public class IntegerOrderedDoubleList {

    private Node first;
    private Node last;

    public IntegerOrderedDoubleList() {
        this.first = null;
        this.last = null;
    }

    public void insert(Integer i) {
        Node NewNode = new Node(i);
        if (first == null) {
            NewNode = first;
        }
        while (first != null) {
            if (NewNode.data >= first.data) {
                NewNode=first.next;
            }
            else NewNode = first;

        }
    }

    @Override
    public String toString() {
        if (first == null) {
            return "Empty stack";
        }
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}

