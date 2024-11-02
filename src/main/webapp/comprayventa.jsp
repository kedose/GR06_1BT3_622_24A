<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.poliweb.modelo.Producto" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Polimarket - Compra y Venta</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- Asegúrate de incluir jQuery -->
</head>
<body class="bg-gray-100 p-6">
<div class="container mx-auto space-y-6">
  <div class="flex justify-between items-center">
    <h2 class="text-2xl font-bold">Polimarket - Compra y Venta $$$</h2>
    <button
            id="toggleFormButton"
            onclick="toggleForm()"
            class="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600"
    >
      Vender
    </button>
  </div>

  <!-- Formulario de producto -->
  <div id="productForm" class="bg-white p-6 rounded-lg shadow-lg hidden">
    <h3 class="text-xl font-semibold mb-4">Publicar tu Producto</h3>
    <form id="publishForm" class="space-y-4">
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div>
          <label for="codigoEstudiante">Código Estudiante:</label>
          <input type="text" id="codigoEstudiante" name="codigoEstudiante" required class="w-full p-2 border rounded-lg"/>
        </div>
        <div>
          <label for="nombreEstudiante">Nombre Estudiante:</label>
          <input type="text" id="nombreEstudiante" name="nombreEstudiante" required class="w-full p-2 border rounded-lg"/>
        </div>
        <div>
          <label for="nombreProducto">Nombre Producto:</label>
          <input type="text" id="nombreProducto" name="nombreProducto" required class="w-full p-2 border rounded-lg"/>
        </div>
        <div>
          <label for="precioProducto">Precio Producto:</label>
          <input type="number" id="precioProducto" name="precioProducto" required class="w-full p-2 border rounded-lg"/>
        </div>
        <div>
          <label for="numeroContacto">Número de Contacto:</label>
          <input type="tel" id="numeroContacto" name="numeroContacto" required class="w-full p-2 border rounded-lg"/>
        </div>
        <div>
          <label for="tiempoVisualizacion">Tiempo de Visualización:</label>
          <select name="tiempoVisualizacion" id="tiempoVisualizacion" required class="w-full p-2 border rounded-lg">
            <option value="1">1 minuto</option>
            <option value="1440">1 día</option>
            <option value="10080">1 semana</option>
            <option value="43200">1 mes</option>
          </select>
        </div>
      </div>
      <div class="flex justify-end">
        <button type="button" onclick="publicarProducto()" class="bg-green-500 text-white px-6 py-2 rounded-lg hover:bg-green-600">Publicar</button>
      </div>
    </form>
  </div>

  <!-- Lista de productos en venta -->
  <div class="container my-4">
    <div class="bg-white p-6 rounded-lg shadow-lg">
      <h2 class="text-2xl font-bold mb-4">Polimarket</h2>
      <p class="mb-4">Vende tus libros de inglés, o objetos que ya no necesites</p>
      <div id="productList" class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        <c:forEach var="product" items="${listaproductos}">
          <div class="bg-white p-4 rounded-lg shadow-lg producto-item">
            <h3 class="text-xl font-semibold mb-2">${product.nombreProducto}</h3>
            <p class="text-2xl font-bold text-green-600 mb-2">$${product.precioProducto}</p>
            <div class="space-y-1 text-sm text-gray-600">
              <p>${product.nombreEstudiante}</p>
              <p>${product.numeroContacto}</p>
              <p>${product.codigoEstudiante}</p>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
      <!-- Agrega un producto manualmente para prueba -->
      <script>
        $(document).ready(function() {
          $('#productList').append(`
            <div class="bg-white p-4 rounded-lg shadow-lg producto-item">
                <h3 class="text-xl font-semibold mb-2">Producto de Prueba</h3>
                <p class="text-2xl font-bold text-green-600 mb-2">$1</p>
                <div class="space-y-1 text-sm text-gray-600">
                    <p>Estudiante de Prueba</p>
                    <p>1234567890</p>
                    <p>1</p>
                </div>
            </div>
        `);
        });
      </script>

    </div>
    </div>
  </div>


<script>
  function toggleForm() {
    const form = document.getElementById('productForm');
    const button = document.getElementById('toggleFormButton');

    form.classList.toggle('hidden');
    button.textContent = form.classList.contains('hidden') ? 'Vender' : 'Cancelar';
  }

  function publicarProducto() {
    var codigoEstudiante = $('#codigoEstudiante').val();
    var nombreEstudiante = $('#nombreEstudiante').val(); // Mantén esto como una variable local
    var nombreProducto = $('#nombreProducto').val();
    var precioProducto = $('#precioProducto').val();
    var numeroContacto = $('#numeroContacto').val();
    var tiempoVisualizacion = $('#tiempoVisualizacion').val();

    var formData = {
      codigoEstudiante: codigoEstudiante,
      nombreEstudiante: nombreEstudiante,
      nombreProducto: nombreProducto,
      precioProducto: precioProducto,
      numeroContacto: numeroContacto,
      tiempoVisualizacion: tiempoVisualizacion
    };

    $.ajax({
      type: "POST",
      url: "productoController",
      data: formData,
      success: function(response) {
        // Imprimir la respuesta completa
        console.log("Respuesta del servidor:", response);

        // Verifica que la respuesta sea exitosa
        if (response.success && response.producto) {
          let newProduct = response.producto;
          // Imprimir el nuevo producto para verificar
          console.log("Nuevo producto:", newProduct);

          var productHtml = `
        <div class="bg-white p-4 rounded-lg shadow-lg producto-item">
            <h3 class="text-xl font-semibold mb-2">\${newProduct.nombreProducto}</h3>
            <p class="text-2xl font-bold text-green-600 mb-2">$\${newProduct.precioProducto}</p>
            <div class="space-y-1 text-sm text-gray-600">
                <p>\${newProduct.nombreEstudiante}</p>
                <p>\${newProduct.numeroContacto}</p>
                <p>\${newProduct.tiempoVisualizacion}</p>
            </div>
        </div>
    `;

          // Agregar el nuevo producto al inicio de la lista
          $('#productList').prepend(productHtml);
          $('#publishForm')[0].reset(); // Limpiar el formulario correctamente
          toggleForm(); // Ocultar el formulario
        } else {
          console.error("Error al recibir el producto:", response.message || "Producto no encontrado");
        }
      },
      error: function(xhr, status, error) {
        console.error("Error en la solicitud:", status, error);
        alert("Error al publicar el producto. Por favor, inténtalo de nuevo.");
      }
    });
  }
</script>


</body>
</html>
