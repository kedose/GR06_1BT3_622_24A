<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Productos</title>
</head>
<body>
<h1>Gestión de Productos</h1>
<form method="post" action="producto">
    <input type="text" name="nombre" placeholder="Nombre del Producto" required>
    <input type="number" step="0.01" name="precio" placeholder="Precio" required>
    <button type="submit">Agregar Producto</button>
</form>

<h2>Lista de Productos</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio</th>
    </tr>
    <c:forEach var="producto" items="${productos}">
        <tr>
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
