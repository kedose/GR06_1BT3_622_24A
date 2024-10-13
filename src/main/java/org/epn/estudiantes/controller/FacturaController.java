package org.epn.estudiantes.controller;

import org.epn.estudiantes.model.Factura;
import org.epn.estudiantes.service.FacturaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacturaController extends HttpServlet {
    private final FacturaService facturaService = new FacturaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Factura factura = new Factura();
        // Lógica para obtener datos de la factura desde la request
        facturaService.procesarFactura(factura);
        response.sendRedirect("factura.jsp");
    }
}
