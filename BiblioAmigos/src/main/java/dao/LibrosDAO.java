package dao;

import util.ConexionBD;
import model.libros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAO {

    private Connection conexion;

    public LibrosDAO() {
        this.conexion = ConexionBD.obtenerConexion();
    }

    // Create
    public boolean insertLibro(libros libro) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, libro.getTitulo());
            statement.setInt(2, libro.getAutor());
            statement.setInt(3, libro.getGeneroLiterario());
            statement.setString(4, libro.getAnoPublicacion());
            statement.setInt(5, libro.getEditorial());
            statement.setString(6, libro.getISBN());
            statement.setInt(7, libro.getCategoria());

            return statement.executeUpdate() > 0;
        }
    }

    // Read
    public List<libros> listAllLibros() throws SQLException {
        List<libros> listLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String titulo = resultSet.getString("titulo");
                int autor = resultSet.getInt("autor");
                int generoLiterario = resultSet.getInt("generoLiterario");
                String anoPublicacion = resultSet.getString("anoPublicacion");
                int editorial = resultSet.getInt("editorial");
                String ISBN = resultSet.getString("ISBN");
                int categoria = resultSet.getInt("categoria");
/*
                libros libro = new libros(ID, titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);
                listLibros.add(libro);

 */
            }
        }

        return listLibros;
    }

    // Update
    public boolean updateLibro(libros libro) throws SQLException {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, generoLiterario = ?, anoPublicacion = ?, editorial = ?, ISBN = ?, categoria = ? WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, libro.getTitulo());
            statement.setInt(2, libro.getAutor());
            statement.setInt(3, libro.getGeneroLiterario());
            statement.setString(4, libro.getAnoPublicacion());
            statement.setInt(5, libro.getEditorial());
            statement.setString(6, libro.getISBN());
            statement.setInt(7, libro.getCategoria());
            statement.setInt(8, libro.getID());

            return statement.executeUpdate() > 0;
        }
    }

    // Delete
    public boolean deleteLibro(libros libro) throws SQLException {
        String sql = "DELETE FROM libros WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, libro.getID());

            return statement.executeUpdate() > 0;
        }
    }

    // Get by ID
    public libros getLibro(int id) throws SQLException {
        libros libro = null;
        String sql = "SELECT * FROM libros WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    int autor = resultSet.getInt("autor");
                    int generoLiterario = resultSet.getInt("generoLiterario");
                    String anoPublicacion = resultSet.getString("anoPublicacion");
                    int editorial = resultSet.getInt("editorial");
                    String ISBN = resultSet.getString("ISBN");
                    int categoria = resultSet.getInt("categoria");
/*
                    libro = new libros(id, titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);

 */
                }
            }
        }

        return libro;
    }

    // Search by title or ISBN
    public List<libros> buscarLibros(String query) throws SQLException {
        List<libros> listLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ? OR ISBN LIKE ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                    String titulo = resultSet.getString("titulo");
                    int autor = resultSet.getInt("autor");
                    int generoLiterario = resultSet.getInt("generoLiterario");
                    String anoPublicacion = resultSet.getString("anoPublicacion");
                    int editorial = resultSet.getInt("editorial");
                    String ISBN = resultSet.getString("ISBN");
                    int categoria = resultSet.getInt("categoria");
/*
                    libros libro = new libros(ID, titulo, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);
                    listLibros.add(libro);

 */
                }
            }
        }

        return listLibros;
    }

    // Buscar libros por título y ordenar alfabéticamente
    public List<libros> buscarLibrosPorTitulo(String titulo) throws SQLException {
        List<libros> listLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ? ORDER BY titulo";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + titulo + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                    String tituloLibro = resultSet.getString("titulo");
                    int autor = resultSet.getInt("autor");
                    int generoLiterario = resultSet.getInt("generoLiterario");
                    String anoPublicacion = resultSet.getString("anoPublicacion");
                    int editorial = resultSet.getInt("editorial");
                    String ISBN = resultSet.getString("ISBN");
                    int categoria = resultSet.getInt("categoria");
/*
                    libros libro = new libros(ID, tituloLibro, autor, generoLiterario, anoPublicacion, editorial, ISBN, categoria);
                    listLibros.add(libro);

 */
                }
            }
        }

        return listLibros;
    }

    // Cerrar conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}
