package javBeans;

public class Editoriales {
    private int IDeditorial;
    private String nombre;

    public Editoriales() {

    }

    public Editoriales(int IDeditorial) {
        this.IDeditorial = IDeditorial;
    }

    public Editoriales(String nombre) {
        this.nombre = nombre;
    }

    public Editoriales(int IDeditorial, String nombre) {
        this.IDeditorial = IDeditorial;
        this.nombre = nombre;
    }

    //Getters and setters


    public int getIDeditorial() {
        return IDeditorial;
    }

    public void setIDeditorial(int IDeditorial) {
        this.IDeditorial = IDeditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Editoriales{" +
                "IDeditorial=" + IDeditorial +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

