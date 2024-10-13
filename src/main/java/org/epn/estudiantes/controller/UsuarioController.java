package org.epn.estudiantes.controller;

import org.epn.estudiantes.model.Usuario;
import org.epn.estudiantes.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsuarioController extends HttpServlet {
    private final UsuarioService usuarioService = new UsuarioService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        // Lógica para obtener datos del usuario desde la request
        usuarioService.registrarUsuario(usuario);
        response.sendRedirect("success.jsp");
    }
}
