package controller;

import util.ConexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/newBookServlet")
public class NewBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String publicationDate = request.getParameter("publicationDate");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        String category = request.getParameter("category");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionBD.obtenerConexion();

            // Obtener ID de autor, género, publisher y categoría
            int authorId = getIdFromCatalog(conn, "Authors", "author", author);
            int genreId = getIdFromCatalog(conn, "Genres", "genre", genre);
            int publisherId = getIdFromCatalog(conn, "Publishers", "publisher", publisher);
            int categoryId = getIdFromCatalog(conn, "Categories", "category", category);

            // Insertar nuevo libro
            String sql = "INSERT INTO public.\"Books\" (title, author, genre, publication_date, publisher, isbn, category) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setInt(2, authorId);
            stmt.setInt(3, genreId);
            stmt.setDate(4, java.sql.Date.valueOf(publicationDate));
            stmt.setInt(5, publisherId);
            stmt.setString(6, isbn);
            stmt.setInt(7, categoryId);
            stmt.executeUpdate();

            response.setStatus(HttpServletResponse.SC_OK);

        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int getIdFromCatalog(Connection conn, String table, String column, String value) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id_" + column + " FROM public.\"" + table + "\" WHERE " + column + " = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, value);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("No se encontró el valor '" + value + "' en la tabla " + table);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
