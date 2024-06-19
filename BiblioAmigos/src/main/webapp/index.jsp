
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UV LIBRARY</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>

<body>
<nav class>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
        <li><a href="${pageContext.request.contextPath}/signUp.jsp">Registrarse</a></li>
        <li><a href="${pageContext.request.contextPath}/aboutUs.jsp">Nosotros</a></li>
        <li><a href="${pageContext.request.contextPath}/privateLibrary.jsp">BP - Eliminar</a></li>
        <li><a href="${pageContext.request.contextPath}/adminInterface.jsp">AP - Eliminar</a></li>
        <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/login.jsp">Iniciar Sesion</a></li>
    </ul>
</nav>
<div>
    <h1 class="tituloPrincipal">UV LIBRARY</h1>
    <h2 class="recomendaciones">Recomendaciones del mes</h2>
</div>
<div class="container">
    <img src="assets/images/ElPsicoanalista.jpg" alt="Portada libro El Psicoanalista"/>
    <img src="assets/images/AliceInWonderland.jpg" alt="Portada libro Alice In Wonderland"/>
    <img src="assets/images/Hamlet.jpg" alt="Portada libro Hamlet"/>
    <img src="assets/images/RebelionEnLaGranja.jpg" alt="Portada libro Rebelion en la granja"/>
    <img src="assets/images/SoloLeveling.jpg" alt="Portada novela Solo Leveling"/>
</div>
<footer>

</footer>
</body>
</html>

