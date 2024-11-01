<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portal Estudiantil EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        html, body {
            height: 100%; /* Asegurarse de que el body ocupe el 100% de la altura */
            margin: 0; /* Quitar márgenes por defecto */
        }

        .wrapper {
            min-height: 100%; /* Altura mínima del contenedor para ocupar toda la página */
            display: flex;
            flex-direction: column; /* Flexbox para organizar el contenido en columnas */
        }

        .content {
            flex: 1; /* Ocupa el espacio disponible entre el header y el footer */
        }

        .footer {
            background-color: #2d3748; /* Color de fondo del footer */
            color: white; /* Color del texto */
            padding: 0.001rem; /* Disminuir el espaciado */
            text-align: center; /* Centrar el texto */
            font-size: 0.875rem; /* Disminuir el tamaño del texto si es necesario */
        }

        /* Centramos el spinner en el medio de la página */
        .spinner-wrapper {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            display: none; /* Ocultarlo inicialmente */
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script>
        function showTab(tabName) {
            console.log("Cargando pestaña: " + tabName);
            let url = '';

            // Mostrar el spinner
            $('#spinner').show();

            switch (tabName) {
                case 'polibus':
                    url = '/PaginaWebPoli/buses'; // URL para cargar las rutas
                    break;
                case 'cafeteria':
                    url = '/PaginaWebPoli/cafeteria'; // URL para cargar la cafetería
                    break;
                case 'asociacion':
                    url = '/PaginaWebPoli/asociaciones'; // URL para cargar asociacion
                    break;
                case 'comentarios':
                    url = '/PaginaWebPoli/comentarios'; // URL para cargar comentarios
                    break;
                case 'social':
                    url = '/PaginaWebPoli/social'; // URL para cargar área social
                    break;
                default:
                    console.error("Tab no reconocido: " + tabName);
                    return; // Salir si no hay URL definida
            }

            // Cargar contenido usando la URL correspondiente
            $('#tabContent').load(url, function (response, status, xhr) {
                // Ocultar el spinner cuando se carga el contenido
                $('#spinner').hide();

                if (status === "error") {
                    console.error("Error al cargar la pestaña: " + xhr.status + " " + xhr.statusText);
                    $('#tabContent').html('<div class="alert alert-danger">Error al cargar el contenido. Inténtalo nuevamente más tarde.</div>');
                }
            });
        }

        // Mostrar la pestaña por defecto al cargar la página
        $(document).ready(function () {
            showTab('polibus'); // Cargar la pestaña "polibus" al inicio
        });
    </script>
</head>
<body>
<div class="wrapper">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="showTab('polibus')" type="button">Polibus</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="showTab('cafeteria')" type="button">Cafetería</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="showTab('asociacion')" type="button">Asociacion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="showTab('comentarios')" type="button">Comentarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0);" onclick="showTab('social')" type="button">Área Social</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <main class="container my-4 content">
        <!-- Contenedor del contenido dinámico -->
        <div id="tabContent" class="tab-content" style="position: relative;">
            <!-- Spinner que se muestra mientras carga el contenido -->
            <div id="spinner" class="spinner-wrapper">
                <div class="spinner-border text-primary" role="status">
                    <span class="sr-only">Cargando...</span>
                </div>
            </div>
        </div>
    </main>

    <footer class="footer">
        <%@ include file="footer.jsp" %>
    </footer>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
