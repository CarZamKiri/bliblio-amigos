package javBeans;

public class generoLit {
    private int idGeneroLit;
    private String nombre;

    public generoLit() {
    }

    public generoLit(int idGeneroLit) {
        this.idGeneroLit = idGeneroLit;
    }

    public generoLit(int idGeneroLit, String nombre) {
        this.idGeneroLit = idGeneroLit;
        this.nombre = nombre;
    }

    public int getIdGeneroLit() {
        return idGeneroLit;
    }

    public void setIdGeneroLit(int idGeneroLit) {
        this.idGeneroLit = idGeneroLit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "generoLit{" +
                "idGeneroLit=" + idGeneroLit +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
