
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Libro - UV LIBRARY</title>
    <link rel="stylesheet" href="../assets/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
<div class="container">
    <h1>Agregar Libro</h1>
    <form action = "${pageContext.request.contextPath}/newBookServlet/">
        <div class="form-group">
            <label for="titulo"><i class="fas fa-book"></i> Título:</label>
            <input type="text" id="titulo" name="titulo" required>
        </div>

        <div class="form-group">
            <label for="autor"><i class="fas fa-user"></i> Autor:</label>
            <input type="text" id="autor" name="autor" required>
        </div>

        <div class="form-group">
            <label for="genero"><i class="fas fa-tag"></i> Género:</label>
            <input type="text" id="genero" name="genero" required>
        </div>

        <div class="form-group">
            <label for="anioPublicacion"><i class="fas fa-calendar-alt"></i> Año de Publicación:</label>
            <input type="number" id="anioPublicacion" name="anioPublicacion" required>
        </div>

        <div class="form-group">
            <label for="editorial"><i class="fas fa-building"></i> Editorial:</label>
            <input type="text" id="editorial" name="editorial" required>
        </div>

        <div class="form-group">
            <label for="isbn"><i class="fas fa-barcode"></i> ISBN:</label>
            <input type="text" id="isbn" name="isbn" required>
        </div>

        <div class="form-group">
            <label for="recomendacion"><i class="fas fa-thumbs-up"></i> Recomendación:</label>
            <select id="recomendacion" name="recomendacion">
                <option value="true">Sí</option>
                <option value="false">No</option>
            </select>
        </div>

        <div class="form-group">
            <label for="categoria"><i class="fas fa-list-alt"></i> Categoría:</label>
            <input type="text" id="categoria" name="categoria" required>
        </div>

        <div class="form-group">
            <button type="submit"><i class="fas fa-plus"></i> Agregar Libro</button>
        </div>
    </form>
</div>
</body>
</html>
