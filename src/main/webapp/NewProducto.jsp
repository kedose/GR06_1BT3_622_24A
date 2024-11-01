<%--
  Created by IntelliJ IDEA.
  User: Issac
  Date: 1/11/2024
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--<%@ page import="tu.paquete.Producto" %> <%--%>
<%--  // Obtener la lista de productos desde el servlet o una fuente de datos--%>
<%--  List<Producto> productos = (List<Producto>) request.getAttribute("productos");--%>
<%--%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Publicar tu Producto</h1>
<form action="publicar" method="post">
  <label for="codigoEstudiante">Código Estudiante:</label>
  <input type="text" id="codigoEstudiante" name="codigoEstudiante" required>
  <br>
  <label for="nombreEstudiante">Nombre Estudiante:</label>
  <input type="text" id="nombreEstudiante" name="nombreEstudiante" required>
  <br>
  <input type="hidden" name="fechaPublicacion" value="<%= new java.util.Date() %>">
  <br>
  <label for="nombreProducto">Nombre Producto:</label>
  <input type="text" id="nombreProducto" name="nombreProducto" required>
  <br>
  <label for="precioProducto">Precio Producto:</label>
  <input type="number" id="precioProducto" name="precioProducto" required>
  <br>
  <label for="numeroContacto">Número de Contacto:</label>
  <input type="tel" id="numeroContacto" name="numeroContacto" required>
  <br>
  <label for="tiempoVisualizacion">Tiempo de Visualización:</label>
  <select name="tiempoVisualizacion" id="tiempoVisualizacion" required>
    <option value="1">1 minuto</option>
    <option value="1440">1 día</option>
    <option value="10080">1 semana</option>
    <option value="43200">1 mes</option>
  </select>
  <br>
  <input type="submit" value="Publicar">
</form>

</body>
</html>
