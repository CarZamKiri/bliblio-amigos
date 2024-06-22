package controller;
import org.mindrot.jbcrypt.BCrypt;
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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Hash the password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        Connection conn = null;
        try {
            conn = ConexionBD.obtenerConexion();
            String sql = "INSERT INTO Public.\"Users\" (mail, password) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, hashedPassword);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("signUp.jsp"); // Redirige a la página de inicio de sesión después del registro exitoso
            } else {
                response.sendRedirect("signUp.jsp?error=registrationFailed"); // Redirige de nuevo al registro con un mensaje de error
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("signUp.jsp?error=sqlException"); // Redirige de nuevo al registro con un mensaje de error
        } finally {
            ConexionBD.cerrarConexion();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
