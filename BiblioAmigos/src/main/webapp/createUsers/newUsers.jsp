
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro de Usuario - UV LIBRARY</title>
  <link rel="stylesheet" href="styles_a.css">
</head>
<body>
<div class="back-button">
  <a action="user_C/user_in.jsp" class="back-link">Atrás</a>
</div>
<div class="container">
  <h1>Registro de Usuario</h1>
  <form action="register.jsp" method="post">
    <label for="Nombre">Nombre Completo:</label>
    <input type="text" id="Nombre" name="Nombre" required><br>

    <label for="NombreUsuario">Nombre de Usuario:</label>
    <input type="text" id="NombreUsuario" name="NombreUsuario" required><br>

    <label for="Email">Correo Electrónico:</label>
    <input type="email" id="Email" name="Email" required><br>

    <label for="Contrasena">Contraseña:</label>
    <input type="password" id="Contrasena" name="Contrasena" required><br>

    <input type="submit" value="Registrarse">
  </form>
</div>
</body>
</html>
