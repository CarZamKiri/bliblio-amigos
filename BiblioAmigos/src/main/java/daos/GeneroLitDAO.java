package daos;

import Modelo.ConexionBD;
import javBeans.generoLit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroLitDAO {

    // Create
    public boolean insertGeneroLit(generoLit genero) throws SQLException {
        String sql = "INSERT INTO generoLit (nombre) VALUES (?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, genero.getNombre());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<generoLit> listAllGeneroLit() throws SQLException {
        List<generoLit> listGeneroLit = new ArrayList<>();
        String sql = "SELECT * FROM generoLit";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idGeneroLit = resultSet.getInt("idGeneroLit");
            String nombre = resultSet.getString("nombre");

            generoLit genero = new generoLit(idGeneroLit, nombre);
            listGeneroLit.add(genero);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listGeneroLit;
    }

    // Update
    public boolean updateGeneroLit(generoLit genero) throws SQLException {
        String sql = "UPDATE generoLit SET nombre = ? WHERE idGeneroLit = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, genero.getNombre());
        statement.setInt(2, genero.getIdGeneroLit());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteGeneroLit(int idGeneroLit) throws SQLException {
        String sql = "DELETE FROM generoLit WHERE idGeneroLit = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idGeneroLit);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public generoLit getGeneroLit(int idGeneroLit) throws SQLException {
        generoLit genero = null;
        String sql = "SELECT * FROM generoLit WHERE idGeneroLit = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idGeneroLit);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            genero = new generoLit(idGeneroLit, nombre);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return genero;
    }
}
