package HashTableClosed;

public class Main {
    public static void main(String[] args) {
        HashTableClosed hashTable = new HashTableClosed(5);
        hashTable.insert(10);
        hashTable.insert(15);
        hashTable.insert(20);

        System.out.println("Tabla Hash con Dirección Abierta:");
        hashTable.printTable();

        System.out.println("Buscar 15: " + hashTable.search(15));
        hashTable.delete(15);
        System.out.println("Buscar 15 después de eliminar: " + hashTable.search(15));
    }
}
