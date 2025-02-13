package grafo;

import java.util.*;

public class Grafo {
    private Map<String, Map<String, Double>> adjList;

    public Grafo() {
            this.adjList = new HashMap<>();
        }

        public boolean insertarNodo(NodoGrafo nodo) {
            if (adjList.containsKey(nodo.getClave())) {
                return false;
            }
            adjList.put(nodo.getClave(), new HashMap<>());
            return true;
        }

        public boolean borrarNodo(String clave) {
            if (!adjList.containsKey(clave)) {
                return false;
            }
            adjList.remove(clave);
            for (Map<String, Double> edges : adjList.values()) {
                edges.remove(clave);
            }
            return true;
        }

        public boolean existeNodo(String clave) {
            return adjList.containsKey(clave);
        }

        public int numeroNodos() {
            return adjList.size();
        }

        public boolean insertarArista(String clave1, String clave2, Double peso) {
            if (!adjList.containsKey(clave1) || !adjList.containsKey(clave2)) {
                return false;
            }
            adjList.get(clave1).put(clave2, peso);
            adjList.get(clave2).put(clave1, peso);
            return true;
        }

        public boolean borrarArista(String clave1, String clave2) {
            if (!adjList.containsKey(clave1) || !adjList.get(clave1).containsKey(clave2)) {
                return false;
            }
            adjList.get(clave1).remove(clave2);
            adjList.get(clave2).remove(clave1);
            return true;
        }

        public boolean existeArista(String clave1, String clave2) {
            return adjList.containsKey(clave1) && adjList.get(clave1).containsKey(clave2);
        }

        public int numeroAristas() {
            int totalAristas = 0;
            for (Map<String, Double> edges : adjList.values()) {
                totalAristas += edges.size();
            }
            return totalAristas / 2; // Cada arista se cuenta dos veces
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Map<String, Double>> entry : adjList.entrySet()) {
                sb.append(entry.getKey()).append(": ");
                for (Map.Entry<String, Double> edge : entry.getValue().entrySet()) {
                    sb.append(edge.getKey()).append("(").append(edge.getValue()).append("), ");
                }
                sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio
                sb.append("\n");
            }
            return sb.toString();
        }

        public List<Double> Dijkstra(String origen) {
            // Vector de distancias mínimas
            Map<String, Double> distancias = new HashMap<>();
            // Conjunto de nodos visitados
            Set<String> visitados = new HashSet<>();
            // Cola de prioridad para seleccionar el nodo con menor distancia
            PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

            // Inicializar distancias a infinito y la distancia al origen como 0
            for (String nodo : adjList.keySet()) {
                distancias.put(nodo, Double.MAX_VALUE);
            }
            distancias.put(origen, 0.0);

            // Añadir el origen a la cola
            cola.add(origen);

            // Mientras haya nodos en la cola
            while (!cola.isEmpty()) {
                // Extraer el nodo con la distancia mínima
                String actual = cola.poll();
                if (visitados.contains(actual)) continue;

                // Marcar como visitado
                visitados.add(actual);

                // Relajar las aristas
                for (Map.Entry<String, Double> vecino : adjList.get(actual).entrySet()) {
                    String nodoVecino = vecino.getKey();
                    Double pesoArista = vecino.getValue();

                    if (!visitados.contains(nodoVecino)) {
                        double nuevaDistancia = distancias.get(actual) + pesoArista;
                        if (nuevaDistancia < distancias.get(nodoVecino)) {
                            distancias.put(nodoVecino, nuevaDistancia);
                            cola.add(nodoVecino);
                        }
                    }
                }
            }

            // Convertir el mapa de distancias en una lista
            List<Double> resultado = new ArrayList<>();
            for (String nodo : adjList.keySet()) {
                resultado.add(distancias.get(nodo));
            }
            return resultado;
        }

        public List<String> Dijkstra(String origen, String destino) {
            // Mapas para distancias y predecesores
            Map<String, Double> distancias = new HashMap<>();
            Map<String, String> predecesores = new HashMap<>();
            Set<String> visitados = new HashSet<>();
            PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

            // Inicializar distancias a infinito y predecesores
            for (String nodo : adjList.keySet()) {
                distancias.put(nodo, Double.MAX_VALUE);
                predecesores.put(nodo, null);
            }
            distancias.put(origen, 0.0);
            cola.add(origen);

            while (!cola.isEmpty()) {
                String actual = cola.poll();
                if (visitados.contains(actual)) continue;

                if (actual.equals(destino)) break;

                visitados.add(actual);

                for (Map.Entry<String, Double> vecino : adjList.get(actual).entrySet()) {
                    String nodoVecino = vecino.getKey();
                    Double pesoArista = vecino.getValue();

                    if (!visitados.contains(nodoVecino)) {
                        double nuevaDistancia = distancias.get(actual) + pesoArista;
                        if (nuevaDistancia < distancias.get(nodoVecino)) {
                            distancias.put(nodoVecino, nuevaDistancia);
                            predecesores.put(nodoVecino, actual);
                            cola.add(nodoVecino);
                        }
                    }
                }
            }

            // Reconstruir el camino
            List<String> camino = new ArrayList<>();
            String paso = destino;

            while (paso != null) {
                camino.add(0, paso);
                paso = predecesores.get(paso);
            }

            if (!camino.isEmpty() && !camino.get(0).equals(origen)) {
                return null; // No existe camino
            }

            return camino;
        }

}
