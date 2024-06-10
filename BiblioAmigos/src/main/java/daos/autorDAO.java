package daos;

import Modelo.ConexionBD;
import javBeans.autores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class autorDAO {
    // Create
    public boolean insertAutor(autores autor) throws SQLException {
        String sql = "INSERT INTO autores (nombre, biografia) VALUES (?, ?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autor.getNombre());
        statement.setString(2, autor.getBiografia());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<autores> listAllAutores() throws SQLException {
        List<autores> listAutores = new ArrayList<>();
        String sql = "SELECT * FROM autores";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idAutor = resultSet.getInt("idAutor");
            String nombre = resultSet.getString("nombre");
            String biografia = resultSet.getString("biografia");

            autores autor = new autores(idAutor, nombre, biografia);
            listAutores.add(autor);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listAutores;
    }

    // Update
    public boolean updateAutor(autores autor) throws SQLException {
        String sql = "UPDATE autores SET nombre = ?, biografia = ? WHERE idAutor = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autor.getNombre());
        statement.setString(2, autor.getBiografia());
        statement.setInt(3, autor.getIdAutor());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteAutor(autores autor) throws SQLException {
        String sql = "DELETE FROM autores WHERE idAutor = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, autor.getIdAutor());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public autores getAutor(int id) throws SQLException {
        autores autor = null;
        String sql = "SELECT * FROM autores WHERE idAutor = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String biografia = resultSet.getString("biografia");

            autor = new autores(id, nombre, biografia);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return autor;
    }
}
