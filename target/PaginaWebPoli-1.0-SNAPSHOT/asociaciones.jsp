<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asociaciones EPN</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container my-4">
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-4">Asociaciones EPN</h2>

        <!-- Menú con los nombres de las asociaciones -->
        <div class="menu-horizontal">
            <c:forEach var="item" items="${asociaciones}">
                <div class="menu-item">
                    <form method="get" action="asociaciones">
                        <input type="hidden" name="asociacion" value="${item.nombre}" />
                        <button type="submit" class="btn btn-primary">${item.nombre}</button>
                    </form>
                </div>
            </c:forEach>
        </div>

        <!-- Mostrar la información de la asociación seleccionada -->
        <c:if test="${asociacionSeleccionada != null}">
            <div class="asociacion-info mt-4">
                <h3>${asociacionSeleccionada.nombre}</h3>
                <c:if test="${asociacionSeleccionada.descripcion != null}">
                    <p><strong>Descripción:</strong> ${asociacionSeleccionada.descripcion}</p>
                </c:if>

                <c:if test="${asociacionSeleccionada.planesEstudiantiles != null}">
                    <h4>Planes Estudiantiles:</h4>
                    <ul>
                        <c:forEach var="plan" items="${asociacionSeleccionada.planesEstudiantiles}">
                            <li>${plan.nombre}: ${plan.descripcion}
                                <form method="get" action="asociaciones">
                                    <input type="hidden" name="asociacion" value="${asociacionSeleccionada.nombre}" />
                                    <input type="hidden" name="accion" value="mostrarCuenta" />
                                    <button type="submit" class="btn btn-info">Comprar</button>
                                </form>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>

                <!-- Mostrar la cuenta bancaria si se seleccionó la opción "Comprar" -->
                <c:if test="${mostrarCuentaBancaria}">
                    <div class="cuenta-bancaria mt-4">
                        <strong>Información de cuenta bancaria:</strong>
                        <p>${asociacionSeleccionada.cuentaBancaria}</p>
                    </div>
                </c:if>
            </div>
        </c:if>
    </div>
</div>




<!-- jQuery y Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
