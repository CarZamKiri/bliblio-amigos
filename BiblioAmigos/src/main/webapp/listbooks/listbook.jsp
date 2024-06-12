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
    <script>
        // Función para buscar libros
        function searchBooks() {
            var input, filter, bookList, bookItems, title, i, txtValue;
            input = document.getElementById('searchInput');
            filter = input.value.toUpperCase();
            bookList = document.getElementById("bookList");
            bookItems = bookList.getElementsByClassName('book-item');

            for (i = 0; i < bookItems.length; i++) {
                title = bookItems[i].getElementsByTagName("h2")[0];
                txtValue = title.textContent || title.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    bookItems[i].style.display = "";
                } else {
                    bookItems[i].style.display = "none";
                }
            }
        }

        // Función para mostrar más información del libro
        function showBookInfo(title, author, genre, year, isbn) {
            alert('Título: ' + title + '\nAutor: ' + author + '\nGénero: ' + genre + '\nAño de Publicación: ' + year + '\nISBN: ' + isbn);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="back-button">
        <a href="../userC/userIN.jsp" class="back-link">Atrás</a>
    </div>
    <h1>Lista de Libros</h1>
    <div class="search-bar">
        <input type="text" id="searchInput" onkeyup="searchBooks()" placeholder="Buscar libros...">
    </div>
    <div class="book-list" id="bookList">
        <%
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UV_Library3", "postgres", "root");
                statement = connection.createStatement();
                String sql = "SELECT Libros.Titulo, Autores.nombre AS Autor, generoLit.nombre AS Genero, Libros.anioPublicacion, Libros.ISBN FROM Libros INNER JOIN Autores ON Libros.Autor = Autores.Id_autor INNER JOIN generoLit ON Libros.GeneroLiterario = generoLit.Id_genero";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String titulo = resultSet.getString("Titulo");
                    String autor = resultSet.getString("Autor");
                    String genero = resultSet.getString("Genero");
                    int anioPublicacion = resultSet.getInt("anioPublicacion");
                    String isbn = resultSet.getString("ISBN");
        %>
        <div class="book-item" onclick="showBookInfo('<%= titulo %>', '<%= autor %>', '<%= genero %>', <%= anioPublicacion %>, '<%= isbn %>')">
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
    <a href="../addBooks/add1.jsp" class="add-book-button">
        <span class="add-book-icon">+</span> Agregar libros
    </a>
</div>
</body>
</html>
