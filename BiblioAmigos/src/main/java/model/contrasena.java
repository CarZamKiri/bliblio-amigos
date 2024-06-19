package model;

public class contrasena {
    private String email;
    private String contrasena;

    public contrasena() {
    }

    public contrasena(String email) {
        this.email = email;
    }

    public contrasena(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "contrasena{" +
                "email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
