package HashMapAbierto;

/**
 * 🔹 Ejercicio 1: Implementación de HashMap con Encadenamiento Separado (Hashing Abierto)
 * 💡 Descripción: Implementa un HashMap utilizando listas enlazadas para manejar colisiones mediante encadenamiento separado.
 *
 * 📌 Operaciones implementadas:
 *
 * put(K key, V value): Inserta una clave-valor en el HashMap.
 * get(K key): Recupera el valor asociado a una clave.
 * remove(K key): Elimina una clave del HashMap.
 * containsKey(K key): Verifica si la clave existe.
 * printHashMap(): Imprime los valores almacenados.
 */

import java.util.LinkedList;

public class HashMapOpenChaining <K, V>  {
    private int capacity = 10;
    private LinkedList<HashNode<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashMapOpenChaining() {
        table = (LinkedList<HashNode<K, V>>[]) new LinkedList<?>[capacity]; // Conversión segura
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Función hash mejorada: evita valores negativos
    private int hash(K key) {
        if (key == null) throw new IllegalArgumentException("Clave no puede ser null");
        int hash = key.hashCode() % capacity;
        return (hash < 0) ? -hash : hash; // Evitar negativos
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value; // Reemplaza si la clave ya existe
                return;
            }
        }
        table[index].add(new HashNode<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                table[index].remove(node);
                return true;
            }
        }
        return false;
    }

    public void printHashMap() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Índice " + i + ": ");
            for (HashNode<K, V> node : table[i]) {
                System.out.print("[" + node.key + " -> " + node.value + "] ");
            }
            System.out.println();
        }
    }
}