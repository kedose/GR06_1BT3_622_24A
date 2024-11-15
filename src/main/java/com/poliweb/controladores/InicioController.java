package com.poliweb.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Inicio")
public class InicioController extends HttpServlet {
    // Sobrescribe el método doGet para manejar solicitudes GET al servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Redirige la solicitud y la respuesta a la página bienvenida.jsp
        request.getRequestDispatcher("/bienvenida.jsp").forward(request, response);
    }
}