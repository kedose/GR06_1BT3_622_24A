package org.epn.estudiantes.service;

import org.epn.estudiantes.dao.ProductoCafeteriaDAO;
import org.epn.estudiantes.model.ProductoCafeteria;

import java.util.List;

public class ProductoCafeteriaService {
    private final ProductoCafeteriaDAO productoDAO = new ProductoCafeteriaDAO();

    public void agregarProducto(ProductoCafeteria producto) {
        productoDAO.guardarProducto(producto);
    }

    public List<ProductoCafeteria> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }
}
