package org.epn.estudiantes.model;

import javax.persistence.*;

@Entity
@Table(name = "productos_cafeteria")
public class ProductoCafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private String nombre;
    private String descripcion;
    private float precio;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void obtenerDetallesProducto() {
        // Lógica para obtener detalles del producto
    }

    public void listarProductos() {
        // Lógica para listar productos
    }
}
