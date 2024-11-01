<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poliweb.modelo.Post" %>
<%@ page import="com.poliweb.modelo.Comentario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page import="tu.paquete.Producto" %> <%--%>
<%--    // Obtener la lista de productos desde el servlet o una fuente de datos--%>
<%--    List<Producto> productos = (List<Producto>) request.getAttribute("productos");--%>
<%--%>--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Social</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container my-4">
    <div class="bg-white p-4 rounded-lg shadow-lg">
        <h1>Publicaciones</h1>
        <table>
            <thead>
            <tr>
                <th>Código Estudiante</th>
                <th>Nombre Estudiante</th>
            </tr>
            </thead>
            <tbody>
<%--            <% for (Producto producto : productos) { %>--%>
<%--            <tr>--%>
<%--                <td><%= producto.getCodigoEstudiante() %></td>--%>
<%--                <td><%= producto.getNombreEstudiante() %></td>--%>
<%--            </tr>--%>
<%--            <% } %>--%>
            </tbody>
        </table>
    </div>
</div>

<!-- jQuery y Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        // Manejador del formulario para publicar
        $("#form-publicar").on("submit", function (e) {
            e.preventDefault(); // Evitar el submit tradicional y el cambio de URL

            var mensaje = $("#mensaje").val();
            console.log("Mensaje capturado:", mensaje); // Verificar el mensaje capturado

            if (mensaje === "") {
                alert("El mensaje no puede estar vacío.");
                return;
            }

            // Enviar el mensaje a través de AJAX
            $.ajax({
                url: "PublicarPostServlet", // Cambia esto a tu servlet correspondiente
                type: "POST",
                data: {
                    mensaje: mensaje
                },
                success: function (response) {
                    // Limpiar el textarea y actualizar la vista con el nuevo post
                    $("#mensaje").val(""); // Limpiar el campo de texto
                    $("#posts-container").prepend(response); // Agregar el nuevo post al inicio del contenedor
                },
                error: function () {
                    alert("Error al publicar el mensaje.");
                }
            });
        });

        // Manejador para mostrar/ocultar comentarios
        $(document).on("click", ".toggle-comentarios", function (e) {
            e.preventDefault();
            var postId = $(this).data("post-id");
            $("#comentarios-" + postId).toggle(); // Mostrar u ocultar comentarios
        });

        // Manejador para dar o quitar like
        $(document).on("click", ".btn-like", function (e) {
            e.preventDefault();
            var postId = $(this).data("post-id");
            var likeCountElement = $(".like-count").filter("[data-post-id='" + postId + "']");
            var currentLikes = parseInt(likeCountElement.text());

            // Enviar petición AJAX para dar o quitar like
            $.ajax({
                url: "AgregarLikeServlet", // Cambia esto a tu servlet correspondiente
                type: "POST",
                data: {
                    postIndex: postId
                },
                success: function (response) {
                    // Alternar entre dar y quitar like
                    if ($(this).text() === "Dar Like") {
                        $(this).text("Quitar Like"); // Cambiar texto
                        likeCountElement.text(currentLikes + 1 + " Me gusta"); // Incrementar likes
                    } else {
                        $(this).text("Dar Like"); // Cambiar texto
                        likeCountElement.text(currentLikes - 1 + " Me gusta"); // Decrementar likes
                    }
                }.bind(this),
                error: function () {
                    alert("Error al dar like.");
                }
            });
        });

        // Manejador para comentar
        $(document).on("submit", ".form-comentar", function (e) {
            e.preventDefault();
            var postId = $(this).data("post-id");
            var mensaje = $(this).find("input[type='text']").val();

            // Enviar petición AJAX para añadir comentario
            $.ajax({
                url: "ComentarServlet", // Cambia esto a tu servlet correspondiente
                type: "POST",
                data: {
                    postId: postId,
                    mensaje: mensaje
                },
                success: function (response) {
                    // Limpiar el input y añadir el comentario al DOM
                    $(this).find("input[type='text']").val("");
                    $("#comentarios-" + postId).prepend("<p><strong>Tú:</strong> " + mensaje + "</p>");
                }.bind(this),
                error: function () {
                    alert("Error al comentar.");
                }
            });
        });
    });
</script>


</script>

</body>
</html>
