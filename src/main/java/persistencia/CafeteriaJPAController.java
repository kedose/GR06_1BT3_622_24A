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
    private static final Logger logger = Logger.getLogger(CafeteriaJPAController.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    public CafeteriaJPAController() {
        emf = Persistence.createEntityManagerFactory("EjemploJavaWebPU");
    }

    public static CafeteriaJPAController getInstance() {
        if (instance == null) {
            instance = new CafeteriaJPAController();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Cafeteria> obtenerMenu() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cafeteria c");
            List<Cafeteria> menu = query.getResultList();

            logger.info("Número de elementos en el menú recuperados: " + menu.size());
            for (Cafeteria item : menu) {
                logger.info("Nombre: " + item.getNombreMenu() + ", Descripción: " + item.getDescripcionMenu() + ", Precio: " + item.getPrecio() + ", Tipo: " + item.getTipoMenu());
            }

            return menu;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error obteniendo el menú de la cafetería", e);
            return null;
        } finally {
            em.close();
        }
    }
}
