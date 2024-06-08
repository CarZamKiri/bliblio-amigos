package javBeans;

public class libros {
    private int ID;
    private String titulo;
    private int autor;
    private int generoLiterario;
    private String anoPublicacion;
    private int editorial;
    private String ISBN;
    private int categoria;

    public libros() {
    }

    public libros(int ID) {
        this.ID = ID;
    }

    public libros(int ID, String titulo, int autor, int generoLiterario, String anoPublicacion, int editorial, String ISBN, int categoria) {
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
        this.generoLiterario = generoLiterario;
        this.anoPublicacion = anoPublicacion;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.categoria = categoria;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(int generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(String anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getEditorial() {
        return editorial;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "libros{" +
                "ID=" + ID +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", generoLiterario=" + generoLiterario +
                ", anoPublicacion='" + anoPublicacion + '\'' +
                ", editorial=" + editorial +
                ", ISBN='" + ISBN + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
