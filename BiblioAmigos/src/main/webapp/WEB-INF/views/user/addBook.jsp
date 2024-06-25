<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Libro - UV LIBRARY</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
<div class="container">
    <h1>Agregar Libro</h1>
    <form action="/newBookServlet" method="POST">
        <div class="form-group">
            <label for="title"><i class="fas fa-book"></i> Título:</label>
            <input type="text" id="title" name="title" required>
        </div>

        <div class="form-group">
            <label for="author"><i class="fas fa-user"></i> Autor:</label>
            <select id="author" name="author" required></select>
            <button type="button" id="addAutorBtn"><i class="fas fa-plus"></i> Agregar Autor</button>
        </div>

        <div class="form-group">
            <label for="genre"><i class="fas fa-tag"></i> Género:</label>
            <select id="genre" name="genre" required></select>
            <button type="button" id="addGeneroBtn"><i class="fas fa-plus"></i> Agregar Género</button>
        </div>

        <div class="form-group">
            <label for="publicationDate"><i class="fas fa-calendar-alt"></i> Año de Publicación:</label>
            <input type="number" id="publicationDate" name="publicationDate" required>
        </div>

        <div class="form-group">
            <label for="publisher"><i class="fas fa-building"></i> Editorial:</label>
            <select id="publisher" name="publisher" required></select>
            <button type="button" id="addEditorialBtn"><i class="fas fa-plus"></i> Agregar Editorial</button>
        </div>

        <div class="form-group">
            <label for="isbn"><i class="fas fa-barcode"></i> ISBN:</label>
            <input type="text" id="isbn" name="isbn" required>
        </div>

        <div class="form-group">
            <label for="category"><i class="fas fa-list-alt"></i> Categoría:</label>
            <select id="category" name="category" required></select>
            <button type="button" id="addCategoriaBtn"><i class="fas fa-plus"></i> Agregar Categoría</button>
        </div>

        <div class="form-group">
            <button type="submit"><i class="fas fa-plus"></i> Agregar Libro</button>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        function loadCatalog(field, selectElement) {
            $.ajax({
                url: 'loadCatalogsServlet',
                data: { field: field },
                success: function(data) {
                    selectElement.empty();
                    data.forEach(function(item) {
                        selectElement.append($('<option>', {
                            value: item,
                            text: item
                        }));
                    });
                }
            });
        }

        function addCatalogItem(field, value, selectElement) {
            $.ajax({
                url: 'addCatalogItemServlet',
                method: 'POST',
                data: { field: field, value: value },
                success: function() {
                    loadCatalog(field, selectElement);
                }
            });
        }

        // Cargar catálogos al cargar la página
        loadCatalog('author', $('#author'));
        loadCatalog('genre', $('#genre'));
        loadCatalog('publisher', $('#publisher'));
        loadCatalog('category', $('#category'));

        // Manejar la adición de nuevos elementos
        $('#addAutorBtn').click(function() {
            const newAuthor = prompt('Ingrese el nombre del nuevo autor:');
            if (newAuthor) {
                addCatalogItem('author', newAuthor, $('#author'));
            }
        });

        $('#addGeneroBtn').click(function() {
            const newGenre = prompt('Ingrese el nombre del nuevo género:');
            if (newGenre) {
                addCatalogItem('genre', newGenre, $('#genre'));
            }
        });

        $('#addEditorialBtn').click(function() {
            const newPublisher = prompt('Ingrese el nombre de la nueva editorial:');
            if (newPublisher) {
                addCatalogItem('publisher', newPublisher, $('#publisher'));
            }
        });

        $('#addCategoriaBtn').click(function() {
            const newCategory = prompt('Ingrese el nombre de la nueva categoría:');
            if (newCategory) {
                addCatalogItem('category', newCategory, $('#category'));
            }
        });
    });
</script>

</body>
</html>
