<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poliweb.modelo.Ruta" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Polibus - Portal Estudiantil EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- Incluimos jQuery -->
</head>

<body class="bg-gray-50">
<!-- Contenido de la página -->
<div class="space-y-8">
    <!-- Contenedor principal -->
    <div class="container mx-auto px-4">
        <!-- Encabezado -->
        <div class="bg-white p-6 rounded-lg shadow-lg">
            <h2 class="text-2xl font-bold mb-4">Polibus</h2>
            <p class="mb-4">El Polibus es el servicio de transporte para estudiantes de la EPN. Aquí puedes encontrar información sobre las rutas disponibles:</p>
            <div class="mb-4">
                <input type="text" id="searchInput" class="form-control" placeholder="Buscar ruta por nombre o paradas" onkeyup="filtrarRutas()">
            </div>

            <!-- Tabla de rutas -->
            <div class="table-responsive">
                <table class="table table-bordered" id="rutasTable">
                    <thead class="thead-light">
                    <tr>
                        <th>Ruta</th>
                        <th>Paradas</th>
                        <th>Horario</th>
                        <th>Ubicación</th>
                        <th>Mapa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${not empty rutas}">
                            <c:forEach var="ruta" items="${rutas}">
                                <tr>
                                    <td><c:out value="${ruta.nombreRuta}" /></td>
                                    <td><c:out value="${ruta.paradas}" /></td>
                                    <td><c:out value="${ruta.horario}" /></td>
                                    <td><c:out value="${ruta.ubicacion}" /></td>
                                    <td>
                                        <button class="btn btn-primary" onclick="mostrarMapa(this)" data-url="${ruta.mapaUrl}">
                                            Ver Mapa
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="3">No se encontraron rutas.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>

            <!-- Contenedor para el mapa de la ruta -->
            <div id="mapaContainer" class="my-4" style="display: none;">
                <!-- Mapa de la ruta seleccionada -->
                <h3 class="text-2xl font-bold mb-4">Mapa de la Ruta</h3>
                <iframe id="mapaRuta" width="100%" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>

                <!-- Botón para cerrar el mapa centrado y alineado verticalmente -->
                <div class="flex justify-center items-center mt-4">
                    <button class="btn btn-secondary" onclick="cerrarMapa();">
                        Cerrar Mapa
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript para filtrar las rutas -->
<script>
    function filtrarRutas() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const table = document.getElementById('rutasTable');
        const tr = table.getElementsByTagName('tr');

        for (let i = 1; i < tr.length; i++) { // Comenzar desde 1 para evitar el encabezado
            const tdNombre = tr[i].getElementsByTagName('td')[0]; // Nombre de la ruta
            const tdParadas = tr[i].getElementsByTagName('td')[1]; // Paradas

            if (tdNombre || tdParadas) {
                const txtValueNombre = tdNombre.textContent || tdNombre.innerText;
                const txtValueParadas = tdParadas.textContent || tdParadas.innerText;

                if (txtValueNombre.toLowerCase().indexOf(filter) > -1 ||
                    txtValueParadas.toLowerCase().indexOf(filter) > -1) {
                    tr[i].style.display = ""; // Mostrar la fila
                } else {
                    tr[i].style.display = "none"; // Ocultar la fila
                }
            }
        }
    }

    function mostrarMapa(button) {
        const mapaIframe = document.getElementById('mapaRuta');
        const mapaContainer = document.getElementById('mapaContainer');
        const url = button.getAttribute('data-url');

        // Cargar la URL del mapa en el iframe
        mapaIframe.src = url;

        // Mostrar el contenedor del mapa con un desvanecimiento suave
        $(mapaContainer).fadeIn(1000);

        // Hacer scroll hacia el contenedor del mapa
        mapaContainer.scrollIntoView({ behavior: 'smooth' });
    }

    function cerrarMapa() {
        const mapaContainer = document.getElementById('mapaContainer');

        // Ocultar el contenedor del mapa con un desvanecimiento suave
        $(mapaContainer).fadeOut(500);  // 500ms para el fadeOut
    }

</script>

<!-- jQuery (debe estar antes de Bootstrap JS) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>