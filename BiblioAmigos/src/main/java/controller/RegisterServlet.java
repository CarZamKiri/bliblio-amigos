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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String secondSurname = request.getParameter("secondSurname");
        String username = request.getParameter("username");
        String date = request.getParameter("date");
        int gender = Integer.parseInt(request.getParameter("gender"));
        boolean isAdmin = false;

        // Hash the password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        Connection conn = null;
        try {
            conn = ConexionBD.obtenerConexion();
            conn.setAutoCommit(false);

            // Insert into Users table
            String sqlUser = "INSERT INTO Public.\"Users\" (mail, password, admin) VALUES (?, ?, ?) RETURNING id_user";
            PreparedStatement stmtUser = conn.prepareStatement(sqlUser);
            stmtUser.setString(1, email);
            stmtUser.setString(2, hashedPassword);
            stmtUser.setBoolean(3, isAdmin);
            ResultSet rsUser = stmtUser.executeQuery();
            int userId = 0;
            if (rsUser.next()) {
                userId = rsUser.getInt("id_user");
            }
            rsUser.close();
            stmtUser.close();

            // Insert into Person table
            String sqlPerson = "INSERT INTO Public.\"Person\" (fk_user, name, last_name, second_surname, username, date, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtPerson = conn.prepareStatement(sqlPerson);
            stmtPerson.setInt(1, userId);
            stmtPerson.setString(2, name);
            stmtPerson.setString(3, lastName);
            stmtPerson.setString(4, secondSurname);
            stmtPerson.setString(5, username);
            stmtPerson.setDate(6, java.sql.Date.valueOf(date));
            stmtPerson.setInt(7, gender);

            int rowsInserted = stmtPerson.executeUpdate();
            if (rowsInserted > 0) {
                conn.commit();
                response.sendRedirect("login.jsp");
            } else {
                conn.rollback();
                response.sendRedirect("signUpMail.jsp?error=registrationFailed");
            }
            stmtPerson.close();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            response.sendRedirect("signUpMail.jsp?error=sqlException");
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    ConexionBD.cerrarConexion();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
