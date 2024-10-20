package com.poliweb.controladores;

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
        System.out.println(mensaje);

        if (mensaje != null && !mensaje.isEmpty()) {
            HttpSession session = request.getSession();

            // Obtener la lista de posts de la sesión o crear una nueva si no existe
            List<Post> posts = (List<Post>) session.getAttribute("posts");
            if (posts == null) {
                posts = new ArrayList<>();
            }

            // Crear un nuevo post
            Post nuevoPost = new Post("Carlos Ramírez", mensaje, 0, 0);

            // Añadir el nuevo post a la lista
            posts.add(0, nuevoPost); // Añadir al inicio de la lista para que aparezca primero

            // Guardar la lista de posts en la sesión
            session.setAttribute("posts", posts);

            // Redirigir de nuevo a areasocial.jsp
            response.sendRedirect("areasocial.jsp");
        } else {
            response.sendRedirect("areasocial.jsp?error=1");
        }
    }
}
