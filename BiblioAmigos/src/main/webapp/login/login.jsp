<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
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
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean loginError = false;

        if (username != null && password != null) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UV_Library3", "postgres", "root");

                String sql = "SELECT * FROM Usuarios WHERE nombreUsuario = ? AND ID IN (SELECT ID FROM Contrasenas WHERE Contrasena = ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Almacenar el nombre de usuario en la sesión
                    session.setAttribute("username", username);
                    response.sendRedirect("../userA/userA.jsp");
                } else {
                    loginError = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                loginError = true;
            } finally {
                if (resultSet != null) try { resultSet.close(); } catch (Exception e) { }
                if (preparedStatement != null) try { preparedStatement.close(); } catch (Exception e) { }
                if (connection != null) try { connection.close(); } catch (Exception e) { }
            }
        }
    %>
    <% if (loginError) { %>
    <p style="color:red;">Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.</p>
    <% } %>
    <form action="login.jsp" method="post">
        <input type="text" name="username" placeholder="Nombre de Usuario" required><br>
        <input type="password" name="password" placeholder="Contraseña" required><br>
        <input type="submit" value="Iniciar Sesión"><br>
    </form>
    <a href="#">¿Perdiste tu contraseña?</a><br>
    <p>¿Eres nuevo? Regístrate ahora:</p>
    <form action="create_users/newusers_1.jsp">
        <input type="submit" value="Registrarse">
    </form>
    <form action="user_C/user_in.jsp">
        <input type="submit" value="Ir a user_in.jsp">
    </form>
</div>
</body>
</html>
