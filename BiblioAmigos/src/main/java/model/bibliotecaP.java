package model;

public class bibliotecaP {
    private int idLibro;
    private int idUsuario;
    private String notas;
    private int categoriaP ;
    private String Estado;
    private String fecha;

    public bibliotecaP() {
    }

    public bibliotecaP(int idLibro) {
        this.idLibro = idLibro;
    }

    public bibliotecaP(int idLibro, int idUsuario, String notas, int categoriaP, String estado, String fecha) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.notas = notas;
        this.categoriaP = categoriaP;
        Estado = estado;
        this.fecha = fecha;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getCategoriaP() {
        return categoriaP;
    }

    public void setCategoriaP(int categoriaP) {
        this.categoriaP = categoriaP;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "bibliotecaP{" +
                "idLibro=" + idLibro +
                ", idUsuario=" + idUsuario +
                ", notas='" + notas + '\'' +
                ", categoriaP=" + categoriaP +
                ", Estado='" + Estado + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
