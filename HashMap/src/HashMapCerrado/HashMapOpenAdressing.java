package HashMapCerrado;

public class HashMapOpenAdressing <K, V>{
    private static final int SIZE = 10;
    private Entry<K, V>[] table;
    private Entry<K, V> deleted = new Entry<>(null, null);

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public HashMapOpenAdressing() {
        table = new Entry[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null && table[index] != deleted && !table[index].key.equals(key)) {
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                System.out.println("Tabla llena!");
                return;
            }
        }

        table[index] = new Entry<>(key, value);
    }

    public V get(K key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] != deleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                break;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index] != deleted && table[index].key.equals(key)) {
                table[index] = deleted;
                return true;
            }
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                break;
            }
        }
        return false;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void printHashMap() {
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null && table[i] != deleted) {
                System.out.println("Índice " + i + ": [" + table[i].key + " -> " + table[i].value + "]");
            } else {
                System.out.println("Índice " + i + ": vacío");
            }
        }
    }
}
