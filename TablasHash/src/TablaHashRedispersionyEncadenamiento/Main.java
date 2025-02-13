package TablaHashRedispersionyEncadenamiento;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTableWithResize hashTable = new HashTableWithResize(5);
        hashTable.insert(10);
        hashTable.insert(15);
        hashTable.insert(20);
        hashTable.insert(25);
        hashTable.insert(30);  // Esto causará un rehash

        System.out.println("Tabla Hash con Redispersión:");
        hashTable.printTable();

        System.out.println("Buscar 15: " + hashTable.search(15));
        hashTable.delete(15);
        System.out.println("Buscar 15 después de eliminar: " + hashTable.search(15));

        System.out.println("Estado final de la tabla:");
        hashTable.printTable();
    }
}
