package com.poliweb.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/polimarket")
public class PoliMercadoController extends HttpServlet {
    // Sobrescribe el método doGet para manejar solicitudes GET al servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("/comprayventa.jsp").forward(request, response);
    }
}