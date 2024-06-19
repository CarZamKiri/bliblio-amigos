package controller;

import dao.LibrosDAO;
import model.libros;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchBookServlet")
public class searchBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el parámetro de búsqueda desde la solicitud
        String titulo = request.getParameter("titulo");

        // Crear instancia de LibrosDAO
        LibrosDAO librosDAO = new LibrosDAO();

        try {
            // Buscar libros por título utilizando el método buscarLibrosPorTitulo
            List<libros> librosEncontrados = librosDAO.buscarLibrosPorTitulo(titulo);

            // Setear atributos en el request para pasarlos a la vista (JSP)
            request.setAttribute("librosEncontrados", librosEncontrados);
            request.setAttribute("tituloBuscado", titulo);

            // Redirigir a la vista de resultados de búsqueda
            request.getRequestDispatcher("listbooks/resultadosBusqueda.jsp").forward(request, response);

        } catch (SQLException e) {
            // Manejar cualquier excepción SQL
            e.printStackTrace(); // o loguear el error
            request.setAttribute("error", "Error al buscar libros por título");
            request.getRequestDispatcher("/error.jsp").forward(request, response);

        } finally {
            // Cerrar conexiones y liberar recursos
            librosDAO.cerrarConexion();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
