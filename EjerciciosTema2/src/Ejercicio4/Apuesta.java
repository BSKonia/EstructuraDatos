package Ejercicio4;

public class Apuesta {

    private int totalNumeros;
    private int [] numeros;

    private int numerosElegidos;

    public Apuesta(int totalNumeros, int[] numeros, int numerosElegidos) {
        this.totalNumeros = totalNumeros;
        this.numeros = numeros;
        this.numerosElegidos = numerosElegidos;
    }

    public boolean completa() {
        return (numerosElegidos == totalNumeros);
    }

    public boolean vacia(){
        return (numerosElegidos == 0);
    }

    public int indiceDe(int numero) {
        int i = 0;
        while (i < numerosElegidos) {
            if (numeros[i] == numero){
                return i;
            } i++;
        }
        return -1;
    }
    public boolean existe(int numero) {

        return (indiceDe(numero) >= 0);
    }
    public boolean insertar(int numero) {
        if (completa() || existe(numero)) {
            return false;
        } else {
            numeros[numerosElegidos] = numero;
            numerosElegidos++;
            return true;
        }
    }
    public boolean borrar(int numero){
        int pos = indiceDe(numero);
        int ultimoIndice = numerosElegidos - 1;
        int i;

        if (vacia() || (pos < 0)) {
            return false;
        }
        for (i = pos; i < ultimoIndice; i++)
            numeros[i] = numeros[i+1];

        numerosElegidos--;
        return true;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("Apuesta = [");
        for (int i = 0; i < numerosElegidos; i++)
            sb.append(" ").append(numeros[i]);
        sb.append(" ]");
        return sb.toString();
    }

}
