package javBeans;

public class Resenas {
    private int idUsuario;
    private int idLibro;
    private String resena;
    private int calificacion;
    private String fecha;

    public Resenas() {
    }

    public Resenas(String resena, int calificacion, String fecha) {
        this.resena = resena;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public Resenas(int idUsuario, int idLibro, String resena, int calificacion, String fecha) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.resena = resena;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Resenas{" +
                "idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                ", resena='" + resena + '\'' +
                ", calificacion=" + calificacion +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
