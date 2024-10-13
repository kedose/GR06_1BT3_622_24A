package org.epn.estudiantes.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carritos")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;

    @OneToMany
    private List<ProductoCafeteria> productos;
    private float total;

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<ProductoCafeteria> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCafeteria> productos) {
        this.productos = productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void agregarProducto(ProductoCafeteria producto) {
        // Lógica para agregar producto al carrito
    }

    public void eliminarProducto(ProductoCafeteria producto) {
        // Lógica para eliminar producto del carrito
    }

    public void calcularTotal() {
        // Lógica para calcular el total
    }
}
