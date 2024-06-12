package daos;

import Modelo.ConexionBD;
import javBeans.genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    // Create
    public boolean insertGenero(genero genero) throws SQLException {
        String sql = "INSERT INTO genero (nombre) VALUES (?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, genero.getNombre());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<genero> listAllGeneros() throws SQLException {
        List<genero> listGeneros = new ArrayList<>();
        String sql = "SELECT * FROM genero";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idGenero = resultSet.getInt("idGenero");
            String nombre = resultSet.getString("nombre");

            genero genero = new genero(idGenero, nombre);
            listGeneros.add(genero);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listGeneros;
    }

    // Update
    public boolean updateGenero(genero genero) throws SQLException {
        String sql = "UPDATE genero SET nombre = ? WHERE idGenero = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, genero.getNombre());
        statement.setInt(2, genero.getIdGenero());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteGenero(genero genero) throws SQLException {
        String sql = "DELETE FROM genero WHERE idGenero = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, genero.getIdGenero());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public genero getGenero(int idGenero) throws SQLException {
        genero genero = null;
        String sql = "SELECT * FROM genero WHERE idGenero = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idGenero);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            genero = new genero(idGenero, nombre);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return genero;
    }
}

