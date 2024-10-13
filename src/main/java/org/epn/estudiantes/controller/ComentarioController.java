package org.epn.estudiantes.controller;

import org.epn.estudiantes.model.Comentario;
import org.epn.estudiantes.service.ComentarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ComentarioController extends HttpServlet {
    private final ComentarioService comentarioService = new ComentarioService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Comentario comentario = new Comentario();
        // Lógica para obtener datos del comentario desde la request
        comentarioService.agregarComentario(comentario);
        response.sendRedirect("comentarios.jsp");
    }
}
