package com.poliweb.controladores;

import com.poliweb.modelo.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/productoController")
public class ProductoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtiene los parámetros del formulario
            String codigoEstudiante = request.getParameter("codigoEstudiante");
            String nombreEstudiante = request.getParameter("nombreEstudiante");
            String nombreProducto = request.getParameter("nombreProducto");
            double precioProducto = Double.parseDouble(request.getParameter("precioProducto"));
            String numeroContacto = request.getParameter("numeroContacto");
            String tiempoVisualizacion = request.getParameter("tiempoVisualizacion");

            // Imprimir en consola los parámetros obtenidos
            System.out.println("Código Estudiante: " + codigoEstudiante);
            System.out.println("Nombre Estudiante: " + nombreEstudiante);
            System.out.println("Nombre Producto: " + nombreProducto);
            System.out.println("Precio Producto: " + precioProducto);
            System.out.println("Número de Contacto: " + numeroContacto);
            System.out.println("Tiempo de Visualización: " + tiempoVisualizacion);

            // Crea un nuevo producto y lo añade a la lista
            Producto producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);
            Producto.agregarProducto(producto); // Usar el método estático para agregar el producto

            // Imprimir en consola el producto creado
            System.out.println("Producto agregado: " + nombreProducto);

            // Enviar una respuesta JSON al cliente
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true, \"producto\": {\"nombreProducto\": \"" + nombreProducto + "\", \"precioProducto\": \"" + precioProducto + "\", \"nombreEstudiante\": \"" + nombreEstudiante + "\", \"numeroContacto\": \"" + numeroContacto + "\", \"codigoEstudiante\": \"" + codigoEstudiante + "\"}}");

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Error procesando la solicitud\"}");
            e.printStackTrace(); // Imprimir el stack trace del error en la consola
        }
    }


}
