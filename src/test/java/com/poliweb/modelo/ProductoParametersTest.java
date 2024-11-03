package com.poliweb.modelo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProductoParametersTest {
    private String codigoEstudiante;
    private String nombreEstudiante;
    private String nombreProducto;
    private double precioProducto;
    private String numeroContacto;
    private String tiempoVisualizacion;
    private Producto producto;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"123456789", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana"});
        objects.add(new Object[]{"987654321", "María López", "Libro de Python", 30.0, "9876543210", "1 mes"});
        objects.add(new Object[]{"135792468", "Carlos Ruiz", "Curso de C#", 25.0, "1357924680", "2 semanas"});
        objects.add(new Object[]{"246813579", "Ana Gómez", "Curso de Python", 35.0, "2468135790", "1 mes"});
        objects.add(new Object[]{"369258147", "Pedro Pérez", "Curso de Java", 40.0, "3692581470", "3 semanas"});
        return objects;
    }

    public ProductoParametersTest(String codigoEstudiante, String nombreEstudiante, String nombreProducto,
                                  double precioProducto, String numeroContacto, String tiempoVisualizacion) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.numeroContacto = numeroContacto;
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    @Before
    public void setUp() {
        Producto.limpiarProductos(); // Limpiar lista de productos antes de cada prueba
    }

    @Test
    public void given_parameters_when_validarProducto_then_ok() {
        try {
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);
            assertTrue(Producto.validarProducto(producto));
        } catch (Exception e) {
            fail("Error al validar el producto: " + e.getMessage());
        }
    }

    @Test
    public void given_parameters_when_buscarProductosPorNombre_then_ok() {
        try {
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);
            Producto.agregarProducto(producto);
            List<Producto> resultados = Producto.buscarProductosPorNombre(nombreProducto);
            assertEquals(1, resultados.size());
            assertEquals(nombreProducto, resultados.get(0).getNombreProducto());
        } catch (NoProductosEncontradosException e) {
            fail("No se encontraron productos por nombre cuando se esperaba al menos uno: " + e.getMessage());
        }
    }

    @Test
    public void given_parameters_when_buscarProductosPorPrecio_then_ok() {
        try {
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);
            Producto.agregarProducto(producto);
            List<Producto> resultados = Producto.buscarProductosPorPrecio(precioProducto - 5, precioProducto + 5);
            assertEquals(1, resultados.size());
            assertEquals(precioProducto, resultados.get(0).getPrecioProducto(), 0);
        } catch (NoProductosEncontradosException e) {
            fail("No se encontraron productos por precio cuando se esperaba al menos uno: " + e.getMessage());
        }
    }
}
