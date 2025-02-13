package ListasCircularesDoblementeEnlazadas;

public class Circular {
    Node top;
    Node bottom;
    int size;
    public Circular() {
        top = null;
        bottom = null;
        size = 0;
    }

    public void insert(Integer data) {
        Node nuevo = new Node(data);
        if (top == null) {
            top = nuevo;
            bottom = nuevo;
            return;
        }
        nuevo.next = top;
        top.prev = nuevo;
        top = nuevo;
        size++;
    }

    public boolean remove(Integer data) {
        if (top == null) return false;

        Node current = top;
        do {
            if (current.data.equals(data)) {
                if (size == 1) {
                    top = null;
                    bottom = null;
                } else {
                    Node prevNode = current.prev;
                    Node nextNode = current.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;

                    if (current == top) {
                        top = nextNode;
                    }
                    if (current == bottom) {
                        bottom = prevNode;
                    }
                }
                size--;
                return true;
            }
            current = current.next;
        } while (current != top);

        return false;
    }

    public boolean search(Integer data) {
        if (top == null) return false;
        Node current = top;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != top);
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (top == null) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = top;
        do {
            sb.append(current.data);
            current = current.next;
            if (current != top) {
                sb.append(", ");
            }
        } while (current != top);
        sb.append("]");
        return sb.toString();
    }
}
