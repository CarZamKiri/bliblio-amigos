package model;

public class autores {
    private int idAutor;
    private String nombre;
    private String biografia;

    public autores() {

    }

    public autores(int idAutor) {
        this.idAutor = idAutor;
    }

    public autores(int idAutor, String nombre, String biografia) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.biografia = biografia;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "autores{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
