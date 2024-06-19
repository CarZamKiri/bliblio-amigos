package model;

public class genero {
    private int idGenero;
    private String nombre;

    public genero() {
    }

    public genero(int idGenero) {
        this.idGenero = idGenero;
    }

    public genero(int idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "genero{" +
                "idGenero=" + idGenero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
