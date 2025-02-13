package Examenclase2901;

public class Main {
    public static void main(String[] args) {
        ParallelArray2 pa = new ParallelArray2();

        // Insertar registros
        pa.insert("Alice", "Madrid", 30);
        pa.insert("Bob", "Barcelona", 25);
        pa.insert("Alice", "Madrid", 30); // Registro duplicado

        System.out.println("Después de inserciones:");
        System.out.println(pa); // Usa toString()

        // Eliminar un registro
        boolean isDeleted = pa.delete("Alice", "Madrid", 30);
        System.out.println("\n¿Se eliminaron registros? " + isDeleted);
        System.out.println(pa);

        // Vaciar el array
        pa.empty();
        System.out.println("\nDespués de vaciar:");
        System.out.println(pa);
    }
}
