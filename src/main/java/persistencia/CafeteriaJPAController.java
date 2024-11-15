package persistencia;

import com.poliweb.modelo.Cafeteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CafeteriaJPAController implements Serializable {

    private static CafeteriaJPAController instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(CafeteriaJPAController.class.getName());

    // Static block to set up the logger
    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    // Constructor
    public CafeteriaJPAController() {
        emf = Persistence.createEntityManagerFactory("EjemploJavaWebPU");
        em = emf.createEntityManager(); // Mantener la conexión abierta
        logger.info("CafeteriaJPAController instanciado.");
    }

    public static CafeteriaJPAController getInstance() {
        if (instance == null) {
            instance = new CafeteriaJPAController();
        }
        return instance;
    }

    public void agregarCafeteria(Cafeteria cafeteria) {
        try {
            em.getTransaction().begin();
            em.persist(cafeteria);
            em.getTransaction().commit();
            logger.info("Cafetería agregada: " + cafeteria.getNombreMenu());
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.log(Level.SEVERE, "Error al agregar la cafetería", e);
        }
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Cafeteria> obtenerMenu() {
        EntityManager em = getEntityManager();
        try {
            logger.info("Iniciando la consulta para obtener el menú.");

            Query query = em.createQuery("SELECT r FROM Cafeteria r");
            List<Cafeteria> menu = query.getResultList();

            logger.info("Menú obtenido con éxito. Total de elementos: " + menu.size());

            // Limpiar posibles problemas de codificación
            for (Cafeteria cafeteria : menu) {
                try {
                    cafeteria.setNombreMenu(new String(cafeteria.getNombreMenu().getBytes("Windows-1252"), "UTF-8"));
                    cafeteria.setDescripcionMenu(new String(cafeteria.getDescripcionMenu().getBytes("Windows-1252"), "UTF-8"));
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Error al corregir la codificación para el menú: " + cafeteria.getNombreMenu(), e);
                }
            }

            return menu;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener el menú de la cafetería", e);
            return null;
        } finally {
            em.close();  // Cerrar el EntityManager para liberar recursos
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        logger.info("EntityManager y EntityManagerFactory cerrados.");
    }
}
