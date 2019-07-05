public class Pais {
    private int id;
    private String nombre;
    private Boolean visa;
    private Boolean pasaporte;

    public Pais(int id, String nombre, Boolean visa, Boolean pasaporte) {
        this.id = id;
        this.nombre = nombre;
        this.visa = visa;
        this.pasaporte = pasaporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getVisa() {
        return visa;
    }

    public void setVisa(Boolean visa) {
        this.visa = visa;
    }

    public Boolean getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Boolean pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", visa=" + visa +
                ", pasaporte=" + pasaporte +
                '}';
    }
}
