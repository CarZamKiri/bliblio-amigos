package model;

public class categoriaBiblioP {
    private int idCategoriaP;
    private String CategoriaP;

    public categoriaBiblioP() {
    }

    public categoriaBiblioP(int idCategoriaP) {
        this.idCategoriaP = idCategoriaP;
    }

    public categoriaBiblioP(int idCategoriaP, String categoriaP) {
        this.idCategoriaP = idCategoriaP;
        CategoriaP = categoriaP;
    }

    public int getIdCategoriaP() {
        return idCategoriaP;
    }

    public void setIdCategoriaP(int idCategoriaP) {
        this.idCategoriaP = idCategoriaP;
    }

    public String getCategoriaP() {
        return CategoriaP;
    }

    public void setCategoriaP(String categoriaP) {
        CategoriaP = categoriaP;
    }

    @Override
    public String toString() {
        return "categoriaBiblioP{" +
                "idCategoriaP=" + idCategoriaP +
                ", CategoriaP='" + CategoriaP + '\'' +
                '}';
    }
}
