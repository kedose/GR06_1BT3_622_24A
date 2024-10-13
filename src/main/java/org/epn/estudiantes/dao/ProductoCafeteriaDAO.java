package org.epn.estudiantes.dao;

import org.epn.estudiantes.model.ProductoCafeteria;
import org.epn.estudiantes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoCafeteriaDAO {

    public void guardarProducto(ProductoCafeteria producto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<ProductoCafeteria> obtenerProductos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ProductoCafeteria", ProductoCafeteria.class).list();
        }
    }
}
