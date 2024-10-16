<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asociaciones EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .menu-horizontal {
            overflow-x: auto;
            white-space: nowrap;
            margin-bottom: 20px;
        }
        .menu-horizontal .menu-item {
            display: inline-block;
            margin-right: 15px;
        }
        .menu-item button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .menu-item button:hover {
            background-color: #0056b3;
        }
        .asociacion-info {
            display: none;
            margin-top: 20px;
        }
        .cuenta-bancaria {
            display: none;
            margin-top: 10px;
            background-color: #f8f9fa;
            padding: 10px;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
<div class="container my-4">
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-4">Asociaciones EPN</h2>

        <!-- Menú con los nombres de las asociaciones -->
        <div class="menu-horizontal">
            <c:forEach var="item" items="${asociaciones}">
                <div class="menu-item">
                    <button onclick="showAsociacion('${item.nombre}')">${item.nombre}</button>
                </div>
            </c:forEach>
        </div>

        <!-- Información de las asociaciones (oculta por defecto) -->
        <c:forEach var="item" items="${asociaciones}">
            <div id="${item.nombre}" class="asociacion-info">
                <h3>${item.nombre}</h3>
                <c:if test="${item.descripcion != null}">
                    <p><strong>Descripción:</strong> ${item.descripcion}</p>
                </c:if>

                <!-- Mostrar planes si existen -->
                <c:if test="${item.planesEstudiantiles != null}">
                    <h4>Planes Estudiantiles:</h4>
                    <ul>
                        <c:forEach var="plan" items="${item.planesEstudiantiles}">
                            <li>${plan.nombre}: ${plan.descripcion}
                                <button onclick="showCuentaBancaria('${item.nombre}')">Comprar</button>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>

                <!-- Información de cuenta bancaria (oculta por defecto) -->
                <div id="cuenta-${item.nombre}" class="cuenta-bancaria">
                    <strong>Información de cuenta bancaria para depósitos:</strong>
                    <p><strong>Banco:</strong> Banco Pichincha</p>
                    <p><strong>Número de cuenta:</strong> 1234567890</p>

                    <div id="qr-code-${item.nombre}" style="display: none;">
                        <img src="./imagenes/OIP.jpeg" alt="Código QR para pago" width="150" height="150">
                    </div>
                    <h5>imagen</h5>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    // Mostrar la información de la asociación seleccionada
    function showAsociacion(nombreAsociacion) {
        const asociacionesInfo = document.querySelectorAll('.asociacion-info');
        asociacionesInfo.forEach(info => info.style.display = 'none');

        const asociacionDiv = document.getElementById(nombreAsociacion);
        if (asociacionDiv) {
            asociacionDiv.style.display = 'block';
        }
    }

    // Mostrar la cuenta bancaria cuando se selecciona "Comprar"
    function showCuentaBancaria(nombreAsociacion) {
        const cuentaDiv = document.getElementById('cuenta-' + nombreAsociacion);
        if (cuentaDiv) {
            cuentaDiv.style.display = 'block';
        }
        if (qrCodeDiv) {
            qrCodeDiv.style.display = 'block';
        }
    }
</script>

<!-- jQuery y Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
