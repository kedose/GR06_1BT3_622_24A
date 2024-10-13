package org.epn.estudiantes.controller;

import org.epn.estudiantes.model.ProductoCafeteria;
import org.epn.estudiantes.service.ProductoCafeteriaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductoCafeteriaController extends HttpServlet {
    private final ProductoCafeteriaService productoService = new ProductoCafeteriaService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductoCafeteria> productos = productoService.obtenerProductos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
}
