package com.poliweb.controladores;
import com.poliweb.modelo.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/AgregarLikeServlet")
public class AgregarLikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("postIndex")); // Obtener el índice del post
        HttpSession session = request.getSession();

        // Obtener la lista de posts de la sesión
        List<Post> posts = (List<Post>) session.getAttribute("posts");
        if (posts != null && index >= 0 && index < posts.size()) {
            Post post = posts.get(index);
            post.incrementarLikes(); // Incrementar los likes del post
            session.setAttribute("posts", posts); // Actualizar la lista en la sesión
        }

        // Redirigir de nuevo a areasocial.jsp
        response.sendRedirect("areasocial.jsp");
    }
}