package javBeans;

public class Libros {
    private int idLibro;
    private String titulo;
    private int autor;
    private int genero;
    private int anoPublicacion;
    private int Editorial;
    private String isbn;
    private String categoria;

    // Construtor vacio
    public Libros(){

    }
    // Constructor para el id
    public Libros(int idLibro) {
        this.idLibro = idLibro;
    }
    // Construcutor para modificar

    public Libros(String titulo, int autor, int genero, int anoPublicacion, int editorial, String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacion = anoPublicacion;
        this.Editorial = editorial;
        this.isbn = isbn;
        this.categoria = categoria;
    }
    // Construcutor completo

    public Libros(int idLibro, String titulo, int autor, int genero, int anoPublicacion, int editorial, String isbn, String categoria) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacion = anoPublicacion;
        this.Editorial = editorial;
        this.isbn = isbn;
        this.categoria = categoria;
    }

    //getters and setters

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getEditorial() {
        return Editorial;
    }

    public void setEditorial(int editorial) {
        Editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", genero=" + genero +
                ", anoPublicacion=" + anoPublicacion +
                ", Editorial=" + Editorial +
                ", isbn='" + isbn + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
