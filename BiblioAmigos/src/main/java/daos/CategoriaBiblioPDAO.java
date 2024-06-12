package daos;

import Modelo.ConexionBD;
import javBeans.categoriaBiblioP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaBiblioPDAO {

    // Create
    public boolean insertCategoriaBiblioP(categoriaBiblioP categoria) throws SQLException {
        String sql = "INSERT INTO categoriaBiblioP (CategoriaP) VALUES (?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categoria.getCategoriaP());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<categoriaBiblioP> listAllCategorias() throws SQLException {
        List<categoriaBiblioP> listCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoriaBiblioP";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idCategoriaP = resultSet.getInt("idCategoriaP");
            String categoriaP = resultSet.getString("CategoriaP");

            categoriaBiblioP categoria = new categoriaBiblioP(idCategoriaP, categoriaP);
            listCategorias.add(categoria);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listCategorias;
    }

    // Update
    public boolean updateCategoriaBiblioP(categoriaBiblioP categoria) throws SQLException {
        String sql = "UPDATE categoriaBiblioP SET CategoriaP = ? WHERE idCategoriaP = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categoria.getCategoriaP());
        statement.setInt(2, categoria.getIdCategoriaP());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteCategoriaBiblioP(categoriaBiblioP categoria) throws SQLException {
        String sql = "DELETE FROM categoriaBiblioP WHERE idCategoriaP = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, categoria.getIdCategoriaP());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public categoriaBiblioP getCategoriaBiblioP(int idCategoriaP) throws SQLException {
        categoriaBiblioP categoria = null;
        String sql = "SELECT * FROM categoriaBiblioP WHERE idCategoriaP = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idCategoriaP);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String categoriaP = resultSet.getString("CategoriaP");
            categoria = new categoriaBiblioP(idCategoriaP, categoriaP);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return categoria;
    }
}

