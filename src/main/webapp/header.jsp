<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portal Estudiantil EPN</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            margin: 0;
            padding: 0;
        }
        .bg-blue-600 {
            background-color: #2563eb; /* Color azul */
        }
        .text-white {
            color: white;
        }
        .p-4 {
            padding: 1rem; /* Espaciado */
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
        }
        .flex {
            display: flex;
        }
        .justify-between {
            justify-content: space-between;
        }
        .items-center {
            align-items: center;
        }
        .mr-2 {
            margin-right: 0.5rem; /* Margen derecho */
        }
        .text-2xl {
            font-size: 1.5rem; /* Tamaño de texto */
        }
        .font-bold {
            font-weight: bold; /* Negrita */
        }
        /* Estilos personalizados para enlaces */
        .nav-link {
            color: white; /* Color inicial */
            transition: color 0.3s ease; /* Transición suave */
            text-decoration: none; /* Sin subrayado */
        }
        .nav-link:hover {
            color: #93c5fd; /* Color azul claro al pasar el mouse */
        }
        /* Quitar puntos de la lista */
        .nav {
            list-style-type: none; /* Quita los puntos */
            padding: 0; /* Quita el padding */
            margin: 0; /* Quita el margin */
            display: flex;
            gap: 1rem; /* Espacio entre los elementos */
        }
    </style>
</head>
<body>
<header class="bg-blue-600 text-white p-4">
    <div class="container flex justify-between items-center">
        <div class="flex items-center">
            <img src="${pageContext.request.contextPath}/imagenes/buho.webp" alt="Búho" class="mr-2" width="32" height="32"/>
            <h1 class="text-2xl font-bold">Portal Estudiantil EPN</h1>
        </div>
        <nav>
            <ul class="nav">
                <!-- Redirige a los controladores -->
                <li><a href="${pageContext.request.contextPath}/Inicio" class="nav-link">Inicio</a></li>
                <li><a href="${pageContext.request.contextPath}/Servicios" class="nav-link">Servicios</a></li>
                <li><a href="${pageContext.request.contextPath}/Contacto" class="nav-link">Contacto</a></li>
            </ul>
        </nav>
    </div>
</header>

<script>

</script>
</body>
</html>
