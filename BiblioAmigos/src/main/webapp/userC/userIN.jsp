
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li><a href="#">Lista de libros </a></li>
        <li><a href="#">Categorias</a></li>
        <li><a href="user_perfil/user_per.jsp">Perfil </a></li>
        <li><a href="#">Reportes </a></li>
        <li><a href="create_users/newuser.jsp">Registrarse</a></li>
    </ul>
</div>

<div class="header">
    <h1>UV LIBRARY</h1>
</div>

<div class="container">
    <!-- Barra de biblioteca personalizada -->
    <div class="library-bar">
        <h2>Biblioteca Personalizada</h2>
        <a href="more_books.jsp" class="view-more-button">Ver Más</a>
    </div>

    <!-- Lista de libros -->
    <div class="book-list">
        <div class="book-item">
            <img src="book_cover1.jpg" alt="Book Cover">
            <h3>Título del Libro 1</h3>
            <p>Autor 1</p>
        </div>
        <div class="book-item">
            <img src="book_cover2.jpg" alt="Book Cover">
            <h3>Título del Libro 2</h3>
            <p>Autor 2</p>
        </div>
        <!-- Añadir más elementos de libros aquí -->
    </div>
</div>

</body>
</html>
