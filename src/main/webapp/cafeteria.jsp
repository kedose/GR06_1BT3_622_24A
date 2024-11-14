<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cafetería EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container my-4">
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-4">Cafetería EPN</h2>
        <p class="mb-4">Disfruta de nuestro variado menú en la cafetería de la universidad:</p>

        <div class="row">
            <div class="col-md-6">
                <div class="card mb-4" onclick="mostrarMenu('Desayuno')">
                    <div class="card-header">Desayuno</div>
                    <div class="card-body">
                        <p>Horario de servicio: 7:00 AM - 10:00 AM</p>
                        <ul id="desayuno-list" class="list-group d-none">
                            <%-- Los elementos de la lista de desayuno se agregarán aquí --%>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card mb-4" onclick="mostrarMenu('Almuerzo')">
                    <div class="card-header">Almuerzo</div>
                    <div class="card-body">
                        <p>Horario de servicio: 12:00 PM - 3:00 PM</p>
                        <ul id="almuerzo-list" class="list-group d-none">
                            <%-- Los elementos de la lista de almuerzo se agregarán aquí --%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function mostrarMenu(tipoMenu) {
        const listaId = tipoMenu.toLowerCase() + '-list';
        const lista = document.getElementById(listaId);

        if (lista.classList.contains('d-none')) {
            // Obtener los elementos del menú de la cafetería mediante AJAX
            fetch('cafeteria?tipoMenu=' + tipoMenu)
                .then(response => response.json())
                .then(data => {
                    lista.innerHTML = ''; // Limpiar la lista antes de agregar elementos

                    data.forEach(item => {
                        const li = document.createElement('li');
                        li.className = 'list-group-item';
                        li.innerHTML = `<b>${item.nombreMenu}</b><br>${item.descripcionMenu}<br>Precio: ${item.precio}`;
                        lista.appendChild(li);
                    });

                    lista.classList.remove('d-none'); // Mostrar la lista
                })
                .catch(error => console.error('Error al obtener el menú:', error));
        } else {
            lista.classList.add('d-none'); // Ocultar la lista
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
