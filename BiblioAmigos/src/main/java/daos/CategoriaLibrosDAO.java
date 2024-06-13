package daos;

import Modelo.ConexionBD;
import javBeans.categoriaLibros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaLibrosDAO {

    // Create
    public boolean insertCategoriaLibros(categoriaLibros categoria) throws SQLException {
        String sql = "INSERT INTO categoriaLibros (categoria) VALUES (?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categoria.getCategoria());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<categoriaLibros> listAllCategorias() throws SQLException {
        List<categoriaLibros> listCategorias = new ArrayList<>();
        String sql = "SELECT * FROM categoriaLibros";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idCategoria = resultSet.getInt("idCategoria");
            String categoriaNombre = resultSet.getString("categoria");

            categoriaLibros categoriaLibro = new categoriaLibros(idCategoria, categoriaNombre);
            listCategorias.add(categoriaLibro);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listCategorias;
    }

    // Update
    public boolean updateCategoriaLibros(categoriaLibros categoria) throws SQLException {
        String sql = "UPDATE categoriaLibros SET categoria = ? WHERE idCategoria = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, categoria.getCategoria());
        statement.setInt(2, categoria.getIdCategoria());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteCategoriaLibros(int idCategoria) throws SQLException {
        String sql = "DELETE FROM categoriaLibros WHERE idCategoria = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idCategoria);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public categoriaLibros getCategoriaLibros(int idCategoria) throws SQLException {
        categoriaLibros categoria = null;
        String sql = "SELECT * FROM categoriaLibros WHERE idCategoria = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idCategoria);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String categoriaNombre = resultSet.getString("categoria");
            categoria = new categoriaLibros(idCategoria, categoriaNombre);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return categoria;
    }
}
