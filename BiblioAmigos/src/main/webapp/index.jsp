<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UV LIBRARY</title>
    <style>
        .aviso {
            background-color: #4CAF50; /* Verde */
            color: white;
            padding: 16px;
            text-align: center;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1;
        }

        button {
            background-color: #008CBA; /* Azul */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 50px; /* Espacio para separar el botón del aviso */
            cursor: pointer;
        }
    </style>
    <script>
        // Función para realizar la conexión a la base de datos
        function conectarBD() {
            fetch('ConexionServlet') // Llama a un servlet que maneja la conexión a la base de datos
                .then(response => {
                    if (response.ok) {
                        console.log('Conexión establecida');
                        // Aquí puedes agregar cualquier lógica adicional que desees ejecutar después de la conexión exitosa
                    } else {
                        console.error('Error al conectar a la base de datos');
                    }
                })
                .catch(error => {
                    console.error('Error al conectar a la base de datos:', error);
                });
        }

        // Función que se ejecuta cuando la página se carga completamente
        window.onload = function() {
            conectarBD(); // Llama a la función para conectar a la base de datos cuando la página se carga

            // Muestra el aviso de conexión exitosa durante 10 segundos
            setTimeout(function() {
                var aviso = document.getElementById("aviso-conexion");
                aviso.style.display = "none"; // Oculta el aviso después de 10 segundos
            }, 10000);
        };
    </script>
</head>
<body>
<div id="aviso-conexion" class="aviso">Conexión establecida correctamente</div>
<button onclick="window.location.href = 'userC/userIN.jsp'">Ir a otra página</button>
</body>
</html>
