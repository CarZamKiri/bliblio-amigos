package javBeans;

public class Usuarios {

    private int id;
    private String nombre;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private int estado;
    private int tipo;

    public Usuarios() {
    }

    public Usuarios(int id) {
        this.id = id;
    }

    public Usuarios(String nombre, String nombreUsuario, String contrasena, String email, int estado, int tipo) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Usuarios(int id, String nombre, String nombreUsuario, String contrasena, String email, int estado, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.estado = estado;
        this.tipo = tipo;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "usuarios{" + "id=" + id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", email=" + email + ", estado=" + estado + ", tipo=" + tipo + '}';
    }




}
