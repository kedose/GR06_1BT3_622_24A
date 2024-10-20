<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poliweb.modelo.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <h1 class="text-center">Área Social</h1>

        <!-- Formulario para publicar -->
        <form id="form-publicar" class="mb-4">
            <div class="form-group">
                <textarea id="mensaje" name="mensaje" class="form-control" placeholder="¿Qué está pasando en la EPN?" rows="4"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Publicar</button>
        </form>

        <!-- Lista de publicaciones -->
        <div class="post-list">
            <h2 class="text-2xl font-bold mb-3">Publicaciones</h2>
            <div id="posts-container">
                <c:choose>
                    <c:when test="${not empty posts}">
                        <c:forEach var="post" items="${posts}">
                            <div class="post card mb-3">
                                <div class="card-body">
                                    <p class="card-title"><strong>${post.autor}</strong></p>
                                    <p class="card-text">${post.mensaje}</p>
                                    <p class="card-text"><small class="text-muted">${post.likes} Me gusta - ${post.comentarios} Comentarios</small></p>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>No hay publicaciones.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#form-publicar").on("submit", function(e) {
            e.preventDefault(); // Evitar el submit tradicional y el cambio de URL

            var mensaje = $("#mensaje").val();
            console.log("Mensaje capturado:", mensaje); // Verificar el mensaje capturado

            if (mensaje === "") {
                alert("El mensaje no puede estar vacío.");
                return;
            }

            // Enviar datos con AJAX
            $.ajax({
                url: "PublicarPostServlet",
                type: "POST",
                data: {
                    mensaje: mensaje
                },
                success: function(response) {
                    console.log("Respuesta del servidor:", response); // Verificar la respuesta del servidor

                    // Limpiar el textarea
                    $("#mensaje").val("");

                    // Solo actualizar si el mensaje no está vacío
                    if (mensaje) {
                        $("#posts-container").prepend(
                            '<div class="post">' +
                            '<p><strong>Carlos Ramírez</strong></p>' +
                            '<p>' + mensaje + '</p>' + // Usar concatenación
                            '<p><small>0 Me gusta - 0 Comentarios</small></p>' +
                            '</div>'
                        );
                        console.log("Publicación añadida con mensaje:", mensaje); // Confirmar que la publicación se añadió
                    } else {
                        console.log("El mensaje es indefinido o nulo.");
                    }
                },
                error: function() {
                    alert("Error al publicar el mensaje.");
                    console.log("Error al intentar publicar el mensaje."); // Imprimir un error si falla
                }
            });


        });
    });
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



</body>
</html>
