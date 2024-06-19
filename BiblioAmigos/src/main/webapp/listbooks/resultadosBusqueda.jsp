<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados de Búsqueda</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="navbar">
  <ul>
    <li><a href="listbooks/listbook.jsp">Lista de libros</a></li>
    <li><a href="#">Categorías</a></li>
    <li><a href="userProfile/userProfile.jsp">Perfil</a></li>
    <li><a href="login/login.jsp">Iniciar sesión</a></li>
    <li><a href="createUsers/newUsers.jsp">Registrarse</a></li>
  </ul>
</div>

<div class="search-container">
  <form action="searchBookServlet" method="get" class="search-form">
    <input type="text" name="query" placeholder="Buscar por título o ISBN" required>
    <button type="submit">Buscar</button>
  </form>
</div>

<div class="container">
  <h2>Resultados de Búsqueda</h2>

  <c:forEach var="book" items="${requestScope.books}">
    <div class="book">
      <h3>${book.title}</h3>
      <p>Autor: ${book.author}</p>
      <p>ISBN: ${book.isbn}</p>
      <p>Descripción: ${book.description}</p>
      <p>...</p>
    </div>
  </c:forEach>
</div>

</body>
</html>
