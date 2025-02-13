package TablaHashRedispersionyEncadenamiento;

import java.util.Arrays;

public class HashTableWithResize {
    private int[][] table;
    private int[] sizes;
    private int size;
    private int count; // Número de elementos insertados

    public HashTableWithResize(int initialSize) {
        this.size = initialSize;
        table = new int[size][0];
        sizes = new int[size];
        count = 0;
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private void rehash() {
        int newSize = size * 2;  // Doblamos el tamaño de la tabla
        int[][] newTable = new int[newSize][0];
        int[] newSizes = new int[newSize];

        // Reinsertar todos los elementos de la tabla vieja en la nueva
        for (int i = 0; i < size; i++) {
            for (int val : table[i]) {
                int index = val % newSize;
                int[] newArray = Arrays.copyOf(newTable[index], newSizes[index] + 1);
                newArray[newSizes[index]] = val;
                newTable[index] = newArray;
                newSizes[index]++;
            }
        }

        // Actualizar la tabla y tamaños
        table = newTable;
        sizes = newSizes;
        size = newSize;
    }

    public void insert(int key) {
        // Si la tabla está por encima del 70% de ocupación, hacemos un rehash
        if ((double) count / size >= 0.7) {
            rehash();
        }

        int index = hashFunction(key);
        // Verificar si ya existe el valor en el bucket
        for (int val : table[index]) {
            if (val == key) return;
        }

        // Añadir el valor al bucket correspondiente
        int[] newArray = Arrays.copyOf(table[index], sizes[index] + 1);
        newArray[sizes[index]] = key;
        table[index] = newArray;
        sizes[index]++;
        count++;
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        for (int val : table[index]) {
            if (val == key) return true;
        }
        return false;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int pos = -1;

        // Buscar la posición del elemento dentro del array
        for (int i = 0; i < sizes[index]; i++) {
            if (table[index][i] == key) {
                pos = i;
                break;
            }
        }

        // Si lo encontramos, eliminamos y compactamos el array
        if (pos != -1) {
            int[] newArray = new int[sizes[index] - 1];
            for (int i = 0, j = 0; i < sizes[index]; i++) {
                if (i != pos) {
                    newArray[j++] = table[index][i];
                }
            }
            table[index] = newArray;
            sizes[index]--;
            count--;
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": " + Arrays.toString(table[i]) + "\n");
        }
    }
}
