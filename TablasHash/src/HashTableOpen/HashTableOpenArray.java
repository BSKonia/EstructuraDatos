package HashTableOpen;

import java.util.Arrays;

/**
 * 📝 Ejercicio 1: Implementar Tabla Hash con Encadenamiento usando Arrays
 * 💡 Objetivo:
 * ✔ Implementar una tabla hash con encadenamiento usando arrays dinámicos en lugar de LinkedList.
 * ✔ Métodos: insert(), search(), delete(), printTable().
 * ✔ Manejar colisiones mediante arrays dinámicos.
 */
public class HashTableOpenArray {
    private int[][] table;
    private int[] sizes;
    private int size;

    public HashTableOpenArray(int size) {
        this.size = size;
        table = new int[size][0];  // Inicializamos cada posición con un array vacío
        sizes = new int[size];  // Array para llevar el conteo de elementos en cada bucket
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);

        // Verificar si ya existe el valor
        for (int val : table[index]) {
            if (val == key) return;
        }

        // Redimensionar el array en la posición si es necesario
        int[] newArray = Arrays.copyOf(table[index], sizes[index] + 1);
        newArray[sizes[index]] = key;
        table[index] = newArray;
        sizes[index]++;
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        for (int val : table[index]) {
            if (val == key)
                return true;
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

        // Si se encontró, eliminar y compactar el array
        if (pos != -1) {
            int[] newArray = new int[sizes[index] - 1];
            for (int i = 0, j = 0; i < sizes[index]; i++) {
                if (i != pos) {
                    newArray[j++] = table[index][i];
                }
            }
            table[index] = newArray;
            sizes[index]--;
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": " + Arrays.toString(table[i]) + "\n");
        }
    }
}
