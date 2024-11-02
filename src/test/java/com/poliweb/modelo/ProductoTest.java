package com.poliweb.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductoTest {

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
        assertEquals("Libro de Java", resultados.get(0).getNombreProducto());
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


}
