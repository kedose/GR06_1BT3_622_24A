package persistencia;

import com.poliweb.modelo.Cafeteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

public class CafeteriaJPAController implements Serializable {

    private static CafeteriaJPAController instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    // Constructor
    public CafeteriaJPAController() {
        emf = Persistence.createEntityManagerFactory("EjemploJavaWebPU");
        em = emf.createEntityManager(); // Mantener la conexión abierta
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
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Cafeteria> obtenerMenu() {
        try {
            Query query = em.createQuery("SELECT c FROM Cafeteria c");
            List<Cafeteria> menu = query.getResultList();

            // Limpiar posibles problemas de codificación
            for (Cafeteria cafeteria : menu) {
                cafeteria.setNombreMenu(new String(cafeteria.getNombreMenu().getBytes("Windows-1252"), "UTF-8"));
                cafeteria.setDescripcionMenu(new String(cafeteria.getDescripcionMenu().getBytes("Windows-1252"), "UTF-8"));
            }

            return menu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
