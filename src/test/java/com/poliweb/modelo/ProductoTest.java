package com.poliweb.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductoTest {

    @BeforeEach
    public void setUp() {
        // Limpiar la lista de productos antes de cada prueba
        Producto.limpiarProductos();
    }

    @Test
    public void validarProductoConCamposVacios() {
        try {
            Producto producto = new Producto("", "", "", 0, "", "");
            assertFalse(Producto.validarProducto(producto));
        }
        catch (Exception e) {
            System.out.println("Error al validar el producto: " + e.getMessage());
        }
    }

    @Test
    public void validarFormatoCodigoEstudiante() {
        try {
            Producto productoInvalido = new Producto("ABC123", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
            assertFalse(Producto.validarProducto(productoInvalido));
        }
        catch (Exception e) {
            System.out.println("Error al validar el producto: " + e.getMessage());
        }

        Producto productoValido = new Producto("12345", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        assertTrue(Producto.validarProducto(productoValido));


    }

    @Test
    public void buscarProductosPorNombreCaseInsensitive() {
        Producto producto1 = new Producto("12345", "Juan Pérez",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("67890", "María López",
                "libro de python", 30.0, "9876543210",
                "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        List<Producto> resultados = Producto.buscarProductosPorNombre("jaVa");
        assertEquals(1, resultados.size());
        //assertEquals("Libro de Java", resultados.get(0).getNombreProducto());
    }

    @Test
    public void buscarProductosPorRangoDePrecios() {

        Producto producto1 = new Producto("12345", "Juan Pérez",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("67890", "María López",
                "libro de python", 30.0, "9876543210",
                "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        List<Producto> resultados = Producto.buscarProductosPorPrecio(20, 30);
        assertEquals(2, resultados.size());

        resultados = Producto.buscarProductosPorPrecio(25, 30);
        assertEquals(1, resultados.size());
    }

    @Test
    public void crearProductoConExito() {
        Producto producto = new Producto("2020", "Issac",
                "Libro de Ingles", 15, "0983307662",
                "1 semana");
        assertTrue(Producto.validarProducto(producto));
    }

    @Test
    public void buscarProductosSimilares() {
        Producto producto1 = new Producto("12345", "Kevin Donozo",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("67890", "María López",
                "libro de Ingles Avanzado 1", 30.0, "9876543210",
                "1 mes");
        Producto producto3 = new Producto("20204", "Juan Pérez",
                "libro de Ingles Avanzado 2", 20.0, "1234567890",
                "1 semana");
        Producto producto4 = new Producto("20201", "Issac DLC",
                "libro de Ingles Basico 1", 30.0, "9876543210",
                "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);
        Producto.agregarProducto(producto3);
        Producto.agregarProducto(producto4);

        List<Producto> resultados = Producto.buscarProductosPorNombre("ingle");
        assertEquals(3, resultados.size());
        // Imprimir los resultados para verificar
        for (Producto producto : resultados) {
            System.out.println(producto.getNombreProducto());
        }

    }

    @Test
    public void crear2ProductosIdenticos() {
        Producto producto1 = new Producto("12345", "Juan Pérez",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("12345", "Juan Pérez",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        // Verifica que el tamaño de la lista sea 2
        assertEquals(2, Producto.obtenerProductos().size());

        // Obtén los productos de la lista y verifica que ambos estén presentes
        List<Producto> productos = Producto.obtenerProductos();
        assertTrue(productos.contains(producto1));
        assertTrue(productos.contains(producto2));

    }

    @Test
    public void crearProductoSinNumeroContacto() {
        try {
            Producto producto1 = new Producto("12345", "Juan Pérez",
                    "Libro de Java", 20.0, "",
                    "1 semana");
            assertFalse(Producto.validarProducto(producto1));
        }
        catch (Exception e) {
            System.out.println("Error al validar el producto: " + e.getMessage());
        }


    }
}
