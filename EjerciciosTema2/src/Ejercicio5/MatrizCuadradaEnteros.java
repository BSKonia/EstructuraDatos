package Ejercicio5;

public class MatrizCuadradaEnteros {


    private int[][] matriz;
    private int capacidad;

    // Constructor que inicializa la matriz con ceros
    public MatrizCuadradaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad menor o igual que 0.");
        }
        this.capacidad = capacidad;
        this.matriz = new int[capacidad][capacidad];
    }

    // Actualiza el valor en una posición específica de la matriz
    public void actualizar(int valor, int fila, int columna) {
        validarIndices(fila, columna);
        this.matriz[fila][columna] = valor;
    }

    // Resetea a cero un elemento en una posición específica
    public void resetear(int fila, int columna) {
        validarIndices(fila, columna);
        this.matriz[fila][columna] = 0;
    }

    // Resetea toda la matriz a ceros
    public void resetear() {
        for (int i = 0; i < this.capacidad; i++) {
            for (int j = 0; j < this.capacidad; j++) {
                this.matriz[i][j] = 0;
            }
        }
    }

    // Busca un valor en la matriz
    public boolean buscar(int valor) {
        for (int i = 0; i < this.capacidad; i++) {
            for (int j = 0; j < this.capacidad; j++) {
                if (this.matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    // Cuenta las repeticiones de un valor en la matriz
    public int repeticiones(int valor) {
        int contador = 0;
        for (int i = 0; i < this.capacidad; i++) {
            for (int j = 0; j < this.capacidad; j++) {
                if (this.matriz[i][j] == valor) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Devuelve la capacidad de la matriz (número de filas/columnas)
    public int capacidad() {
        return this.capacidad;
    }

    // Devuelve la representación en string de la matriz
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.capacidad; i++) {
            for (int j = 0; j < this.capacidad; j++) {
                sb.append(this.matriz[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Valida que los índices estén dentro de los límites de la matriz
    private void validarIndices(int fila, int columna) {
        if (fila < 0 || fila >= capacidad || columna < 0 || columna >=
                this.capacidad) {
            throw new IndexOutOfBoundsException("Índices fuera de los límites.");
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        MatrizCuadradaEnteros matriz = new MatrizCuadradaEnteros(3);

        // Actualizar algunos valores
        matriz.actualizar(1, 0, 0);
        matriz.actualizar(2, 1, 1);
        matriz.actualizar(3, 2, 2);

        // Imprimir la matriz
        System.out.println(matriz.toString());

        // Buscar un valor
        System.out.println("Buscar 2: " + matriz.buscar(2));

        // Contar repeticiones
        System.out.println("Repeticiones de 0: " + matriz.repeticiones(0));

        // Resetear un elemento
        matriz.resetear(1, 1);
        System.out.println(matriz.toString());

        // Resetear toda la matriz
        matriz.resetear();
        System.out.println(matriz.toString());
    }
}

/**
 * Explicación de cada método:
 * Constructor MatrizCuadradaEnteros(int capacidad):
 *
 * Inicializa una matriz cuadrada de capacidad x capacidad, llena de ceros. Lanza una excepción si capacidad es menor o igual a cero.
 * actualizar(int valor, int fila, int columna):
 *
 * Actualiza la posición (fila, columna) con el valor dado.
 * Usa validarIndices para lanzar una excepción si los índices son inválidos.
 * resetear(int fila, int columna):
 *
 * Resetea a cero la posición (fila, columna). También valida los índices antes de modificar.
 * resetear():
 *
 * Recorre toda la matriz y establece cada posición a cero.
 * buscar(int valor):
 *
 * Recorre la matriz buscando el valor. Devuelve true si lo encuentra y false si no.
 * repeticiones(int valor):
 *
 * Cuenta el número de apariciones de valor en la matriz y lo devuelve.
 * capacidad():
 *
 * Devuelve la capacidad de la matriz, es decir, el número de filas o columnas.
 * toString():
 *
 * Construye una representación en String de la matriz, separando las columnas con tabuladores y cada fila con un salto de línea.
 * Método validarIndices(int fila, int columna):
 *
 * Método privado que verifica si los índices (fila, columna) están dentro del rango válido de la matriz cuadrada. Lanza una excepción si están fuera de los límites.
 */