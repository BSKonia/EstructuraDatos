package grafo;

import java.io.*;
import java.nio.charset.Charset;

public class Principal {
    public static void main(String[] args) {
        // Crear el grafo
        Grafo grafo = new Grafo();

        // LECTURA DE LOS DATOS DE LAS GASOLINERAS Y CONSTRUCCIÓN DE LOS NODOS DEL GRAFO
        String directorioProyecto = System.getProperty("user.dir");
        String nombreFicheroGasolineras = "gasolineras.csv";
        String separador = System.getProperty("file.separator");
        String pathFicheroGasolineras = directorioProyecto + separador + nombreFicheroGasolineras;

        String[] datosGasolinera = new String[5];
        Gasolinera gasolinera;

        try (FileReader fr = new FileReader(pathFicheroGasolineras, Charset.forName("ISO-8859-1"))) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datosGasolinera = linea.split(";");
                gasolinera = new Gasolinera(datosGasolinera[2], datosGasolinera[4], datosGasolinera[3], datosGasolinera[0], datosGasolinera[1]);
                grafo.insertarNodo(gasolinera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // LECTURA DE LAS DISTANCIAS ENTRE GASOLINERAS Y CONSTRUCCIÓN DE LAS ARISTAS DEL GRAFO
        String nombreFicheroDistanciasGasolineras = "distancias-gasolineras.csv";
        String pathFicheroDistanciasGasolineras = directorioProyecto + separador + nombreFicheroDistanciasGasolineras;
        String[] datosDistanciaGasolineras;

        try (FileReader fr = new FileReader(pathFicheroDistanciasGasolineras, Charset.forName("ISO-8859-1"))) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datosDistanciaGasolineras = linea.split(";");
                grafo.insertarArista(datosDistanciaGasolineras[0], datosDistanciaGasolineras[1], Double.parseDouble(datosDistanciaGasolineras[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verificar la carga del grafo
        System.out.println("Grafo cargado:");
        System.out.println(grafo);

        // Pruebas: Camino más corto
        String origen = "G1"; // Cambiar por una clave válida
        String destino = "G5"; // Cambiar por una clave válida

        System.out.println("Distancias mínimas desde " + origen + ":");
        System.out.println(grafo.Dijkstra(origen));

        System.out.println("Camino más corto entre " + origen + " y " + destino + ":");
        System.out.println(grafo.Dijkstra(origen, destino));
    }
}





