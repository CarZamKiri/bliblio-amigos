package javBeans;

public class contrasenas {
    private String email;
    private String contrasena;

    public contrasenas() {
    }

    public contrasenas(String email) {
        this.email = email;
    }

    public contrasenas(String email, String contrasena) {
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
        return "contrasenas{" +
                "email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
