<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 19/06/2024
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Panel de Administrador</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<nav class>
  <ul>
    <li><a href="#" onclick="showProfile()"><i class="fas fa-user"></i> Perfil</a></li>
    <li><a href="#" onclick="showClientManagement()"><i class="fas fa-users"></i> Manejo de Clientes</a></li>
    <li><a href="#" onclick="showBookManagement()"><i class="fas fa-book"></i> Manejo de Libros</a></li>
    <li><a href="#" onclick="showRequests()"><i class="fas fa-envelope"></i> Solicitudes</a></li>
    <li><a href="${pageContext.request.contextPath}/index.jsp">Cerrar Sesion</a></li>
    <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/profile.jsp">Mi perfil</a></li>
  </ul>
</nav>



<div class="main-content">
  <div class="toolbar" id="toolbar">
    <!-- Toolbar content changes based on selected option -->
  </div>

  <div class="content" id="content">
    <!-- Main content changes based on selected option -->
  </div>
</div>

<script>
  function showProfile() {
    document.getElementById('toolbar').innerHTML = '<button onclick="goToProfile()">Ir al Perfil</button>';
    document.getElementById('content').innerHTML = '<h2>Perfil de Administrador</h2><p>Contenido del perfil del administrador.</p>';
  }

  function showClientManagement() {
    document.getElementById('toolbar').innerHTML = `
                <button onclick="addClient()">Agregar Cliente</button>
                <button onclick="deleteClient()">Eliminar Cliente</button>
                <button onclick="showActiveClients()">Lista de Activos</button>
                <button onclick="showSuspendedClients()">Lista de Suspendidos</button>
                <button onclick="modifyClient()">Modificar Cliente</button>
            `;
    document.getElementById('content').innerHTML = '<h2>Manejo de Clientes</h2><p>Opciones para el manejo de clientes.</p>';
  }

  function showBookManagement() {
    document.getElementById('toolbar').innerHTML = `
                <button onclick="addBook()">Agregar Libro</button>
                <button onclick="deleteBook()">Eliminar Libro</button>
                <button onclick="showActiveBooks()">Lista de Activos</button>
                <button onclick="showBannedBooks()">Lista de Baneados</button>
                <button onclick="modifyBook()">Modificar Libro</button>
            `;
    document.getElementById('content').innerHTML = '<h2>Manejo de Libros</h2><p>Opciones para el manejo de libros.</p>';
  }

  function showRequests() {
    document.getElementById('toolbar').innerHTML = '<button onclick="viewMessages()">Ver Mensajes</button>';
    document.getElementById('content').innerHTML = '<h2>Solicitudes</h2><p>Vista de mensajes de clientes.</p>';
  }

  function goToProfile() {
    // Redirect to profile page
  }

  function addClient() {
    // Functionality to add a client
  }

  function deleteClient() {
    // Functionality to delete a client
  }

  function showActiveClients() {
    // Functionality to show active clients
  }

  function showSuspendedClients() {
    // Functionality to show suspended clients
  }

  function modifyClient() {
    // Functionality to modify a client
  }

  function addBook() {
    // Functionality to add a book
  }

  function deleteBook() {
    // Functionality to delete a book
  }

  function showActiveBooks() {
    // Functionality to show active books
  }

  function showBannedBooks() {
    // Functionality to show banned books
  }

  function modifyBook() {
    // Functionality to modify a book
  }

  function viewMessages() {
    // Functionality to view messages
  }
</script>
</body>
</html>

