<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario - UV LIBRARY</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <div class="back-button">
        <a href="../userC/userIN.jsp" class="back-link">Atrás</a>
    </div>
    <h1>Registro de Usuario</h1>

    <!-- Notificación de registro exitoso -->
    <%
        String success = request.getParameter("success");
        if ("true".equals(success)) {
    %>
    <div class="notification success">
        Registro completado con éxito.
    </div>
    <%
    } else if ("false".equals(success)) {
    %>
    <div class="notification error">
        Hubo un problema con el registro. Por favor, inténtelo de nuevo.
    </div>
    <%
        }
    %>

    <form action="RegisterServlet" method="post">
        <div class="form-group">
            <label for="Nombre">Nombre Completo:</label>
            <input type="text" id="Nombre" name="Nombre" required>
        </div>

        <div class="form-group">
            <label for="NombreUsuario">Nombre de Usuario:</label>
            <input type="text" id="NombreUsuario" name="NombreUsuario" required>
        </div>

        <div class="form-group">
            <label for="Email">Correo Electrónico:</label>
            <input type="email" id="Email" name="Email" required>
        </div>

        <div class="form-group">
            <label for="FechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" id="FechaNacimiento" name="FechaNacimiento" required>
        </div>

        <div class="form-group">
            <label for="Genero">Género:</label>
            <select id="Genero" name="Genero" required>
                <option value="1">Mujer</option>
                <option value="2">Hombre</option>
            </select>
        </div>

        <div class="form-group">
            <label for="Contrasena">Contraseña:</label>
            <input type="password" id="Contrasena" name="Contrasena" required>
        </div>

        <div class="form-group">
            <input type="submit" value="Registrarse" class="submit-button">
        </div>
    </form>
</div>
</body>
</html>


