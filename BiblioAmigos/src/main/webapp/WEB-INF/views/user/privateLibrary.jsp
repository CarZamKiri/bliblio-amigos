<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 19/06/2024
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mi Biblioteca Privada</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

<%
  if (session == null || session.getAttribute("user") == null) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
    return;
  }
%>

<nav class>
  <ul>
    <li><a href="${pageContext.request.contextPath}/logoutServlet">Cerrar Sesion</a></li>
    <li><a href="${pageContext.request.contextPath}/addBook.jsp">Agregar Libro</a></li>
    <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/profile.jsp">Mi perfil</a></li>
  </ul>
</nav>

<div class="options-bar">
  <button class="view-realtime"><i class="fas fa-clock"></i> Vista en Tiempo Real</button>
  <button class="add-book"><i class="fas fa-plus"></i> Agregar Libro</button>
  <div class="search-container">
    <input type="text" placeholder="Buscar libro...">
    <button class="search-button"><i class="fas fa-search"></i></button>
  </div>
</div>

<div class="library-separator">
  <button class="tab-button active" onclick="showBooks('read')">Leídos</button>
  <button class="tab-button" onclick="showBooks('unread')">No Leídos</button>
</div>

<div class="book-list" id="read-books">
  <!-- Ejemplo de libro leído -->
  <div class="book-item">
    <img src="book_cover.jpg" alt="Book Cover">
    <h3>Título</h3>
    <p>Autor</p>
    <p>ISBN:</p>
    <div class="book-actions">
      <button class="review-button"><i class="fas fa-pencil-alt"></i> Hacer Reseña</button>
      <button class="rate-button"><i class="fas fa-star"></i> Calificar</button>
    </div>
  </div>
</div>

<div class="book-list" id="unread-books" style="display: none;">
  <!-- Ejemplo de libro no leído -->
  <div class="book-item">
    <img src="book_cover.jpg" alt="Book Cover">
    <h3>Título</h3>
    <p>Autor</p>
    <p>ISBN:</p>
    <div class="book-actions">
      <button class="review-button"><i class="fas fa-pencil-alt"></i> Hacer Reseña</button>
      <button class="rate-button"><i class="fas fa-star"></i> Calificar</button>
    </div>
  </div>
</div>

<script>
  function showBooks(type) {
    var readBooks = document.getElementById('read-books');
    var unreadBooks = document.getElementById('unread-books');
    var tabButtons = document.querySelectorAll('.tab-button');

    if (type === 'read') {
      readBooks.style.display = 'flex';
      unreadBooks.style.display = 'none';
      tabButtons[0].classList.add('active');
      tabButtons[1].classList.remove('active');
    } else {
      readBooks.style.display = 'none';
      unreadBooks.style.display = 'flex';
      tabButtons[0].classList.remove('active');
      tabButtons[1].classList.add('active');
    }
  }
</script>

</body>
</html>
