public class Aeropuerto {
    private String nombre;
    private String direccion;
    private int codigo_postal;
    private int id_pais;

    public Aeropuerto(String nombre, String direccion, int codigo_postal, int id_pais) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", id_pais='" + id_pais + '\'' +
                '}';
    }
}
