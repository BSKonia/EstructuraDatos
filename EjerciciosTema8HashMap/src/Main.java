import java.util.HashMap;
public class Main {

    public static void main(String[] args) {
        String text = "Texto de ejemplo que se utiliza para contar el número de apariciones de una palabra";
        HashMap<String, Integer> wordCount = new HashMap<>();
// Dividir el texto en palabras
        String[] words = text.split(" ");
// Contar las apariciones de cada palabra
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
// Imprimir las apariciones de cada palabra
        System.out.println("Apariciones de palabras: " + wordCount);
    }
}

