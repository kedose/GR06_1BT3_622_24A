package com.poliweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.CafeteriaJPAController;
import java.io.IOException;
import java.util.List;

@WebServlet("/cafeteria")
public class CafeteriaController extends HttpServlet {

    private CafeteriaJPAController cafeteriaController;

    @Override
    public void init() throws ServletException {
        super.init();
        cafeteriaController = CafeteriaJPAController.getInstance(); // Inicializa el controlador JPA
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener todos los elementos del menú desde la base de datos
        List<Cafeteria> menuItems = cafeteriaController.obtenerMenu();

        // Pasar la lista de menú al JSP
        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("cafeteria.jsp").forward(request, response);
    }
}
