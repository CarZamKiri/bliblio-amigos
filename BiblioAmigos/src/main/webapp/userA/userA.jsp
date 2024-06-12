<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cliente_Page1 - UV LIBRARY</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="sidebar">
    <h2>Menu</h2>
    <!-- Lista de opciones de la barra lateral -->
    <ul>
        <li><a href="../listbooks/listbook.jsp">Lista de libros </a></li>
        <li><a href="#">Categorias</a></li>
        <li><a href="../userProfile/userProfile.jsp">Perfil </a></li>
    </ul>
</div>

<div class="header">
    <h1>UV LIBRARY</h1>
    <div class="user-info">
        <%
            String username = (String) session.getAttribute("username");
            if (username != null) {
        %>
        <p>Bienvenido, <%= username %></p>
        <%
            }
        %>
    </div>
</div>

<div class="container">
    <!-- Barra de biblioteca personalizada -->
    <div class="library-bar">
        <h2>Biblioteca Personalizada</h2>
        <a href="more_books.jsp" class="view-more-button">Ver Más</a>
    </div>

    <!-- Lista de libros -->
    <div class="book-list">
        <%
            // Conexión a la base de datos
            String url = "jdbc:postgresql://localhost:5432/UV_Library3";
            String user = "postgres";
            String password = "root";
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();
                String query = "SELECT Titulo, Autor, ISBN FROM Libros";
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String titulo = rs.getString("Titulo");
                    String autor = rs.getString("Autor");
                    String isbn = rs.getString("ISBN");
        %>
        <div class="book-item">
            <h3><%= titulo %></h3>
            <p><%= autor %></p>
            <p>ISBN: <%= isbn %></p>
        </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </div>
</div>

</body>
</html>
