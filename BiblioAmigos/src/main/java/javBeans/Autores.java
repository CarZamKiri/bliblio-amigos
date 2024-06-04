package javBeans;


public class Autores {
    private int idAutor;
    private String nombre;
    private String biografia;

    // Constructor vacio
    public Autores(){

    }

    // Constructor para el id
    public Autores(int idAutor){
        this.idAutor = idAutor;
    }
    //Constructor para modificar
    public Autores(String nombre, String biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
    }
    // Constructor completo


    public Autores(int idAutor, String nombre, String biografia) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.biografia = biografia;
    }

    // Getters and Setters

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autores{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
