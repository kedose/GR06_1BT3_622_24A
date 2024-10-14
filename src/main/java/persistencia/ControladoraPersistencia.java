package persistencia;

import com.poliweb.Ruta;
import java.util.Collections;

/**
 *
 * @author USUARIO
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    private final RutaJpaController rutaJpa;
    private static final Logger LOGGER = Logger.getLogger(ControladoraPersistencia.class.getName());

    // Constructor
    public ControladoraPersistencia() {
        rutaJpa = new RutaJpaController(); // Inicializa el controlador JPA
    }

    // Método para buscar rutas por paradas (búsqueda parcial)
    public List<Ruta> buscarRutaPorParadas(String paradas) {
        try {
            return rutaJpa.buscarRutaPorParadas(paradas);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al buscar rutas por paradas: " + paradas, e);
            return null; // O lanzar una excepción personalizada
        }
    }
    
   public List<Ruta> obtenerTodasLasRutas() {
    try {
        List<Ruta> rutas = rutaJpa.obtenerTodasLasRutas();
        
        // Forzar la recarga desde la base de datos
        for (Ruta ruta : rutas) {
            rutaJpa.getEntityManager().refresh(ruta); // Recargar cada entidad desde la base de datos
        }
        
        return rutas;
    } catch (Exception e) {
        return Collections.emptyList(); // Cambia a una lista vacía en caso de error
    }
}


    
    // Método para mostrar buses en consola
    public void mostrarBusesEnConsola() {
        List<Ruta> rutas = obtenerTodasLasRutas();
        if (rutas != null) {
            System.out.println("Número de rutas recuperadas: " + rutas.size());
            for (Ruta ruta : rutas) {
                System.out.println("Ruta: " + ruta.getNombreRuta() + ", Paradas: " + ruta.getParadas() + ", Horario: " + ruta.getHorario());            
            }
        } else {
            System.out.println("No se pudieron recuperar las rutas.");
        }
    }
    
}

