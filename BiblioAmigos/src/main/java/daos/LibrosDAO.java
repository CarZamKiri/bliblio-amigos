package dao;

import Modelo.ConexionBD;
import javBeans.libros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAO {

    // Create
    public boolean insertLibro(libros libro) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, libro.getTitulo());
        statement.setInt(2, libro.getAutor());
        statement.setInt(3, libro.getGeneroLiterario());
        statement.setString(4, libro.getAnoPublicacion());
        statement.setInt(5, libro.getEditorial());
        statement.setString(6, libro.getISBN());
        statement.setInt(7, libro.getCategoria());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowInserted;
    }

    // Read
    public List<libros> listAllLibros() throws SQLException {
        List<libros> listLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        Connection connection = ConexionBD.obtenerConexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String titulo = resultSet.getString("titulo");
            int autor = resultSet.getInt("autor");
            int generoLiterario = resultSet.getInt("generoLiterario");
            String anoPublicacion = resultSet.getString("anoPublicacion");
            int editorial = resultSet.getInt("editorial");
            String ISBN = resultSet.getString("ISBN");
            int categoria = resultSet.getInt("categoria");

            libros libro = new libros(ID, titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);
            listLibros.add(libro);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return listLibros;
    }

    // Update
    public boolean updateLibro(libros libro) throws SQLException {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, generoLiterario = ?, anoPublicacion = ?, editorial = ?, ISBN = ?, categoria = ? WHERE ID = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, libro.getTitulo());
        statement.setInt(2, libro.getAutor());
        statement.setInt(3, libro.getGeneroLiterario());
        statement.setString(4, libro.getAnoPublicacion());
        statement.setInt(5, libro.getEditorial());
        statement.setString(6, libro.getISBN());
        statement.setInt(7, libro.getCategoria());
        statement.setInt(8, libro.getID());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowUpdated;
    }

    // Delete
    public boolean deleteLibro(libros libro) throws SQLException {
        String sql = "DELETE FROM libros WHERE ID = ?";
        Connection connection = ConexionBD.obtenerConexion();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, libro.getID());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        ConexionBD.cerrarConexion();
        return rowDeleted;
    }

    // Get by ID
    public libros getLibro(int id) throws SQLException {
        libros libro = null;
        String sql = "SELECT * FROM libros WHERE ID = ?";

        Connection connection = ConexionBD.obtenerConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String titulo = resultSet.getString("titulo");
            int autor = resultSet.getInt("autor");
            int generoLiterario = resultSet.getInt("generoLiterario");
            String anoPublicacion = resultSet.getString("anoPublicacion");
            int editorial = resultSet.getInt("editorial");
            String ISBN = resultSet.getString("ISBN");
            int categoria = resultSet.getInt("categoria");

            libro = new libros(id, titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);
        }

        resultSet.close();
        statement.close();
        ConexionBD.cerrarConexion();

        return libro;
    }
}
