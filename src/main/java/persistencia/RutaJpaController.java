package persistencia;

import com.poliweb.Ruta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class RutaJpaController implements Serializable {

    private static RutaJpaController instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    RutaJpaController() {
        emf = Persistence.createEntityManagerFactory("EjemploJavaWebPU");
        em = emf.createEntityManager(); // Mantener la conexión abierta
    }

    public static RutaJpaController getInstance() {
        if (instance == null) {
            instance = new RutaJpaController();
        }
        return instance;
    }

    public List<Ruta> buscarRutaPorParadas(String paradas) {
        try {
            Query query = em.createQuery("SELECT r FROM Ruta r WHERE r.paradas LIKE :paradas");
            query.setParameter("paradas", "%" + paradas + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Ruta> obtenerTodasLasRutas() {
        try {
            Query query = em.createQuery("SELECT r FROM Ruta r");
            List<Ruta> rutas = query.getResultList();

            // Imprimir la cantidad de rutas recuperadas
             System.out.println("Número de rutas recuperadas:\n ");
            System.out.println("Número de rutas recuperadas: " + rutas.size());

            // Imprimir cada ruta recuperada
            for (Ruta ruta : rutas) {
                System.out.println("Ruta: " + ruta.getNombreRuta() + ", Paradas: " + ruta.getParadas() + ", Horario: " + ruta.getHorario());
            }

            return rutas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarBusesEnConsola() {
        try {
            Query query = em.createQuery("SELECT b FROM Ruta b");
            List<Ruta> buses = query.getResultList();

            System.out.println("Número de buses recuperados: " + buses.size());
            for (Ruta bus : buses) {
                System.out.println("ID: " + bus.getIdBus() + ", Ruta: " + bus.getNombreRuta()
                        + ", Paradas: " + bus.getParadas() + ", Horario: " + bus.getHorario());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
    
    public EntityManager getEntityManager() {
    if (em == null || !em.isOpen()) {
        em = emf.createEntityManager(); // Crear una nueva instancia si no está disponible o abierta
    }
    return em;
}


}
