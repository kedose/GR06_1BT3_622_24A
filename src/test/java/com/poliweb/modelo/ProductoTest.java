package com.poliweb.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductoTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass()");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
        // Limpiar la lista de productos antes de cada prueba
        Producto.limpiarProductos();
    }

    @Test
    public void validarProductoConCamposVacios() {
        System.out.println("Test 1");
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
        System.out.println("Test 2");
        // Producto inválido con código no numérico
        Producto codigoEstudianteInvalido = new Producto("ABC123", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        ProductoException exception = assertThrows(ProductoException.class, () -> Producto.validarProducto(codigoEstudianteInvalido));
        System.out.println("Error al validar el código: " + exception.getMessage());

        // Producto inválido con código que no tiene 9 dígitos
        Producto codigoEstudianteInvalido2 = new Producto("1234", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        exception = assertThrows(ProductoException.class, () -> Producto.validarProducto(codigoEstudianteInvalido2));
        System.out.println("Error al validar el código: " + exception.getMessage());

        // Producto válido
        Producto codigoEstudianteValido = new Producto("123456789", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        assertTrue(Producto.validarProducto(codigoEstudianteValido));
    }

    @Test
    public void buscarProductosPorNombreCaseInsensitive() {
        System.out.println("Test 3");
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
        System.out.println("Test 4");
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
        System.out.println("Test 5");
        Producto producto = new Producto("202020475", "Issac",
                "Libro de Ingles", 15, "0983307662",
                "1 semana");

    }

    @Test
    public void buscarProductosSimilares() {
        System.out.println("Test 6");
        Producto producto1 = new Producto("202020475", "Kevin Donozo",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("202020476", "María López",
                "libro de Ingles Avanzado 1", 30.0, "9876543210",
                "1 mes");
        Producto producto3 = new Producto("202020477", "Juan Pérez",
                "libro de Ingles Avanzado 2", 20.0, "1234567890",
                "1 semana");
        Producto producto4 = new Producto("202020478", "Issac DLC",
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
        System.out.println("Test 7");
        Producto producto1 = new Producto("202020475", "Juan Pérez",
                "Libro de Java", 20.0, "1234567890",
                "1 semana");
        Producto producto2 = new Producto("202020477", "Juan Pérez",
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
        System.out.println("Test 8");
        try {
            Producto producto1 = new Producto("2020204759", "Juan Pérez",
                    "Libro de Java", 20.0, "",
                    "1 semana");
            assertFalse(Producto.validarProducto(producto1));
        }
        catch (Exception e) {
            System.out.println("Error al validar el producto: " + e.getMessage());
        }
    }
    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
    }
}