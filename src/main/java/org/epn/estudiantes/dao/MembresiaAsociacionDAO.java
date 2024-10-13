package org.epn.estudiantes.dao;

import org.epn.estudiantes.model.MembresiaAsociacion;
import org.epn.estudiantes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MembresiaAsociacionDAO {

    public void guardarMembresia(MembresiaAsociacion membresia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(membresia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<MembresiaAsociacion> obtenerMembresias() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM MembresiaAsociacion", MembresiaAsociacion.class).list();
        }
    }
}
