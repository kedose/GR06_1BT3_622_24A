package com.poliweb.controladores;

import static org.mockito.Mockito.*;

import com.poliweb.modelo.Ruta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import persistencia.RutaJpaController;

import java.util.ArrayList;
import java.util.List;

public class RutaControllerTest {

    @Mock
    private RutaJpaController mockRutaJpaController;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    private RutaController rutaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Inyectar el mock en el controlador
        rutaController = new RutaController(mockRutaJpaController);
    }

    @Test
    public void testDoGetExitoso() throws Exception {
        // Crear datos simulados con todos los parámetros del constructor
        List<Ruta> rutasSimuladas = new ArrayList<>();
        rutasSimuladas.add(new Ruta(1L, "Ruta 1", "Parada 1", "10:00 AM", "Teatro", "https://linkalmapa1.com"));
        rutasSimuladas.add(new Ruta(2L, "Ruta 2", "Parada 2", "11:00 AM", "Sistemas", "https://linkalmapa2.com"));

        // Configurar el mock para devolver los datos simulados
        when(mockRutaJpaController.obtenerTodasLasRutas()).thenReturn(rutasSimuladas);
        when(request.getRequestDispatcher("polibus.jsp")).thenReturn(requestDispatcher);

        // Llamar al método doGet
        rutaController.doGet(request, response);

        // Verificar que los atributos fueron establecidos correctamente
        verify(request).setAttribute("rutas", rutasSimuladas);
        verify(requestDispatcher).forward(request, response);

        // Verificar que no ocurrió ningún error
        verify(response, never()).sendError(anyInt(), anyString());
    }

    @Test
    public void testDoGetConError() throws Exception {
        // Simular una excepción en el acceso a la base de datos
        when(mockRutaJpaController.obtenerTodasLasRutas()).thenThrow(new RuntimeException("Error en la BD"));
        // Llamar al método doGet
        rutaController.doGet(request, response);
        // Verificar que se envió el error correctamente
        verify(response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la consulta");
    }
}
