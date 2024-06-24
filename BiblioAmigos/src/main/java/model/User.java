package model;

public class User {
    private int id;
    private String mail;
    private String password;
    private boolean admin;

    // Constructor vacío
    public User() {}

    // Constructor con parámetros
    public User(int id, String mail, String password, boolean admin) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }

    // Constructor sin ID (para inserciones)
    public User(String mail, String password, boolean admin) {
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
