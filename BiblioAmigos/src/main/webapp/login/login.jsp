
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="es">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - UV LIBRARY</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <div class="back-button">
        <a href="../userC/userIN.jsp" class="back-link">Atrás</a>
    </div>
    <h1>UV LIBRARY</h1>
    <form action="#" method="post">
        <input type="text" name="username" placeholder="Nombre de Usuario" required><br>
        <input type="password" name="password" placeholder="Contraseña" required><br>
        <input type="submit" value="Iniciar Sesión"><br>
    </form>
    <a href="#">¿Perdiste tu contraseña?</a><br> <!-- Enlace para recuperar contraseña -->
    <p>¿Eres nuevo? Regístrate ahora:</p>
    <form action="create_users/newusers_1.jsp"></form>
    <input type="button" value="Registrarse">

    <!-- Botón de prueba -->
    <form action="user_C/user_in.jsp">
        <input type="submit" value="Ir a user_in.jsp">
    </form>
</div>
</body>
</html>