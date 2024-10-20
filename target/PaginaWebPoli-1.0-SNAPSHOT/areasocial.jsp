<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poliweb.modelo.Post" %>
<%@ page import="com.poliweb.modelo.Comentario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Social</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .comentarios {
            display: none; /* Ocultar comentarios inicialmente */
            margin-top: 10px;
        }

        .contenedor-comentarios {
            display: flex;
            flex-wrap: wrap;
            flex-direction: column;
            width: 100%;
        }

        .contenedor-comentarios img {
            width: 100%;
        }

        .area-comentar {
            display: flex;
            flex-wrap: wrap;
            flex-direction: row;
            margin-bottom: 1.5rem;
            padding: 18px;
            background-color: #fff;
            box-shadow: 0 0 5px 2px rgba(0, 0, 0, .1);
            border-radius: 12px;
        }

        .comentarios-usuarios {
            width: calc(100% - 2.5rem);
        }

        .contenedor-comentarios a {
            text-decoration: none;
        }

        .comentar-publicacion .avatar,
        .publicacion-realizada .usuario-publico .avatar,
        .contenedor-comentarios .comentario-principal-usuario .avatar,
        .area-comentar .avatar {
            display: flex;
            width: 65px;
            height: 65px;
            background-color: #F4F4F4;
            border-radius: 50%;
            overflow: hidden;
        }
        .comentarios-usuarios .nombre-usuario {
            font-weight: bold;
            margin-right: .5rem;
            color: inherit;
        }
        /* botones comentar */
        .boton-subir-archivo {
            position: relative;
            display: inline-block;
        }

        .boton-subir-archivo input[type="file"] {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            position: absolute;
            opacity: 0;
            visibility: hidden;
            width: 0;
            height: 0;
        }

        .boton-file,
        .boton-enviar {
            display: inline-block;
            border: 0;
            background-color: #374D71;
            padding: 7px 15px;
            margin-right: .5rem;
            color: #fff;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color ease-in 200ms;
        }

        .boton-file:hover,
        .boton-enviar:hover {
            background-color: #4C6FA7;
        }

        .contenedor-comentarios .comentario-principal-usuario .comentario,
        .area-comentar .inputs-comentarios {
            flex-grow: 1;
            flex-basis: 0;
            margin-left: .5rem;
        }

        .area-comentar .inputs-comentarios {
            margin-left: 1rem;
        }

        .contenedor-comentarios .comentario-principal-usuario .texto,
        .area-comentar .inputs-comentarios .area-comentario {
            border: 0;
            background-color: #F0F0F0;
            display: block;
            width: 100%;
            border-radius: 12px;
            margin-bottom: .5rem;
        }

        .botones-comentario span.tiempo-comentario {
            font-size: 0.8rem !important;
            color: #9F9F9F;
            margin-left: .25rem;
        }

        .area-comentar .inputs-comentarios .area-comentario {
            padding: 12px 15px;
        }

        .area-comentar .inputs-comentarios .botones-comentar {
            display: flex;
        }

        /* comentarios de usuario */
        .comentarios-usuarios .comentario-principal-usuario {
            display: flex;
            flex-wrap: wrap;
        }

        .comentarios-usuarios .usuario-comentario {
            width: 100%;
            display: block;
            margin-bottom: 0.75rem;
            position: relative;
        }

        .menu-comentario {
            position: absolute;
            width: 30px;
            height: 30px;
            background-color: #E9E9E9;
            border-radius: 50%;
            display: none;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .comentarios-usuarios .usuario-comentario .menu-comentario {
            top: 5px;
            right: -15px;
            box-shadow: 0 0 5px rgba(0, 0, 0, .4);
        }

        .comentarios-usuarios .usuario-comentario:hover .menu-comentario {
            display: flex;
        }

        .publicacion-realizada .menu-comentario {
            display: flex;
            right: 0;
        }

        .menu-comentario .menu {
            list-style: none;
            position: absolute;
            right: 100%;
            background-color: #fff;
            box-shadow: 0 0 5px 1px rgba(0, 0, 0, .2);
            border-radius: 8px;
            padding-top: 7px;
            padding-bottom: 7px;
            opacity: 0;
            visibility: hidden;
            transition: all ease-in 200ms;
        }

        .menu-comentario:hover .menu {
            opacity: 1;
            visibility: visible;
        }

        .menu-comentario .menu a {
            display: block;
            padding: 7px 15px;
            color: inherit;
        }

        .menu-comentario .menu a:hover {
            background-color: #E1E1E1;
        }

        .publicacion-realizada .usuario-publico .avatar,
        .comentarios-usuarios .comentario-principal-usuario .avatar {
            width: 45px;
            height: 45px;
        }

        .comentarios-usuarios .comentario-principal-usuario .texto {
            padding: 10px 15px;
            width: auto;
            display: inline-block;
            max-width: 100%;
            margin-bottom: .25rem;
            font-size: 0.9rem;
            position: relative;
            padding-right: 1.65rem;
        }

        .comentarios-usuarios .comentario-principal-usuario .comentar-comentario {
            width: 100%;
            display: flex;
        }

        .comentarios-usuarios .comentar-publicacion input[type="text"] {
            border: 0;
            background-color: #E1E1E1;
            flex-grow: 1;
            flex-basis: 0;
            padding: 8px 10px;
            font-size: .9rem;
            border-radius: 8px;
            margin-right: 0.5rem;
            margin-left: 0.5rem;
        }

        .botones-comentario {
            display: block;
        }

        .botones-comentario button {
            display: inline-block;
            border: 0;
            padding: 3px 8px;
            font-size: .8rem;
            border-radius: 8px;
            cursor: pointer;
        }

        .botones-comentario button:hover {
            background-color: #D5D8E1;
        }

        .comentar-publicacion .avatar,
        .contenedor-sub-comentarios .comentario-principal-usuario .avatar {
            width: 32px;
            height: 32px;
        }

        .boton-enviar i,
        .boton-file i,
        .boton-puntuar i,
        .boton-responder i {
            margin-right: .5rem;
        }

        .publicacion-realizada {
            margin-bottom: 1.5rem;
        }

        .publicacion-realizada .usuario-publico {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            margin-bottom: .5rem;
            position: relative;
        }

        .publicacion-realizada .usuario-publico .contenido-publicacion {
            margin-left: 1rem;
        }

        .comentar-publicacion {
            display: flex;
            width: 100%;
        }

        .comentar-publicacion .comentar-comentario {
            flex-grow: 1;
            flex-basis: 0;
            display: flex;
            align-items: center;
        }

        .publicacion-realizada p {
            margin-bottom: 0.5rem;
            font-size: 0.9em;
        }

        .archivo-publicado img {
            position: relative;
            width: 100%;
            border-radius: 8px;
        }

        .publicacion-realizada .contenido-publicacion ul {
            list-style: none;
            font-size: 0.8em;
            color: #909090;
        }
    </style>
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
                                    <p class="card-text">
                                        <small class="text-muted">
                                            <span class="like-count">${post.likes} Me gusta</span> -
                                            <a href="#" class="toggle-comentarios" data-post-id="${post.id}">Comentarios (0)</a>
                                        </small>
                                    </p>
                                    <button class="btn btn-secondary btn-like" data-post-id="${post.id}">Dar Like</button>

                                    <!-- Sección de comentarios -->
                                    <div class="comentarios" id="comentarios-${post.id}" style="display:none;">
                                        <c:forEach var="comentario" items="${post.comentarios}">
                                            <p><strong>${comentario.autor}:</strong> ${comentario.mensaje}</p>
                                        </c:forEach>
                                        <form class="form-comentar" data-post-id="${post.id}">
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Añadir un comentario" required>
                                            </div>
                                            <button type="submit" class="btn btn-info">Comentar</button>
                                        </form>
                                    </div>
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
<div>
    <section class="contenedor-comentarios">
        <div class="area-comentar">
            <div class="avatar">
                <img src="http://localhost/multimedia/relleno/img-c9.png" alt="img">
            </div>
            <form action="#" method="post" class="inputs-comentarios">
                <textarea name="" class="area-comentario"></textarea>
                <div class="botones-comentar">
                    <div class="boton-subir-archivo">
                        <label class="boton-file" for="adjuntar">
                            <i class="far fa-image"></i>
                            Adjuntar archivo
                        </label>
                        <input type="file" name="" value="" placeholder="" id="adjuntar">
                    </div>
                    <button class="boton-enviar" type="sutmit">
                        <i class="fas fa-paper-plane"></i>
                        Enviar
                    </button>
                </div>
            </form>
        </div>
        <div class="publicacion-realizada">
            <div class="usuario-publico">
                <div class="avatar">
                    <img src="http://localhost/multimedia/relleno/img-c9.png" alt="img">
                </div>
                <div class="contenido-publicacion">
                    <h4>Carolina de la valle</h4>
                    <ul>
                        <li>Hace 3 min</li>
                    </ul>
                </div>
                <div class="menu-comentario">
                    <i class="fas fa-pen"></i>
                    <ul class="menu">
                        <li><a href="">Editar</a></li>
                        <li><a href="">Eliminar</a></li>
                    </ul>
                </div>
            </div>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Asperiores aliquam possimus, doloremque repellat assumenda ipsam magni ducimus, dolorem explicabo</p>
            <div class="archivo-publicado">
                <img src="http://localhost/multimedia/relleno/img-s5.png" alt="img">
            </div>
            <div class="botones-comentario">
                <button type="submit" class="boton-puntuar">
                    <i class="fas fa-thumbs-up"></i>
                    45
                </button>
                <button type="submit" class="boton-responder">
                    Comentar
                </button>
            </div>
        </div>
        <div class="comentarios-usuarios">
            <!-- comentario principal -->
            <div class="comentario-principal-usuario">
                <div class="avatar">
                    <img src="http://localhost/multimedia/relleno/img-c10.png" alt="img">
                </div>
                <div class="comentario">
                    <div class="usuario-comentario">
                        <div class="texto">
                            <a href="#" title="" class="nombre-usuario">Camila valle</a> Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nulla tenetur necessitatibus, error debitis provident obcaecati blanditiis incidunt amet suscipit libero praesentium ducimus omnis harum commodi nobis modi perspiciatis? Quia, facilis.
                            <div class="menu-comentario">
                                <i class="fas fa-pen"></i>
                                <ul class="menu">
                                    <li><a href="">Editar</a></li>
                                    <li><a href="">Eliminar</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="botones-comentario">
                            <button type="" class="boton-puntuar">
                                <i class="fas fa-thumbs-up"></i>
                                5
                            </button>
                            <button type="" class="boton-responder">
                                responrder
                            </button>
                            <span class="tiempo-comentario">
                            hece 3 min
                        </span>
                        </div>
                    </div>

                    <!-- contenedor sub comentarios -->
                    <div class="contenedor-sub-comentarios">
                        <!-- sub-comentario uno -->
                        <div class="comentario-principal-usuario">
                            <div class="avatar">
                                <img src="http://localhost/multimedia/relleno/img-c7.png" alt="img">
                            </div>
                            <div class="comentario">
                                <div class="usuario-comentario">
                                    <div class="texto">
                                        <a href="#" title="" class="nombre-usuario">Estevan Hernandez</a> Lorem ipsum dolor sit amet adipisicing elit, sed do eiusmod
                                        <div class="menu-comentario">
                                            <i class="fas fa-pen"></i>
                                            <ul class="menu">
                                                <li><a href="">Editar</a></li>
                                                <li><a href="">Eliminar</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="botones-comentario">
                                        <button type="" class="boton-puntuar">
                                            <i class="fas fa-thumbs-up"></i>
                                            12
                                        </button>
                                        <button type="" class="boton-responder">
                                            responrder
                                        </button>
                                        <span class="tiempo-comentario">
                                        hece 3 min
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

            <div class="comentar-publicacion">
                <div class="avatar">
                    <img src="http://localhost/multimedia/relleno/img-c10.png" alt="img">
                </div>
                <form action="#" method="post" class="comentar-comentario">
                    <input type="text" name="" value="" placeholder="">
                    <button type="" class="boton-enviar">
                        <i class="fas fa-paper-plane"></i>
                    </button>
                </form>
            </div>

        </div>
    </section>
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
