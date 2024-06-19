package model;

public class perfilUsuarios {
    private int IdUsuario;
    private String Telefono;
    private String imagenPerfil;
    private String biografia;
    private String intereses;
    private int numeroVistas;

    public perfilUsuarios() {
    }

    public perfilUsuarios(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public perfilUsuarios(int idUsuario, String telefono, String imagenPerfil, String biografia, String intereses, int numeroVistas) {
        IdUsuario = idUsuario;
        Telefono = telefono;
        this.imagenPerfil = imagenPerfil;
        this.biografia = biografia;
        this.intereses = intereses;
        this.numeroVistas = numeroVistas;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
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
        return "perfilUsuarios{" +
                "IdUsuario=" + IdUsuario +
                ", Telefono='" + Telefono + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                ", biografia='" + biografia + '\'' +
                ", intereses='" + intereses + '\'' +
                ", numeroVistas=" + numeroVistas +
                '}';
    }
}
