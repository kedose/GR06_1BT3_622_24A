<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.poliweb.modelo.Producto" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css">
</head>
<body class="bg-gray-100 p-6">
<div class="container mx-auto space-y-6">
    <h2 class="text-2xl font-bold mb-4">Lista de Productos</h2>
    <table class="min-w-full bg-white border border-gray-300">
        <thead>
        <tr>
            <th class="py-2 px-4 border">Código Estudiante</th>
            <th class="py-2 px-4 border">Nombre Estudiante</th>
            <th class="py-2 px-4 border">Nombre Producto</th>
            <th class="py-2 px-4 border">Precio Producto</th>
            <th class="py-2 px-4 border">Número de Contacto</th>
            <th class="py-2 px-4 border">Tiempo de Visualización</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="producto" items="${Producto.obtenerProductos()}">
            <tr>
                <td class="py-2 px-4 border">${producto.codigoEstudiante}</td>
                <td class="py-2 px-4 border">${producto.nombreEstudiante}</td>
                <td class="py-2 px-4 border">${producto.nombreProducto}</td>
                <td class="py-2 px-4 border">$${producto.precioProducto}</td>
                <td class="py-2 px-4 border">${producto.numeroContacto}</td>
                <td class="py-2 px-4 border">${producto.tiempoVisualizacion}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="mt-4">
        <a href="index.jsp" class="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600">Volver a la página principal</a>
    </div>
</div>
</body>
</html>
