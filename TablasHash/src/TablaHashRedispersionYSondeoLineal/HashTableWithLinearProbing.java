package TablaHashRedispersionYSondeoLineal;

/**
 *  implementaremos rehashing junto con sondeo lineal para manejar las colisiones.
 *  Si un índice está ocupado, se buscará el siguiente índice libre de forma secuencial (usando sondeo lineal).
 *
 */
public class HashTableWithLinearProbing {
    private Integer[] table;
    private int size;
    private int count;

    public HashTableWithLinearProbing(int initialSize) {
        this.size = initialSize;
        table = new Integer[size];
        count = 0;
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private void rehash() {
        int newSize = size * 2;
        Integer[] newTable = new Integer[newSize];

        // Reinsertar todos los elementos de la tabla vieja en la nueva
        for (Integer key : table) {
            if (key != null) {
                int index = key % newSize;
                while (newTable[index] != null) {
                    index = (index + 1) % newSize;
                }
                newTable[index] = key;
            }
        }

        // Actualizar la tabla y el tamaño
        table = newTable;
        size = newSize;
    }

    public void insert(int key) {
        if ((double) count / size >= 0.7) {
            rehash();
        }

        int index = hashFunction(key);

        // Usar sondeo lineal para encontrar una posición libre
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = key;
        count++;
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] == key) {
                return true;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;  // Volver al inicio (prevención de bucles infinitos)
        }

        return false;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] == key) {
                table[index] = null;
                count--;
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) break;
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": " + table[i] + "\n");
        }
    }
}
