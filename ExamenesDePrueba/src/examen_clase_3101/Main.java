package examen_clase_3101;

public class Main {
        public static void main(String[] args) {

            IntegerStackOrQueue structure = new IntegerStackOrQueue();

            // Prueba en modo Pila (Stack)
            System.out.println("===== PRUEBA EN MODO PILA =====");
            structure.setStackMode();
            structure.insert(10);
            structure.insert(20);
            structure.insert(30);
            System.out.println("Elementos en la pila: " + structure.list());
            System.out.println("Elemento extraído: " + structure.get());
            System.out.println("Elementos en la pila después de extracción: " + structure.list());

            // Prueba en modo Cola (Queue)
            System.out.println("\n===== PRUEBA EN MODO COLA =====");
            structure.setQueueMode();
            structure.insert(100);
            structure.insert(200);
            structure.insert(300);
            System.out.println("Elementos en la cola: " + structure.list());
            System.out.println("Elemento extraído: " + structure.get());
            System.out.println("Elementos en la cola después de extracción: " + structure.list());

            // Prueba del comportamiento circular
            System.out.println("\n===== PRUEBA DE COLA CIRCULAR =====");
            for (int i = 1; i <= 10; i++) {
                structure.insert(i * 10);
            }
            System.out.println("Elementos en la cola tras varias inserciones: " + structure.list());

            for (int i = 0; i < 5; i++) {
                System.out.println("Elemento extraído: " + structure.get());
            }
            System.out.println("Elementos en la cola tras varias extracciones: " + structure.list());
        }


}
