
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agregar Usuario - UV LIBRARY</title>
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
<div class="container">
  <h1>Agregar Usuario</h1>
  <form>
    <div class="form-group">
      <label for="nombre"><i class="fas fa-user"></i> Nombre:</label>
      <input type="text" id="nombre" name="nombre" required>
    </div>

    <div class="form-group">
      <label for="nombreUsuario"><i class="fas fa-user-tag"></i> Nombre de Usuario:</label>
      <input type="text" id="nombreUsuario" name="nombreUsuario" required>
    </div>

    <div class="form-group">
      <label for="contrasena"><i class="fas fa-lock"></i> Contraseña:</label>
      <input type="password" id="contrasena" name="contrasena" required>
    </div>

    <div class="form-group">
      <label for="email"><i class="fas fa-envelope"></i> Email:</label>
      <input type="email" id="email" name="email" required>
    </div>

    <div class="form-group">
      <label for="estado"><i class="fas fa-info-circle"></i> Estado:</label>
      <select id="estado" name="estado">
        <option value="activo">Activo</option>
        <option value="baja">Baja</option>
        <option value="suspendido">Suspendido</option>
      </select>
    </div>

    <div class="form-group">
      <label for="tipo"><i class="fas fa-users-cog"></i> Tipo de Usuario:</label>
      <select id="tipo" name="tipo">
        <option value="admin">Admin</option>
        <option value="cliente">Cliente</option>
      </select>
    </div>

    <div class="form-group">
      <button type="submit"><i class="fas fa-plus"></i> Agregar Usuario</button>
    </div>
  </form>
</div>
</body>
</html>
