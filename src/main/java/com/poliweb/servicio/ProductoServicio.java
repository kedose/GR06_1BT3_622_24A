package com.poliweb.servicio;

import com.poliweb.dao.ProductoDAO;
import com.poliweb.modelo.Producto;

import java.util.List;

public class ProductoServicio {

    private ProductoDAO productoDAO = new ProductoDAO();

    public void agregarProducto(Producto producto) {
        productoDAO.guardarProducto(producto); // Utiliza el DAO para guardar el producto
    }

    public void obtenerProductos() {
        List<Producto> productos = productoDAO.obtenerProductos();
        productos.forEach(System.out::println);
    }

    // Otros métodos de servicio que invocan los métodos del DAO
}
