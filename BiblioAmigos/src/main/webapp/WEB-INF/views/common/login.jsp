<%--
  Created by IntelliJ IDEA.
  User: Carlos
  Date: 19/06/2024
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - UV LIBRARY</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp" />

<div class="containerForm">

    <h1>UV LIBRARY</h1>

    <p style="color:red;">Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.</p>

    <form action="" method="post">
        <input type="text" name="username" placeholder="Correo Electronico" required><br>
        <input type="text" name="password" placeholder="Contraseña" required><br>
        <button type="submit">Iniciar Sesion</button>
    </form>

    <a href="#">¿Perdiste tu contraseña?</a><br>
    <p>¿Eres nuevo?</p>
    <form action="../createUsers/newUsers.jsp">
        <input type="submit" value="Registrarse">
    </form>
</div>
</body>
</html>
