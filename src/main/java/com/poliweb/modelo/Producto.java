package com.poliweb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    // Atributos estáticos
    private static List<Producto> listaProductos = new ArrayList<>(); // Lista estática para almacenar productos

    // Atributos de instancia
    private String codigoEstudiante;
    private String nombreEstudiante;
    private String nombreProducto;
    private double precioProducto;
    private String numeroContacto;
    private String tiempoVisualizacion;

    // Constructor
    public Producto(String codigoEstudiante, String nombreEstudiante, String nombreProducto, double precioProducto, String numeroContacto, String tiempoVisualizacion) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.numeroContacto = numeroContacto;
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    // Métodos estáticos para gestión de productos
    public static void limpiarProductos() {
        listaProductos.clear();
    }

    public static void agregarProducto(Producto producto) {
        if (producto != null) {
            listaProductos.add(producto); // Añade el producto a la lista
        }
    }

    public static List<Producto> obtenerProductos() {
        return new ArrayList<>(listaProductos); // Retorna una copia de la lista para evitar modificaciones externas
    }

    public static List<Producto> buscarProductosPorNombre(String nombre) throws NoProductosEncontradosException {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(producto);
            }
        }
        if (resultados.isEmpty()) {
            throw new NoProductosEncontradosException("No se encontraron productos con el nombre: " + nombre);
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
        if (resultados.isEmpty()) {
            throw new NoProductosEncontradosException("No se encontraron productos con el precio indicado");
        }
        return resultados;
    }

    public static boolean validarProducto(Producto producto) {
        if (producto == null) {
            throw new ProductoException("El producto no puede ser nulo");
        }
        if (producto.getCodigoEstudiante() == null || producto.getCodigoEstudiante().isEmpty()) {
            throw new ProductoException("El código de estudiante es obligatorio");
        }
        // Validación del formato del código de estudiante (ejemplo: solo números)
        if (!producto.getCodigoEstudiante().matches("\\d{9}")) {
            throw new ProductoException("El código de estudiante debe tener exactamente 9 dígitos numéricos");
        }
        if (producto.getNombreProducto() == null || producto.getNombreProducto().isEmpty()) {
            throw new ProductoException("El nombre del producto es obligatorio");
        }
        if (producto.getPrecioProducto() <= 0) {
            throw new ProductoException("El precio del producto debe ser positivo");
        }
        if (producto.getNumeroContacto() == null || producto.getNumeroContacto().isEmpty()) {
            throw new ProductoException("El número de contacto es obligatorio");
        }
        if (producto.getTiempoVisualizacion() == null || producto.getTiempoVisualizacion().isEmpty()) {
            throw new ProductoException("El tiempo de visualización es obligatorio");
        }
        return true;
    }

    // Getters para acceder a los atributos
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getNombreProducto() { return nombreProducto; }
    public double getPrecioProducto() { return precioProducto; }
    public String getNumeroContacto() { return numeroContacto; }
    public String getTiempoVisualizacion() { return tiempoVisualizacion; }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "codigoEstudiante='" + codigoEstudiante + '\'' +
                ", nombreEstudiante='" + nombreEstudiante + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", numeroContacto='" + numeroContacto + '\'' +
                ", tiempoVisualizacion='" + tiempoVisualizacion + '\'' +
                '}';
    }
}

// Excepciones personalizadas
class ProductoException extends RuntimeException {
    public ProductoException(String message) {
        super(message);
    }
}

class NoProductosEncontradosException extends RuntimeException {
    public NoProductosEncontradosException(String mensaje) {
        super(mensaje);
    }
}