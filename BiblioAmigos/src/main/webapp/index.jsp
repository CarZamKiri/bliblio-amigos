
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

<jsp:include page="/WEB-INF/views/common/navbar.jsp" />

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

