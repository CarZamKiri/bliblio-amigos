package controller;

import org.mindrot.jbcrypt.BCrypt;
import util.ConexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;
        try {
            conn = ConexionBD.obtenerConexion();
            String sql = "SELECT id_user, password FROM Public.\"Users\" WHERE mail = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    int userId = resultSet.getInt("id_user");

                    // Create session and set user attributes
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("email", email);

                    // Redirect to the user's profile or home page
                    response.sendRedirect("privateLibrary.jsp");
                } else {
                    request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error al iniciar sesión. Inténtalo de nuevo.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } finally {
            ConexionBD.cerrarConexion();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
