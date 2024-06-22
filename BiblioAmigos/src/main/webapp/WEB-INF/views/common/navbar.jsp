<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Menú</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<nav>
  <ul>
    <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
    <li><a href="${pageContext.request.contextPath}/addBooks/add1.jsp">Eliminar</a></li>
    <li><a href="${pageContext.request.contextPath}/signUpMail.jsp">Registrarse</a></li>
    <li><a href="${pageContext.request.contextPath}/aboutUs.jsp">Nosotros</a></li>
    <li><a href="${pageContext.request.contextPath}/privateLibrary.jsp">BP - Eliminar</a></li>
    <li><a href="${pageContext.request.contextPath}/adminInterface.jsp">AP - Eliminar</a></li>
    <li style="float:right"><a class="active" href="${pageContext.request.contextPath}/login.jsp">Iniciar Sesión</a></li>
  </ul>
</nav>
</body>
</html>
