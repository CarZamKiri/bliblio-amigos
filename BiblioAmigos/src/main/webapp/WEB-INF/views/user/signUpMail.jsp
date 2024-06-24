<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro - UV LIBRARY</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
    $(document).ready(function() {
      $("#email").on('blur', function() {
        var email = $(this).val();
        $.ajax({
          url: "${pageContext.request.contextPath}/checkEmail",
          type: "POST",
          data: {email: email},
          success: function(response) {
            if (response === "exists") {
              $("#passwordField").hide();
              alert("Correo ya registrado.");
            } else {
              $("#passwordField").show();
            }
          }
        });
      });

      $("#registerForm").on('submit', function(event) {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        if (password !== confirmPassword) {
          event.preventDefault();
          alert("Las contraseñas no coinciden.");
        }
      });
    });
  </script>
</head>
<body>
<nav>
  <jsp:include page="/WEB-INF/views/common/navbar.jsp" />
</nav>
<div class="containerForm">
  <h1>UV LIBRARY</h1>
  <form id="registerForm" action="${pageContext.request.contextPath}/registerServlet" method="post">
    <input type="text" id="email" name="email" placeholder="Correo Electrónico" required><br>
    <div id="passwordField" style="display:none;">
      <input type="password" id="password" name="password" placeholder="Contraseña" required><br>
      <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirmar Contraseña" required><br>
      <input type="text" name="name" placeholder="Nombre" required><br>
      <input type="text" name="lastName" placeholder="Apellido Paterno" required><br>
      <input type="text" name="secondSurname" placeholder="Apellido Materno"><br>
      <input type="text" name="username" placeholder="Nombre de Usuario" required><br>
      <input type="date" name="date" placeholder="Fecha de Nacimiento" required><br>
      <select name="gender" required>
        <option value="1">Masculino</option>
        <option value="2">Femenino</option>
        <option value="3">Otro</option>
      </select><br>
      <button type="submit">Crear Cuenta</button>
    </div>
  </form>
  <a href="#">¿Perdiste tu contraseña?</a><br>
  <p>¿Eres nuevo?</p>
  <form action="${pageContext.request.contextPath}/WEB-INF/views/user/register.jsp">
    <input type="submit" value="Registrarse">
  </form>
</div>
</body>
</html>
