package javBeans;

public class perfilUsuario {
    private int idUsuario;
    private String telefono;
    private String imagenPerfil;
    private String biografia;
    private String intereses;
    private int numeroVistas;

    public perfilUsuario() {
    }

    public perfilUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public perfilUsuario(String telefono, String imagenPerfil, String biografia, String intereses, int numeroVistas) {
        this.telefono = telefono;
        this.imagenPerfil = imagenPerfil;
        this.biografia = biografia;
        this.intereses = intereses;
        this.numeroVistas = numeroVistas;
    }

    public perfilUsuario(int idUsuario, String telefono, String imagenPerfil, String biografia, String intereses, int numeroVistas) {
        this.idUsuario = idUsuario;
        this.telefono = telefono;
        this.imagenPerfil = imagenPerfil;
        this.biografia = biografia;
        this.intereses = intereses;
        this.numeroVistas = numeroVistas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public int getNumeroVistas() {
        return numeroVistas;
    }

    public void setNumeroVistas(int numeroVistas) {
        this.numeroVistas = numeroVistas;
    }

    @Override
    public String toString() {
        return "perfilUsuario{" +
                "idUsuario=" + idUsuario +
                ", telefono='" + telefono + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                ", biografia='" + biografia + '\'' +
                ", intereses='" + intereses + '\'' +
                ", numeroVistas=" + numeroVistas +
                '}';
    }
}
