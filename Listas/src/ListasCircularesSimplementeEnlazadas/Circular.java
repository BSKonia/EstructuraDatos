package ListasCircularesSimplementeEnlazadas;

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
            bottom.next = top;
            size++;
            return;
        }
        bottom.next = nuevo;
        bottom = nuevo;
        bottom.next = top;
        size++;
    }

    public boolean remove(Integer data) {
        if (top == null) {
            return false;
        }

        Node cursor = top;
        Node anterior = bottom;

        do {
            if (cursor.data.equals(data)) {
                if (cursor == top) {
                    if (top == bottom) {
                        top = null;
                        bottom = null;
                    } else {
                        top = top.next;
                        bottom.next = top;
                    }
                } else {
                    anterior.next = cursor.next;
                    if (cursor == bottom) {
                        bottom = anterior;
                    }
                }
                size--;
                return true;
            }
            anterior = cursor;
            cursor = cursor.next;
        } while (cursor != top);

        return false;
    }

    public boolean search(Integer data) {
        if (top == null) {
            return false;
        }

        Node cursor = top;

        do {
            if (cursor.data.equals(data)) {
                return true;
            }
            cursor = cursor.next;
        } while (cursor != top);

        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (top == null) {
            return "[]";
        }

        StringBuilder str = new StringBuilder();
        Node cursor = top;

        do {
            str.append(cursor.data);
            cursor = cursor.next;
            if (cursor != top) {
                str.append(" ");
            }
        } while (cursor != top);

        return str.toString();
    }

}
