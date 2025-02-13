package Examenclase2901;

import java.util.Arrays;

public class ParallelArray {

    private String[] nombres;
    private String[] direcciones;
    private Integer[] edades;
    private int size;
    private int capacity;

    /**
     * El array debe ser "ilimitado" en el sentido de que no tenga una capacidad fija,
     * sino que pueda crecer dinámicamente según se necesiten más elementos.
     * <p>
     * Inicializar el array con una capacidad pequeña (como 10 elementos)
     * es una práctica común en estructuras dinámicas porque evita asignar
     * inicialmente una cantidad excesiva de memoria. Cuando se alcanza el límite,
     * la capacidad se duplica mediante el método expandCapacity(),
     * asegurando que el array pueda crecer sin restricciones hasta que se agote la memoria disponible.
     */
    public ParallelArray() { //la capacidad del array debe ser ilimitada
        nombres = new String[10];
        direcciones = new String[10];
        edades = new Integer[10];
        size = 0; //tamaño inicial es 0, no hay elementos

    }

    public void insert(String str1, String str2, Integer i) { //se pueden cambiar str1 por nombre, direccion y edad

        // Verificar si hay espacio
        capacity = nombres.length;
        if (size >= capacity) {
            System.out.println("El array ya está lleno, debes duplicar su tamaño");
            resize();
        }
        // no hay que verificar si el elemento ya existe, porque puede admitir repetidos
        // Insertar el elemento
        nombres[size] = str1;
        direcciones[size] = str2;
        edades[size] = i;
        size++;

    }

    public boolean delete(String str1, String str2, Integer i) {
        for (int j = 0; j < size; j++) {
            if (nombres[j].equals(str1) && direcciones[j].equals(str2) && edades[j].equals(i)) {
                for (int k = j; k < size - 1; k++) {    // Desplazar los elementos a la izquierda
                    nombres[k] = nombres[k + 1];
                    direcciones[k] = direcciones[k + 1];
                    nombres[k] = nombres[k + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void empty() {
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[Array paralelo vacío]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append("[str1=").append(nombres[i]).append
                            (", str2=").append(direcciones[i]).append
                            (", i=").append(edades[i]).append("]");
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Redimensiona los arrays duplicando su capacidad.
    private void resize() {
        int newCapacity = nombres.length * 2;
        String[] newNombres = new String[newCapacity];
        String[] newDirecciones = new String[newCapacity];
        Integer[] newEdades = new Integer[newCapacity];

        System.arraycopy(nombres, 0, newNombres, 0, size);
        System.arraycopy(direcciones, 0, newDirecciones, 0, size);
        System.arraycopy(edades, 0, newEdades, 0, size);

        nombres = newNombres;
        direcciones = newDirecciones;
        edades = newEdades;
    }
}
