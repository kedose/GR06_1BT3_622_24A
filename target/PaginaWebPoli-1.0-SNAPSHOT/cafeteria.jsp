<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cafetería EPN</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- Incluimos jQuery -->
    <script>
        function toggleDescription(itemName) {
            const descriptionElement = document.getElementById(itemName);
            const iconElement = document.getElementById(itemName + '-icon');

            if (descriptionElement.style.display === "none" || descriptionElement.style.display === "") {
                descriptionElement.style.display = "block";
                iconElement.innerHTML = "▲"; // Change to up arrow
            } else {
                descriptionElement.style.display = "none";
                iconElement.innerHTML = "▼"; // Change to down arrow
            }
        }
    </script>
</head>
<body>
<div class="space-y-6">
    <div class="bg-blue-50 p-4 rounded-lg">
        <h2 class="text-2xl font-bold text-blue-800 mb-2">Cafetería EPN</h2>
        <p class="text-blue-600">Disfruta de nuestro variado menú con opciones nutritivas y deliciosas</p>
    </div>

    <!-- Desayunos -->
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h3 class="text-xl font-bold">Desayunos</h3>
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <c:forEach var="item" items="${desayunos}">
                <div class="border rounded-lg p-4">
                    <div class="flex justify-between items-center mb-2">
                        <span class="font-semibold">${item.nombreMenu}</span>
                        <span class="text-green-600 font-bold">${item.precio}</span>
                    </div>
                    <button class="flex items-center text-sm text-blue-500 hover:text-blue-700 transition-colors" onclick="toggleDescription('${item.nombreMenu}')">
                        <span id="${item.nombreMenu}-icon">▼</span>
                        Ver descripción
                    </button>
                    <p id="${item.nombreMenu}" class="mt-2 text-gray-600 text-sm bg-gray-50 p-2 rounded" style="display:none;">
                            ${item.descripcionMenu}
                    </p>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Almuerzos -->
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h3 class="text-xl font-bold">Almuerzos</h3>
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <c:forEach var="item" items="${almuerzos}">
                <div class="border rounded-lg p-4">
                    <div class="flex justify-between items-center mb-2">
                        <span class="font-semibold">${item.nombreMenu}</span>
                        <span class="text-green-600 font-bold">${item.precio}</span>
                    </div>
                    <button class="flex items-center text-sm text-blue-500 hover:text-blue-700 transition-colors" onclick="toggleDescription('${item.nombreMenu}')">
                        <span id="${item.nombreMenu}-icon">▼</span>
                        Ver descripción
                    </button>
                    <p id="${item.nombreMenu}" class="mt-2 text-gray-600 text-sm bg-gray-50 p-2 rounded" style="display:none;">
                            ${item.descripcionMenu}
                    </p>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Bebidas y Snacks -->
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h3 class="text-xl font-bold">Bebidas y Snacks</h3>
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <c:forEach var="item" items="${bebidasYSnacks}">
                <div class="border rounded-lg p-4">
                    <div class="flex justify-between items-center mb-2">
                        <span class="font-semibold">${item.nombreMenu}</span>
                        <span class="text-green-600 font-bold">${item.precio}</span>
                    </div>
                    <button class="flex items-center text-sm text-blue-500 hover:text-blue-700 transition-colors" onclick="toggleDescription('${item.nombreMenu}')">
                        <span id="${item.nombreMenu}-icon">▼</span>
                        Ver descripción
                    </button>
                    <p id="${item.nombreMenu}" class="mt-2 text-gray-600 text-sm bg-gray-50 p-2 rounded" style="display:none;">
                            ${item.descripcionMenu}
                    </p>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</body>
</html>
