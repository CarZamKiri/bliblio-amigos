package controller;

import com.google.gson.Gson;
import util.ConexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loadCatalogsServlet")
public class LoadCatalogsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String field = request.getParameter("field");

        List<String> items = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionBD.obtenerConexion();
            String table = getTable(field);
            String column = getColumn(field);
            String sql = "SELECT " + column + " FROM public.\"" + table + "\"";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                items.add(rs.getString(column));
            }

            String json = new Gson().toJson(items);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write(json);
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
