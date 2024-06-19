package dao;

import util.ConexionBD;
import model.editoriales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EditorialesDAO {

    // Create
    public boolean insertEditorial(editoriales editorial) throws SQLException {
        String sql = "INSERT INTO editoriales (nombre) VALUES (?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, editorial.getNombre());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<editoriales> listAllEditoriales() throws SQLException {
        List<editoriales> listEditoriales = new ArrayList<>();
        String sql = "SELECT * FROM editoriales";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idEditorial = resultSet.getInt("idEditorial");
            String nombre = resultSet.getString("nombre");

            editoriales editorial = new editoriales(idEditorial, nombre);
            listEditoriales.add(editorial);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listEditoriales;
    }

    // Update
    public boolean updateEditorial(editoriales editorial) throws SQLException {
        String sql = "UPDATE editoriales SET nombre = ? WHERE idEditorial = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, editorial.getNombre());
        statement.setInt(2, editorial.getIdEditorial());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteEditorial(int idEditorial) throws SQLException {
        String sql = "DELETE FROM editoriales WHERE idEditorial = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idEditorial);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public editoriales getEditorial(int idEditorial) throws SQLException {
        editoriales editorial = null;
        String sql = "SELECT * FROM editoriales WHERE idEditorial = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idEditorial);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            editorial = new editoriales(idEditorial, nombre);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return editorial;
    }
}
