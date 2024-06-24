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
    <% String error = request.getParameter("error"); %>
    <% if (error != null) { %>
    <p style="color:red;">Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.</p>
    <% } %>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <input type="text" name="username" placeholder="Correo Electrónico" required><br>
        <input type="password" name="password" placeholder="Contraseña" required><br>
        <button type="submit">Iniciar Sesión</button>
    </form>
    <a href="#">¿Perdiste tu contraseña?</a><br>
    <p>¿Eres nuevo?</p>
    <form action="${pageContext.request.contextPath}/register.jsp">
        <input type="submit" value="Registrarse">
    </form>
</div>
</body>
</html>
