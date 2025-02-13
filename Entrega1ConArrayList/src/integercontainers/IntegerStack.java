package integercontainers;


import java.util.ArrayList;

public class IntegerStack {
    // al ser pila dinámica elijo trabajar con ArrayList
    private ArrayList<Integer> stack;
    //constructor
    public IntegerStack() {
        stack = new ArrayList<>();
    }

    //apilar elementos
    public void push(Integer i){
        stack.add(i);
    }
    //desapilar elemento eliminando y devolviendo el último
    public Integer pop(){
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size() - 1); // Si no está vacía, elimina y devuelve el último elemento
        }
    }

    //obtener elemento situado encima de la pila:
    public Integer top(){
        if (stack.isEmpty()){
            return null;
        }else{
            return stack.get(stack.size() - 1);
        }
    }
    // contar numero de elementos que tiene la pila
    public int size(){
        return stack.size();
    }

    // comprobar si un elemento está en la pila
    public boolean search(Integer i){
        return stack.contains(i);
    }

    //mostrar el contenido de la pila

    public String toString(){
        if (stack.isEmpty()){
            return "Empty Stack";
        }else{
            return stack.toString();
        }
    }

}
