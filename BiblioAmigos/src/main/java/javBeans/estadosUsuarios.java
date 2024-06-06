package javBeans;

public class estadosUsuarios {
    private int idEstado;
    private String nombre;

    public estadosUsuarios() {
    }

    public estadosUsuarios(int idEstado) {
        this.idEstado = idEstado;
    }

    public estadosUsuarios(String nombre) {
        this.nombre = nombre;
    }

    public estadosUsuarios(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "estadosUsuarios{" +
                "idEstado=" + idEstado +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
