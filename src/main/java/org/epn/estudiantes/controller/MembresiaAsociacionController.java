package org.epn.estudiantes.controller;

import org.epn.estudiantes.model.MembresiaAsociacion;
import org.epn.estudiantes.service.MembresiaAsociacionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MembresiaAsociacionController extends HttpServlet {
    private final MembresiaAsociacionService membresiaService = new MembresiaAsociacionService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MembresiaAsociacion> membresias = membresiaService.obtenerMembresias();
        request.setAttribute("membresias", membresias);
        request.getRequestDispatcher("membresias.jsp").forward(request, response);
    }
}
