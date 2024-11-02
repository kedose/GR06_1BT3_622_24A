package com.poliweb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private static List<Producto> listaProductos = new ArrayList<>(); // Lista estática para almacenar productos

    private String codigoEstudiante;
    private String nombreEstudiante;
    private String nombreProducto;
    private double precioProducto;
    private String numeroContacto;
    private String tiempoVisualizacion;

    public Producto(String codigoEstudiante, String nombreEstudiante, String nombreProducto, double precioProducto, String numeroContacto, String tiempoVisualizacion) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.numeroContacto = numeroContacto;
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    public static void agregarProducto(Producto producto) {
        if (producto != null) {
            listaProductos.add(producto); // Añade el producto a la lista
        }
    }

    public static List<Producto> obtenerProductos() {
        return new ArrayList<>(listaProductos); // Retorna una copia de la lista para evitar modificaciones externas
    }

    public static List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    public static List<Producto> buscarProductosPorPrecio(double precioMinimo, double precioMaximo) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getPrecioProducto() >= precioMinimo && producto.getPrecioProducto() <= precioMaximo) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    // Getters para acceder a los atributos
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getNombreProducto() { return nombreProducto; }
    public double getPrecioProducto() { return precioProducto; }
    public String getNumeroContacto() { return numeroContacto; }
    public String getTiempoVisualizacion() { return tiempoVisualizacion; }
}
