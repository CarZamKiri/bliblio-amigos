<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>

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
    <form action="register.jsp" method="post">
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


