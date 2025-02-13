package examen_clase_3101;

public class MainSinColaCircular {
    public static void main(String[] args) {
        IntegerStackOrQueue structure = new IntegerStackOrQueue();

        // Prueba en modo Pila (Stack)
        System.out.println("### Prueba en Modo Pila ###");
        structure.setStackMode();
        structure.insert(10);
        structure.insert(20);
        structure.insert(30);
        System.out.println("Contenido de la pila: " + structure.list());
        System.out.println("Elemento extraído: " + structure.get());
        System.out.println("Contenido de la pila después de extraer: " + structure.list());

        // Prueba en modo Cola (Queue)
        System.out.println("\n### Prueba en Modo Cola ###");
        structure.setQueueMode();
        structure.insert(1);
        structure.insert(2);
        structure.insert(3);
        System.out.println("Contenido de la cola: " + structure.list());
        System.out.println("Elemento extraído: " + structure.get());
        System.out.println("Contenido de la cola después de extraer: " + structure.list());

        // Prueba sin cola circular
        System.out.println("\n### Prueba de Cola sin circular ###");
        for (int i = 4; i <= 12; i++) {
            structure.insert(i);
        }
        System.out.println("Contenido de la cola después de múltiples inserciones: " + structure.list());
        System.out.println("Extrayendo algunos elementos...");
        for (int i = 0; i < 3; i++) {
            System.out.println("Elemento extraído: " + structure.get());
        }
        System.out.println("Contenido de la cola después de extracciones: " + structure.list());
    }



}
