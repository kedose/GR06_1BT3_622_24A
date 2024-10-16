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
        .menu-item button.active {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container my-4">
        <div class="bg-white p-6 rounded-lg shadow-lg">
            <h2 class="text-2xl font-bold mb-4">Asociaciones EPN</h2>
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                <c:forEach var='item' items="${asociaciones}">
                    <div class="flex items-center justify-between border-b pb-2">
                        <div class="flex items-center">
                            <span class="mr-2 text-green-500">&#x1F374;</span>
                            <span>${item.nombre}</span>
                        </div>
                        <span class="font-semibold">${item.descripcion}</span>
                    </div>

                </c:forEach>
            </div>
        </div>
    </div>

<!-- jQuery (debe estar antes de Bootstrap JS) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>