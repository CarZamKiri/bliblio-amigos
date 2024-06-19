package model;

public class estadoUsuarios {
    private int idEstadoUsuario;
    private String nombre;

    public estadoUsuarios() {
    }

    public estadoUsuarios(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public estadoUsuarios(String nombre) {
        this.nombre = nombre;
    }

    public estadoUsuarios(int idEstadoUsuario, String nombre) {
        this.idEstadoUsuario = idEstadoUsuario;
        this.nombre = nombre;
    }

    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "estadoUsuarios{" +
                "idEstadoUsuario=" + idEstadoUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
