package com.poliweb;

import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author USUARIO
 */
public class Controladora {
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    // Método para buscar rutas por paradas (búsqueda parcial)
    public List<Ruta> buscarRutaPorParadas(String paradas) {
        return controlPersis.buscarRutaPorParadas(paradas);
    }
    
    // Método para obtener todas las rutas
    public List<Ruta> obtenerTodasLasRutas() {
        return controlPersis.obtenerTodasLasRutas();
    }
}
