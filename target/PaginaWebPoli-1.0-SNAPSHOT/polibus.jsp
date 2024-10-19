<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poliweb.modelo.Ruta" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Importamos JSTL -->

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Polibus - Portal Estudiantil EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .bg-white {
            background-color: #ffffff;
        }
        .rounded-lg {
            border-radius: 0.5rem;
        }
        .shadow-lg {
            box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container my-4">
        <div class="bg-white p-6 rounded-lg shadow-lg">
            <h2 class="text-2xl font-bold mb-4">Polibus</h2>
            <p class="mb-4">El Polibus es el servicio de transporte para estudiantes de la EPN. Aquí puedes encontrar información sobre las rutas disponibles:</p>
            <div class="mb-4">
                <input type="text" id="searchInput" class="form-control" placeholder="Buscar ruta por nombre o paradas" onkeyup="filtrarRutas()">
            </div>

            <p>Total de rutas: <c:out value="${not empty rutas ? rutas.size() : 0}" /></p>

            <div class="table-responsive">
                <table class="table table-bordered" id="rutasTable">
                    <thead class="thead-light">
                        <tr>
                            <th>Nombre de la Ruta</th>
                            <th>Paradas</th>
                            <th>Horario</th>
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
    </script>

    <!-- jQuery (debe estar antes de Bootstrap JS) -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

