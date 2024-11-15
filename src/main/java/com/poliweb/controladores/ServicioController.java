package com.poliweb.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/Servicios")
public class ServicioController extends HttpServlet {
    // Sobrescribe el método doGet para manejar solicitudes GET al servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige la solicitud y la respuesta a la página index.jsp
        // para mostrar la interfaz principal o de inicio
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
