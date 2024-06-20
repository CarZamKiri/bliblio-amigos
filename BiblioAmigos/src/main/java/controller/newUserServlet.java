package controller;

import dao.UsuariosDAO;
import model.usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/newUserServlet")
public class newUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String email = request.getParameter("email");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        int genero = Integer.parseInt(request.getParameter("genero"));

        // Convertir la fecha de String a java.sql.Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            java.util.Date parsed = format.parse(fechaNacimientoStr);
            fechaNacimiento = new Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            // Redirigir a una página de error
            response.sendRedirect("createUsers/error.jsp");
            return;
        }

        // El estado es "activo" por defecto
        int estado = 1;

        // Crear el objeto usuarios
        usuario usuario = new usuario(nombre, nombreUsuario, email, fechaNacimiento, genero, estado);

        // Insertar el usuario en la base de datos
        UsuariosDAO dao = new UsuariosDAO();
        try {
            boolean success = dao.insertUsuario(usuario);
            if (success) {
                // Redirigir a una página de éxito
                response.sendRedirect("createUsers/exito.jsp");
            } else {
                // Redirigir a una página de error
                response.sendRedirect("createUsers/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Redirigir a una página de error
            response.sendRedirect("createUsers/error.jsp");
        }
    }
}
