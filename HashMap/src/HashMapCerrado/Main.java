package HashMapCerrado;

public class Main {
    public static void main(String[] args) {
        HashMapOpenAdressing<String, Integer> hashMap = new HashMapOpenAdressing<>();

        hashMap.put("Uno", 1);
        hashMap.put("Dos", 2);
        hashMap.put("Tres", 3);
        hashMap.put("Cuatro", 4);

        System.out.println("Valor de 'Tres': " + hashMap.get("Tres"));

        hashMap.printHashMap();

        System.out.println("Eliminando 'Dos': " + hashMap.remove("Dos"));

        hashMap.printHashMap();
    }
}
