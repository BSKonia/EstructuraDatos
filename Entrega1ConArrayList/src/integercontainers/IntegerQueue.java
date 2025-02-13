package integercontainers;

import java.util.ArrayList;

public class IntegerQueue {
    private ArrayList<Integer> queue;

    public IntegerQueue() {
        queue = new ArrayList<>();
    }

    //insertar un elemento
    public void insert(Integer i){
        queue.add(i);
    }

    //sacar un elemento
    public Integer remove(){
        if (queue.isEmpty()){
            return null;
        }else
            return queue.remove(0);
    }

    //Obtener el elemento situado en la cabecera de la cola
    public Integer seek(){
        if (queue.isEmpty()){
            return null;
        }else
            return queue.get(0);
    }

    // contar numero de elementos de la cola
    public int size(){
        return queue.size();
    }
    // buscar un elemento en la cola
    public boolean search(Integer i){
        return queue.contains(i);
    }
    // mostrar el contenido de la cola

    public String toString(){
        if (queue.isEmpty()){
            return "Empty Stack";
        }else{
            return queue.toString();
        }
    }


}
