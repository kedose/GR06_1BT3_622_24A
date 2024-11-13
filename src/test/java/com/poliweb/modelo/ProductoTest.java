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
        // Configuración inicial para la clase, se ejecuta una vez antes de todos los tests.
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
        // Probar la validación de un producto con campos vacíos
        try {
            Producto producto = new Producto("", "", "", 0, "", "");
            assertFalse(Producto.validarProducto(producto));  // Espera que el producto no sea válido
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

        // Producto válido con código de 9 dígitos
        Producto codigoEstudianteValido = new Producto("123456789", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        assertTrue(Producto.validarProducto(codigoEstudianteValido));  // Espera que sea válido
    }

    @Test
    public void buscarProductosPorNombreCaseInsensitive() {
        System.out.println("Test 3");
        // Crear productos y agregarlos a la lista
        Producto producto1 = new Producto("12345", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        Producto producto2 = new Producto("67890", "María López", "libro de python", 30.0, "9876543210", "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        // Buscar productos por nombre, ignorando mayúsculas y minúsculas
        List<Producto> resultados = Producto.buscarProductosPorNombre("jaVa");
        assertEquals(1, resultados.size());  // Espera encontrar solo un producto
    }

    @Test
    public void buscarProductosPorRangoDePrecios() {
        System.out.println("Test 4");
        // Crear productos con precios diferentes
        Producto producto1 = new Producto("12345", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        Producto producto2 = new Producto("67890", "María López", "libro de python", 30.0, "9876543210", "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        // Buscar productos en un rango de precios
        List<Producto> resultados = Producto.buscarProductosPorPrecio(20, 30);
        assertEquals(2, resultados.size());  // Espera encontrar dos productos

        resultados = Producto.buscarProductosPorPrecio(25, 30);
        assertEquals(1, resultados.size());  // Espera encontrar solo un producto
    }

    @Test
    public void crearProductoConExito() {
        System.out.println("Test 5");
        // Crear un producto válido
        Producto producto = new Producto("202020475", "Issac", "Libro de Ingles", 15, "0983307662", "1 semana");
        // Este test solo verifica que no haya excepciones al crear el producto
    }

    @Test
    public void buscarProductosSimilares() {
        System.out.println("Test 6");
        // Crear varios productos y agregarlos
        Producto producto1 = new Producto("202020475", "Kevin Donozo", "Libro de Java", 20.0, "1234567890", "1 semana");
        Producto producto2 = new Producto("202020476", "María López", "libro de Ingles Avanzado 1", 30.0, "9876543210", "1 mes");
        Producto producto3 = new Producto("202020477", "Juan Pérez", "libro de Ingles Avanzado 2", 20.0, "1234567890", "1 semana");
        Producto producto4 = new Producto("202020478", "Issac DLC", "libro de Ingles Basico 1", 30.0, "9876543210", "1 mes");

        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);
        Producto.agregarProducto(producto3);
        Producto.agregarProducto(producto4);

        // Buscar productos cuyo nombre contenga la palabra "ingle"
        List<Producto> resultados = Producto.buscarProductosPorNombre("ingle");
        assertEquals(3, resultados.size());  // Espera encontrar tres productos
        // Imprimir los resultados para verificar que los productos encontrados son correctos
        for (Producto producto : resultados) {
            System.out.println(producto.getNombreProducto());
        }
    }

    @Test
    public void crear2ProductosIdenticos() {
        System.out.println("Test 7");
        // Crear dos productos idénticos y agregarlos
        Producto producto1 = new Producto("202020475", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        Producto producto2 = new Producto("202020477", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        Producto.agregarProducto(producto1);
        Producto.agregarProducto(producto2);

        // Verificar que la lista contenga ambos productos
        assertEquals(2, Producto.obtenerProductos().size());  // Espera que la lista tenga dos productos

        // Verificar que ambos productos estén presentes en la lista
        List<Producto> productos = Producto.obtenerProductos();
        assertTrue(productos.contains(producto1));
        assertTrue(productos.contains(producto2));
    }

    @Test
    public void crearProductoSinNumeroContacto() {
        System.out.println("Test 8");
        // Intentar crear un producto sin número de contacto
        try {
            Producto producto1 = new Producto("2020204759", "Juan Pérez", "Libro de Java", 20.0, "", "1 semana");
            assertFalse(Producto.validarProducto(producto1));  // Espera que el producto no sea válido
        }
        catch (Exception e) {
            System.out.println("Error al validar el producto: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
        // Limpieza después de cada prueba
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
        // Limpieza después de todas las pruebas
    }
}
