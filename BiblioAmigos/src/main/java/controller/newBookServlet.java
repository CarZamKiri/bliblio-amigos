package controller;

import dao.LibrosDAO;
import model.libros;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/newBookServlet")
public class newBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        int autor = Integer.parseInt(request.getParameter("autor"));
        int genero = Integer.parseInt((request.getParameter("genero")));
        String anioPublicacion = request.getParameter("anioPublicacion");
        int editorial = Integer.parseInt((request.getParameter("editorial")));
        String isbn = request.getParameter("isbn");
        int recomendacion = Integer.parseInt((request.getParameter("recomendacion")));

        libros libro = new libros(titulo, autor, genero, anioPublicacion, editorial, isbn, recomendacion);

        LibrosDAO dao = new LibrosDAO();
        try{
            boolean sucess = dao.insertLibro(libro);
            if(sucess){
                response.sendRedirect("../listbooks/listbooks.jsp");
            } else{
                response.sendRedirect("../error.jsp");
            }
        }catch(SQLException e){
            e.printStackTrace();

            response.sendRedirect("../error.jsp");
        }
        }
    }


