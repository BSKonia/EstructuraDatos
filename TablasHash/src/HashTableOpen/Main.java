package HashTableOpen;

public class Main {
    public static void main(String[] args) {
        HashTableOpenArray hashTable = new HashTableOpenArray(5);
        hashTable.insert(10);
        hashTable.insert(15);
        hashTable.insert(20);
        hashTable.insert(25);

        System.out.println("Tabla Hash con Encadenamiento usando Arrays:");
        hashTable.printTable();

        System.out.println("Buscar 15: " + hashTable.search(15));
        hashTable.delete(15);
        System.out.println("Buscar 15 después de eliminar: " + hashTable.search(15));

        System.out.println("Estado final de la tabla:");
        hashTable.printTable();
    }
}
