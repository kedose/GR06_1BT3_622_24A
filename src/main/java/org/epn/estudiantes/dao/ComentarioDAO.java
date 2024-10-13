package org.epn.estudiantes.dao;

import org.epn.estudiantes.model.Comentario;
import org.epn.estudiantes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComentarioDAO {

    public void guardarComentario(Comentario comentario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(comentario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Comentario> obtenerComentarios() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Comentario", Comentario.class).list();
        }
    }
}
