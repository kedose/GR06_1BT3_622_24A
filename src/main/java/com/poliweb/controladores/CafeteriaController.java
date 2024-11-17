package com.poliweb.controladores;

import com.poliweb.modelo.Cafeteria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.CafeteriaJPAController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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

            // Establecer horarios
            TimeZone zonaHorariaQuito = TimeZone.getTimeZone("America/Guayaquil"); // Quito usa la zona horaria "America/Guayaquil"
            Calendar calendar = Calendar.getInstance(zonaHorariaQuito);

            calendar.set(Calendar.HOUR_OF_DAY, 6);
            calendar.set(Calendar.MINUTE, 45);
            Date horaInicioDesayuno = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, 11);
            calendar.set(Calendar.MINUTE, 50);
            Date horaFinDesayuno = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, 12);
            calendar.set(Calendar.MINUTE, 0);
            Date horaInicioAlmuerzo = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, 15);
            calendar.set(Calendar.MINUTE, 0);
            Date horaFinAlmuerzo = calendar.getTime();

            // Obtener hora actual
            Date horaActual = new Date();

            // Enviar los atributos al JSP
            request.setAttribute("desayunos", desayunos);
            request.setAttribute("almuerzos", almuerzos);
            request.setAttribute("bebidasYSnacks", bebidasYSnacks);
            request.setAttribute("horaInicioDesayuno", horaInicioDesayuno);
            request.setAttribute("horaFinDesayuno", horaFinDesayuno);
            request.setAttribute("horaInicioAlmuerzo", horaInicioAlmuerzo);
            request.setAttribute("horaFinAlmuerzo", horaFinAlmuerzo);
            request.setAttribute("horaActual", horaActual);

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