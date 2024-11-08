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

import static org.junit.jupiter.api.Assertions.assertEquals;  // Importación de la aserción de JUnit
import static org.mockito.Mockito.*;  // Importación de las funciones estáticas de Mockito

// Habilita el uso de Mockito en las pruebas de JUnit
@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    // Se crea un mock para HttpServletRequest
    @Mock
    private HttpServletRequest request;

    // Se crea un mock para HttpServletResponse
    @Mock
    private HttpServletResponse response;

    // Controlador que se va a probar
    private ProductoController productoController;

    // Este método se ejecuta antes de cada prueba, inicializando el controlador
    @BeforeEach
    public void setUp() {
        productoController = new ProductoController();  // Inicializa el controlador
    }

    // Prueba para verificar el comportamiento exitoso del método doPost
    @Test
    public void testDoPostSuccess() throws ServletException, IOException {
        System.out.println("Test 1");

        // Simulamos los parámetros de la solicitud HTTP (HttpServletRequest)
        when(request.getParameter("codigoEstudiante")).thenReturn("12345");
        when(request.getParameter("nombreEstudiante")).thenReturn("Juan Perez");
        when(request.getParameter("nombreProducto")).thenReturn("Laptop");
        when(request.getParameter("precioProducto")).thenReturn("500.0");
        when(request.getParameter("numeroContacto")).thenReturn("0987654321");
        when(request.getParameter("tiempoVisualizacion")).thenReturn("24 horas");

        // Preparamos la salida simulada de la respuesta (HttpServletResponse)
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);  // Mockeamos la obtención del PrintWriter

        // Mockeamos los métodos estáticos de la clase Producto
        try (var mockedProducto = Mockito.mockStatic(Producto.class)) {
            // Definimos un producto mockeado
            Producto producto = new Producto("12345", "Juan Perez", "Laptop", 500.0, "0987654321", "24 horas");
            // Simulamos que el método obtenerProductos devuelve la lista con el producto mockeado
            mockedProducto.when(() -> Producto.obtenerProductos()).thenReturn(List.of(producto));

            // Ejecutamos el método doPost del controlador
            productoController.doPost(request, response);

            // Verificamos que el resultado generado sea el esperado
            printWriter.flush();  // Se asegura de que el contenido se haya escrito en el StringWriter
            String expectedJson = "{\"success\": true, \"producto\": {\"nombreProducto\": \"Laptop\",\"precioProducto\": \"500.0\",\"nombreEstudiante\": \"Juan Perez\",\"numeroContacto\": \"0987654321\",\"codigoEstudiante\": \"12345\",\"tiempoVisualizacion\": \"24 horas\"}}";
            assertEquals(expectedJson, stringWriter.toString());  // Comprobamos que el JSON generado es correcto
        }
    }

    // Prueba para verificar el comportamiento en caso de error
    @Test
    public void testDoPostError() throws IOException, ServletException {
        System.out.println("Test 2");

        // Simulamos parámetros incorrectos que causarán un error de conversión
        when(request.getParameter("codigoEstudiante")).thenReturn("12345");
        when(request.getParameter("nombreEstudiante")).thenReturn("Juan Perez");
        when(request.getParameter("nombreProducto")).thenReturn("Laptop");
        when(request.getParameter("precioProducto")).thenReturn("error");  // Esto provocará un NumberFormatException

        // Preparamos la salida simulada de la respuesta
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Ejecutamos el método doPost y verificamos el manejo del error
        try {
            productoController.doPost(request, response);
        } catch (Exception e) {
            // Si ocurre una excepción, la capturamos y mostramos un mensaje de error
            System.out.println("Error al procesar el precio del producto: " + e.getMessage());
        }

        // Verificamos que se haya establecido el código de estado adecuado para el error
        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);  // Verifica que el estado de la respuesta sea 400 (Bad Request)
        printWriter.flush();  // Asegura que el contenido se haya escrito
        String expectedErrorJson = "{\"success\": false, \"message\": \"El precio del producto debe ser un número válido\"}";  // JSON esperado en caso de error
        assertEquals(expectedErrorJson, stringWriter.toString());  // Comprobamos que el JSON de error es correcto
    }
}
