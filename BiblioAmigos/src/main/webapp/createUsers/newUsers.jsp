<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Insertar Usuario</h1>
<form action=/newUserServlet" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="nombreUsuario">Nombre de Usuario:</label>
    <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br><br>

    <label for="genero">Género:</label>
    <select id="genero" name="genero" required>
        <option value="1">Masculino</option>
        <option value="2">Femenino</option>
        <option value="3">Otro</option>
    </select><br><br>

    <button type="submit">Insertar Usuario</button>
</form>
</body>
</html>