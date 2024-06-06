package javBeans;

public class Usuarios {
    private int ID;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String anoNacimiento;
    private String genero;
    private int estado;

    public Usuarios() {
    }

    public Usuarios(int ID) {
        this.ID = ID;
    }

    public Usuarios(String nombre, String nombreUsuario, String email, String anoNacimiento, String genero, int estado) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.anoNacimiento = anoNacimiento;
        this.genero = genero;
        this.estado = estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(String anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", anoNacimiento='" + anoNacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", estado=" + estado +
                '}';
    }
}
