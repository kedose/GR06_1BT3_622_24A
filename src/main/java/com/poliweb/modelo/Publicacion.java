package com.poliweb.modelo;

import jakarta.persistence.*;

@Entity // Define que la clase es una entidad
@Table(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Define la relación de muchos a uno con la entidad Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_codigo_unico")
    private Usuario usuario;
    // Define la relación de muchos a uno con la entidad Producto
    @ManyToOne
    @JoinColumn(name = "producto_id") // Define la llave foránea
    private Producto producto;
    private String fechaPubicacion; // Fecha de publicación
    private String tiempoPubicacion;

    // Constructores
    public Publicacion() {
    }

    public Publicacion(Usuario usuario, Producto producto, String fechaPubicacion, String tiempoPubicacion) {
        this.usuario = usuario;
        this.producto = producto;
        this.fechaPubicacion = fechaPubicacion;
        this.tiempoPubicacion = tiempoPubicacion;
    }

    public Publicacion(int id, Usuario usuario, Producto producto, String fechaPubicacion, String tiempoPubicacion) {
        this.id = id;
        this.usuario = usuario;
        this.producto = producto;
        this.fechaPubicacion = fechaPubicacion;
        this.tiempoPubicacion = tiempoPubicacion;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFechaPubicacion() {
        return fechaPubicacion;
    }

    public void setFechaPubicacion(String fechaPubicacion) {
        this.fechaPubicacion = fechaPubicacion;
    }

    public String getTiempoPubicacion() {
        return tiempoPubicacion;
    }

    public void setTiempoPubicacion(String tiempoPubicacion) {
        this.tiempoPubicacion = tiempoPubicacion;
    }

    // Métodos


}
