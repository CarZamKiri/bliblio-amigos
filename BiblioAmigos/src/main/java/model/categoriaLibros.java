package model;

public class categoriaLibros {
    private int idCategoria;
    private String categoria;

    public categoriaLibros() {
    }

    public categoriaLibros(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public categoriaLibros(int idCategoria, String categoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "categoriaLibros{" +
                "idCategoria=" + idCategoria +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
