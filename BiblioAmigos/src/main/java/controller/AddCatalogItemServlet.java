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
import java.sql.SQLException;

@WebServlet("/addCatalogItemServlet")
public class AddCatalogItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String field = request.getParameter("field");
        String value = request.getParameter("value");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionBD.obtenerConexion();
            String table = getTable(field);
            String column = getColumn(field);
            String sql = "INSERT INTO public.\"" + table + "\" (" + column + ") VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, value);
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

    private String getTable(String field) {
        switch (field) {
            case "author":
                return "Authors";
            case "genre":
                return "Genres";
            case "publisher":
                return "Publishers";
            case "category":
                return "Categories";
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }

    private String getColumn(String field) {
        switch (field) {
            case "author":
                return "author";
            case "genre":
                return "genre";
            case "publisher":
                return "publisher";
            case "category":
                return "category";
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }
}
