package grafo;

public class Gasolinera implements NodoGrafo{
    private String clave;
    private String rotulo;
    private String direccion;
    private String latitud;
    private String longitud;

    public Gasolinera(String clave, String rotulo, String direccion, String latitud, String longitud) {
        this.clave = clave;
        this.rotulo = rotulo;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Gasolinera{" +
                "clave='" + clave + '\'' +
                ", rotulo='" + rotulo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }

    @Override
    public String getClave() {
        return this.clave;
    }
}
