package com.poliweb.controladores;

import com.poliweb.modelo.Ruta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistencia.RutaJpaController;

import java.io.IOException;
import java.util.List;

@WebServlet("/buses")
public class RutaController extends HttpServlet {

    private final RutaJpaController controladoraPersistencia;
    private static final String RUTA_JSP = "polibus.jsp";
    private static final String ERROR_CONSULTA = "Error en la consulta: ";

    // Constructor
    public RutaController() {
        this.controladoraPersistencia = new RutaJpaController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Ruta> rutas = obtenerRutas();
            pasarAtributosYDespachar(request, response, rutas);
        } catch (Exception e) {
            manejarError(response, e);
        }
    }

    // Método separado para obtener rutas
    private List<Ruta> obtenerRutas() throws Exception {
        return controladoraPersistencia.obtenerTodasLasRutas();
    }

    // Método separado para pasar atributos y despachar la respuesta
    private void pasarAtributosYDespachar(HttpServletRequest request, HttpServletResponse response, List<Ruta> rutas) throws ServletException, IOException {
        request.setAttribute("rutas", rutas);
        request.getRequestDispatcher(RUTA_JSP).forward(request, response);
    }

    // Método separado para manejo de errores
    private void manejarError(HttpServletResponse response, Exception e) throws IOException {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ERROR_CONSULTA + e.getMessage());
    }
}

