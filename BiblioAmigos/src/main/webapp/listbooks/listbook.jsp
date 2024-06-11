<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Libros - UV LIBRARY</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <div class="back-button">
        <a href="../userC/userIN.jsp" class="back-link">Atrás</a>
    </div>
    <h1>Lista de Libros</h1>
    <div class="book-list">
        <%


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UV_Library3", "postgres", "root");
            statement = connection.createStatement();
            String sql = "SELECT Titulo, Autor, GeneroLiterario, anioPublicacion FROM Libros";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                String genero = resultSet.getString("GeneroLiterario");
                int anioPublicacion = resultSet.getInt("anioPublicacion");
    %>
        <div class="book-item">
            <h2><%= titulo %></h2>
            <p><strong>Autor:</strong> <%= autor %></p>
            <p><strong>Género:</strong> <%= genero %></p>
            <p><strong>Año de Publicación:</strong> <%= anioPublicacion %></p>
        </div>
        <%
            }
            } catch (Exception e) {
            e.printStackTrace();
            } finally {
            if (resultSet != null) try { resultSet.close(); } catch (Exception e) { }
            if (statement != null) try { statement.close(); } catch (Exception e) { }
            if (connection != null) try { connection.close(); } catch (Exception e) { }
            }

        %>
    </div>
</div>
</body>
</html>
