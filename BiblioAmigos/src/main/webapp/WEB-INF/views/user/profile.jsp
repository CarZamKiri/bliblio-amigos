<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 19/06/2024
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil de Usuario - UV LIBRARY</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<nav class>
  <ul>
    <li><a href="${pageContext.request.contextPath}/index.jsp">Cerrar Sesion</a></li>
    <li><a href="${pageContext.request.contextPath}/signUp.jsp">Registrarse</a></li>
    <li><a href="">Nosotros</a></li>
    <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/profile.jsp">Mi perfil</a></li>
  </ul>
</nav>
<div class="containerForm">

  <div class="profile-card">
    <div class="profile-header">
      <img src="imagenes/perfil.jpg" alt="Foto de Perfil" class="profile-picture">
      <h1>Nombre de Usuario</h1>
      <p class="bio">Biografía del usuario. Aquí puedes escribir algo sobre ti.</p>
      <p class="interests">Intereses: Lectura, Ciencia Ficción, Programación</p>
      <button class="edit-button">Modificar Perfil</button>
      <button class="history-button">Historial de Libros Leídos</button>
    </div>
    <div class="profile-body">
      <div class="profile-info">
        <label>Nombre Completo:</label>
        <p>Nombre de Usuario</p>
      </div>
      <div class="profile-info">
        <label>Nombre de Usuario:</label>
        <p>NombreUsuario</p>
      </div>
      <div class="profile-info">
        <label>Email:</label>
        <p>Correo Electrónico</p>
      </div>
    </div>
  </div>
</div>
</body>
</html>
