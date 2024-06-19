<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 19/06/2024
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UV LIBRARY Registro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">

</head>
<body>
<nav class>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
        <li><a href="${pageContext.request.contextPath}/signUp.jsp">Registrarse</a></li>
        <li><a href="${pageContext.request.contextPath}/aboutUs.jsp">Nosotros</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/login.jsp">Iniciar Sesion</a></li>
    </ul>
</nav>

<div class="containerForm">
    <h1>Registrarme</h1>
    <form action="" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="nombre">Nombre(s):</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="nombre">Apellido Paterno:</label>
        <input type="text" id="apellidop" name="nombre" required><br><br>

        <label for="nombre">Apellido Materno:</label>
        <input type="text" id="apellidom" name="nombre" required><br><br>

        <label for="nombreUsuario">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>

        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br><br>

        <label for="genero">Género:</label>
        <select id="genero" name="genero" required>
            <option value="1">Masculino</option>
            <option value="2">Femenino</option>
            <option value="3">Otro</option>
        </select><br><br>

        <button type="submit">Crear Cuenta</button>
    </form>
</div>
</body>
</html>
