
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Administrador - UV LIBRARY</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="sidebar">
  <h2>Menú Admin</h2>
  <!-- Lista de opciones de la barra lateral -->
  <ul>
    <li><a href="#">Dashboard</a></li>
    <li><a href="#">Perfil</a></li>
    <li><a href="#">Configuraciones</a></li>
    <li><a href="../login/logout.jsp">Cerrar Sesión</a></li>
  </ul>
</div>

<div class="header">
  <h1>Panel de Administración - UV LIBRARY</h1>
</div>

<div class="container">
  <!-- Sección de botones de administración -->
  <div class="admin-buttons">
    <h2>Gestión de la Biblioteca</h2>
    <button onclick="location.href='manage_books.jsp'">Administrar Libros</button>
    <button onclick="location.href='manage_users.jsp'">Administrar Usuarios</button>
  </div>
</div>

</body>
</html>
