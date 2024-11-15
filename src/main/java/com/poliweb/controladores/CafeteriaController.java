package com.poliweb.controladores;

import com.poliweb.modelo.Cafeteria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.CafeteriaJPAController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            List<Cafeteria> menuItems = obtenerMenu();

            // Filtrar por tipo de menú
            List<Cafeteria> desayunos = menuItems.stream().filter(item -> "Desayuno".equals(item.getTipoMenu())).collect(Collectors.toList());
            List<Cafeteria> almuerzos = menuItems.stream().filter(item -> "Almuerzo".equals(item.getTipoMenu())).collect(Collectors.toList());
            List<Cafeteria> bebidasYSnacks = menuItems.stream()
                    .filter(item -> !"Almuerzo".equals(item.getTipoMenu()) && !"Desayuno".equals(item.getTipoMenu()))
                    .collect(Collectors.toList());

            // Enviar los atributos al JSP
            request.setAttribute("desayunos", desayunos);
            request.setAttribute("almuerzos", almuerzos);
            request.setAttribute("bebidasYSnacks", bebidasYSnacks);

            request.getRequestDispatcher(CAFETERIA_JSP).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Captura errores
        }
    }



    private void pasarAtributosYDespachar(HttpServletRequest request, HttpServletResponse response, List<Cafeteria> menuItems) throws ServletException, IOException {
        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher(CAFETERIA_JSP).forward(request, response);
    }
}
