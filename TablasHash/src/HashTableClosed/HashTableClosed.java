package HashTableClosed;

/**
 * Tabla Hash con Dirección Abierta (Hashing Cerrado)
 * 📌 Descripción
 * Implementa una tabla hash con dirección abierta usando sondeo lineal.
 *
 * 🔹 Si hay colisión, intenta la siguiente posición disponible.
 * 🔹 Implementa insertar(), buscar(), y eliminar().
 */
public class HashTableClosed {
    private Integer[] table;
    private int size;

    public HashTableClosed(int size) {
        this.size = size;
        table = new Integer[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        while (table[index] != null) {
            index = (index + 1) % size; // Sondeo lineal
        }
        table[index] = key;
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        int startIndex = index;
        while (table[index] != null) {
            if (table[index] == key)
                return true;
            index = (index + 1) % size;
            if (index == startIndex) break;
        }
        return false;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int startIndex = index;
        while (table[index] != null) {
            if (table[index] == key) {
                table[index] = null;
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++)
            System.out.println(i + ": " + table[i]);
    }

}
