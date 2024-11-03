package com.poliweb.controladores;

import com.poliweb.modelo.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productoController")
public class ProductoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtiene los parámetros del formulario
            String codigoEstudiante = request.getParameter("codigoEstudiante");
            String nombreEstudiante = request.getParameter("nombreEstudiante");
            String nombreProducto = request.getParameter("nombreProducto");
            double precioProducto;

            // Intentar convertir el precio del producto a un número
            try {
                precioProducto = Double.parseDouble(request.getParameter("precioProducto"));
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"success\": false, \"message\": \"El precio del producto debe ser un número válido\"}");
                return; // Salir del método para evitar continuar con la lógica
            }

            String numeroContacto = request.getParameter("numeroContacto");
            String tiempoVisualizacion = request.getParameter("tiempoVisualizacion");

            // Crea un nuevo producto y lo añade a la lista
            Producto producto = new Producto(codigoEstudiante, nombreEstudiante,
                    nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);
            Producto.agregarProducto(producto);

            // Enviar la lista de productos al JSP
            List<Producto> listaproductos = Producto.obtenerProductos();
            request.setAttribute("listaproductos", listaproductos);

            // Enviar respuesta JSON al cliente
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true, \"producto\": {" +
                    "\"nombreProducto\": \"" + nombreProducto + "\"," +
                    "\"precioProducto\": \"" + precioProducto + "\"," +
                    "\"nombreEstudiante\": \"" + nombreEstudiante + "\"," +
                    "\"numeroContacto\": \"" + numeroContacto + "\"," +
                    "\"codigoEstudiante\": \"" + codigoEstudiante + "\"," +
                    "\"tiempoVisualizacion\": \"" + tiempoVisualizacion + "\"" +
                    "}}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Error procesando la solicitud\"}");
            e.printStackTrace();
        }
    }
}
