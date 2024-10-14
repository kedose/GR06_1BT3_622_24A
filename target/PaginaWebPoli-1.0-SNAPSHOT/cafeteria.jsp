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
            
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                <c:forEach var="item" items="${menuItems}">
                    <div class="flex items-center justify-between border-b pb-2">
                        <div class="flex items-center">
                            <!-- Aquí puedes incluir un icono de cubiertos o similar -->
                            <span class="mr-2 text-green-500">&#x1F374;</span>
                            <span>${item.name}</span>
                        </div>
                        <span class="font-semibold">${item.price}</span>
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
