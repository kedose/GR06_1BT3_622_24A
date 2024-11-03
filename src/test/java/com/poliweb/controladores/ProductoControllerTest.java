package com.poliweb.controladores;


import com.poliweb.modelo.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private ProductoController productoController;

    @BeforeEach
    public void setUp() {
        productoController = new ProductoController();
    }

    @Test
    public void testDoPostSuccess() throws ServletException, IOException {
        // Simulando los parámetros de la solicitud
        when(request.getParameter("codigoEstudiante")).thenReturn("12345");
        when(request.getParameter("nombreEstudiante")).thenReturn("Juan Perez");
        when(request.getParameter("nombreProducto")).thenReturn("Laptop");
        when(request.getParameter("precioProducto")).thenReturn("500.0");
        when(request.getParameter("numeroContacto")).thenReturn("0987654321");
        when(request.getParameter("tiempoVisualizacion")).thenReturn("24 horas");

        // Preparar la salida de respuesta simulada
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Mockeamos los métodos estáticos de Producto
        try (var mockedProducto = Mockito.mockStatic(Producto.class)) {
            Producto producto = new Producto("12345", "Juan Perez", "Laptop", 500.0, "0987654321", "24 horas");
            mockedProducto.when(() -> Producto.obtenerProductos()).thenReturn(List.of(producto));

            // Ejecutar el método doPost
            productoController.doPost(request, response);

            // Verificar el resultado esperado en el JSON
            printWriter.flush(); // flush necesario para que el contenido se escriba en el StringWriter
            String expectedJson = "{\"success\": true, \"producto\": {\"nombreProducto\": \"Laptop\",\"precioProducto\": \"500.0\",\"nombreEstudiante\": \"Juan Perez\",\"numeroContacto\": \"0987654321\",\"codigoEstudiante\": \"12345\",\"tiempoVisualizacion\": \"24 horas\"}}";
            assertEquals(expectedJson, stringWriter.toString());
        }
    }

    @Test
    public void testDoPostError() throws IOException, ServletException {
        // Simulando parámetros que causen error en el parseo de Double
        when(request.getParameter("codigoEstudiante")).thenReturn("12345");
        when(request.getParameter("nombreEstudiante")).thenReturn("Juan Perez");
        when(request.getParameter("nombreProducto")).thenReturn("Laptop");
        when(request.getParameter("precioProducto")).thenReturn("error"); // Esto causará un NumberFormatException

        // Preparar la salida de respuesta simulada
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Ejecutar el método doPost y verificar si se maneja el error correctamente
        try {
            productoController.doPost(request, response);
        } catch (Exception e) {
            // En caso de una excepción, imprimir un mensaje de error
            System.out.println("Error al procesar el precio del producto: " + e.getMessage());
        }

        // Verificar el código de estado y el mensaje de error en el JSON
        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST); // Cambiar a SC_BAD_REQUEST
        printWriter.flush();
        String expectedErrorJson = "{\"success\": false, \"message\": \"El precio del producto debe ser un número válido\"}"; // Cambiar mensaje de error
        assertEquals(expectedErrorJson, stringWriter.toString());
    }
}