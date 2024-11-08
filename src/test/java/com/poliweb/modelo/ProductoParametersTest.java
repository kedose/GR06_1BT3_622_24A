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

    // Método que define los parámetros de entrada para las pruebas parametrizadas
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

    // Constructor que asigna los valores de los parámetros a las variables de instancia
    public ProductoParametersTest(String codigoEstudiante, String nombreEstudiante, String nombreProducto,
                                  double precioProducto, String numeroContacto, String tiempoVisualizacion) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.numeroContacto = numeroContacto;
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    // Método que se ejecuta antes de cada prueba para limpiar la lista de productos
    @Before
    public void setUp() {
        Producto.limpiarProductos(); // Limpiar lista de productos antes de cada prueba
    }

    // Test 1: Verifica que un producto es validado correctamente
    @Test
    public void given_parameters_when_validarProducto_then_ok() {
        System.out.println("Test 1");
        try {
            // Crear el producto con los parámetros pasados
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);

            // Validar el producto
            assertTrue(Producto.validarProducto(producto));
        } catch (Exception e) {
            // Si ocurre un error en la validación, marcar el test como fallido
            fail("Error al validar el producto: " + e.getMessage());
        }
    }

    // Test 2: Verifica que se puede buscar un producto por su nombre
    @Test
    public void given_parameters_when_buscarProductosPorNombre_then_ok() {
        System.out.println("Test 2");
        try {
            // Crear el producto con los parámetros pasados
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);

            // Agregar el producto a la lista
            Producto.agregarProducto(producto);

            // Buscar el producto por su nombre
            List<Producto> resultados = Producto.buscarProductosPorNombre(nombreProducto);

            // Verificar que se haya encontrado exactamente un producto con el nombre esperado
            assertEquals(1, resultados.size());
            assertEquals(nombreProducto, resultados.get(0).getNombreProducto());
        } catch (NoProductosEncontradosException e) {
            // Si no se encuentran productos, marcar el test como fallido
            fail("No se encontraron productos por nombre cuando se esperaba al menos uno: " + e.getMessage());
        }
    }

    // Test 3: Verifica que se puede buscar un producto por su rango de precio
    @Test
    public void given_parameters_when_buscarProductosPorPrecio_then_ok() {
        System.out.println("Test 3");
        try {
            // Crear el producto con los parámetros pasados
            producto = new Producto(codigoEstudiante, nombreEstudiante, nombreProducto, precioProducto, numeroContacto, tiempoVisualizacion);

            // Agregar el producto a la lista
            Producto.agregarProducto(producto);

            // Buscar productos cuyo precio esté en el rango de +- 5 del precio dado
            List<Producto> resultados = Producto.buscarProductosPorPrecio(precioProducto - 5, precioProducto + 5);

            // Verificar que se haya encontrado exactamente un producto con el precio esperado
            assertEquals(1, resultados.size());
            assertEquals(precioProducto, resultados.get(0).getPrecioProducto(), 0);
        } catch (NoProductosEncontradosException e) {
            // Si no se encuentran productos, marcar el test como fallido
            fail("No se encontraron productos por precio cuando se esperaba al menos uno: " + e.getMessage());
        }
    }
}
