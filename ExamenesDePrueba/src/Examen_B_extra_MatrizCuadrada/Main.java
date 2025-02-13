package Examen_B_extra_MatrizCuadrada;

public class Main {
    public static void main(String[] args) {

        MatrizCuadradaEnteros matriz = new MatrizCuadradaEnteros(5);

        matriz.actualizar(2,1,1);
        matriz.actualizar(3,1,2);

        System.out.println(matriz.toString());
    }
}
