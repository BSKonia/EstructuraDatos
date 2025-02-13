package ListasCircularesDoblementeEnlazadas;

import ListasCircularesSimplementeEnlazadas.Circular;

public class Main {
    public static void main(String[] args) {

        ListasCircularesSimplementeEnlazadas.Circular circular = new Circular();
        circular.insert(1);
        circular.insert(2);
        circular.insert(3);
        circular.insert(4);
        circular.insert(5);

        System.out.println(circular.toString());

        circular.remove(3);

        System.out.println(circular.toString());

        circular.remove(1);






    }
}
