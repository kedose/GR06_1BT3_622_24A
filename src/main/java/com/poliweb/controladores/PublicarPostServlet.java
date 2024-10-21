package com.poliweb.controladores;

import com.poliweb.modelo.Comentario;
import com.poliweb.modelo.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PublicarPostServlet")
public class PublicarPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = request.getParameter("mensaje");

        if (mensaje != null && !mensaje.isEmpty()) {
            HttpSession session = request.getSession();
            List<Post> posts = (List<Post>) session.getAttribute("posts");
            if (posts == null) {
                posts = new ArrayList<>();
            }

            Post nuevoPost = new Post("Carlos Ramírez", mensaje, 0); // Crea el nuevo post
            posts.add(0, nuevoPost); // Añadir al inicio de la lista
            session.setAttribute("posts", posts);

            // Devolver el nuevo post como respuesta
            response.setContentType("text/html");
            response.getWriter().write("<div class='post'>"
                    + "<p><strong>" + nuevoPost.getAutor() + "</strong></p>"
                    + "<p>" + nuevoPost.getMensaje() + "</p>"
                    + "<p><small><a href='#' class='toggle-comentarios' data-post-id='" + posts.indexOf(nuevoPost) + "'>Comentarios (0)</a></small></p>"
                    + "<button class='btn btn-secondary btn-like' data-post-id='" + posts.indexOf(nuevoPost) + "'>Dar Like</button>"
                    + "<p class='like-count'>" + nuevoPost.getLikes() + " Me gusta</p>"
                    + "<div id='comentarios-" + posts.indexOf(nuevoPost) + "' style='display:none;'></div>"
                    + "</div>");

        } else {
            response.sendRedirect("areasocial.jsp?error=1");
        }
    }

}

