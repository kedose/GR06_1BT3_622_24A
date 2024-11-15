package com.poliweb.controladores;

import com.poliweb.modelo.Cafeteria;
import com.poliweb.modelo.Ruta;
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

    private final CafeteriaJPAController cafeteriaController;
    private static final String CAFETERIA_JSP = "cafeteria.jsp";
    public CafeteriaController() {
        this(new CafeteriaJPAController());
    }

    public CafeteriaController(CafeteriaJPAController cafeteriaJPAController) {
        this.cafeteriaController = cafeteriaJPAController;
    }

    private List<Cafeteria> obtenerMenu() throws Exception {
        return cafeteriaController.obtenerMenu();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Cafeteria> menuItems = obtenerMenu();
            pasarAtributosYDespachar(request, response, menuItems);
        } catch (Exception e) {

        }
    }

    private void pasarAtributosYDespachar(HttpServletRequest request, HttpServletResponse response, List<Cafeteria> menuItems) throws ServletException, IOException {
        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher(CAFETERIA_JSP).forward(request, response);
    }
}
