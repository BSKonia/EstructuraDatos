package Examenclase2901;

public class ParallelArray2 {
    private String[] strings1;
    private String[] strings2;
    private Integer[] enteros;
    private int size;
    private int capacity;

    public ParallelArray2 (){
        strings1 = new String[10];
        strings2 = new String[10];
        enteros = new Integer[10];
        size = 0;
    }

    public void insert (String str1, String str2, Integer i){
        // primero compruebo si hay espacio
        capacity = strings1.length;
        if (capacity == size){
            System.out.println("El array está lleno, vamos a duplicar su tamaño");
            resize();
        }
        strings1[size] = str1;
        strings2[size] = str2;
        enteros[size] = i;
        size++;
    }
    public boolean delete (String str1, String str2, Integer i){
            for (int j = 0; j < size; j++) {
                if (strings1[j]==(str1) && strings2[j] ==(str2) && enteros[j] ==(i)) {
                    for (int k = j; k < size - 1; k++) {    // Desplazar los elementos a la izquierda
                        strings1[k] = strings1[k + 1];
                        strings2[k] = strings2[k + 1];
                        enteros[k] = enteros[k + 1];
                    }
                    size --;
                    strings1[size] = null; // Limpiar la última posición
                    strings2[size] = null;
                    enteros[size] = null;
                    return true;
                }
            }
            return false;

    }
    public int size(){
        return size;
    }
    public void empty(){
        size=0;
    }
    public String toString() {
        if (size == 0) {
            return "[Array paralelo vacío]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append("[str1=").append(strings1[i]).append
                    (", str2=").append(strings2[i]).append
                    (", i=").append(enteros[i]).append("]");
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Redimensiona los arrays duplicando su capacidad.
    private void resize() {
        int newCapacity = strings1.length * 2;
        String[] newstrings1 = new String[newCapacity];
        String[] newstrings2 = new String[newCapacity];
        Integer[] newenteros = new Integer[newCapacity];

        System.arraycopy(strings1, 0, newstrings1, 0, size);
        System.arraycopy(strings2, 0, newstrings2, 0, size);
        System.arraycopy(enteros, 0, newenteros, 0, size);

        strings1 = newstrings1;
        strings2 = newstrings2;
        enteros = newenteros;
    }
}
