package controller;

import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AutocompleteServlet")
public class AutocompleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String term = request.getParameter("term");
        String type = request.getParameter("type");

        List<String> suggestions = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.obtenerConexion();
            String sql = "";
            switch (type) {
                case "autor":
                    sql = "SELECT name FROM public.\"Authors\" WHERE author LIKE ?";
                    break;
                case "genero":
                    sql = "SELECT name FROM public.\"Genres\" WHERE genres LIKE ?";
                    break;
                case "editorial":
                    sql = "SELECT name FROM public.\"Publishers\" WHERE publisher LIKE ?";
                    break;
                case "categoria":
                    sql = "SELECT name FROM public.\"Categories\" WHERE category LIKE ?";
                    break;
                default:
                    break;
            }

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + term + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                suggestions.add(resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexion();
        }

        // Convert the suggestions list to JSON
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(suggestions);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
