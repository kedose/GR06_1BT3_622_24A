package com.poliweb.dao;

import com.poliweb.modelo.Producto;
import jakarta.persistence.*;
import java.util.List;

public class ProductoDAO {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tuUnidadDePersistencia"); // Asegúrate de usar el nombre correcto de tu unidad de persistencia
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Método para guardar un producto
    public void guardarProducto(Producto producto) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(producto); // Guarda el producto en la base de datos
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Revierte si ocurre un error
            }
            throw e; // Relanza la excepción para que pueda ser manejada más arriba
        }
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerProductos() {
        TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
        return query.getResultList(); // Devuelve la lista de productos
    }

    // Método para buscar productos por nombre
    public List<Producto> buscarProductosPorNombre(String nombre) {
        TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p WHERE LOWER(p.nombreProducto) LIKE :nombre", Producto.class);
        query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
        return query.getResultList(); // Devuelve la lista de productos con el nombre dado
    }

    // Método para buscar productos por precio
    public List<Producto> buscarProductosPorPrecio(double precioMinimo, double precioMaximo) {
        TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p WHERE p.precioProducto BETWEEN :minPrice AND :maxPrice", Producto.class);
        query.setParameter("minPrice", precioMinimo);
        query.setParameter("maxPrice", precioMaximo);
        return query.getResultList(); // Devuelve los productos dentro del rango de precio
    }

    // Método para actualizar un producto
    public void actualizarProducto(Producto producto) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(producto); // Actualiza el producto en la base de datos
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(Producto producto) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(producto) ? producto : entityManager.merge(producto)); // Elimina el producto de la base de datos
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    // Cerrar recursos de JPA cuando ya no se necesiten
    public void cerrar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
