package javBeans;

public class editoriales {
    private int idEditorial;
    private String nombre;

    public editoriales() {
    }

    public editoriales(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public editoriales(int idEditorial, String nombre) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "editoriales{" +
                "idEditorial=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
