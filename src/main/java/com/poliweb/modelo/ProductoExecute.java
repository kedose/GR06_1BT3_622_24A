package com.poliweb.modelo;

public class ProductoExecute {
    public static void main(String[] args) {
        System.out.println("== Producto Execute ==");
        Producto producto = new Producto("123456789", "Juan Pérez", "Libro de Java", 20.0, "1234567890", "1 semana");
        System.out.println("Producto: " + producto.toString());
        System.out.println("== It is a change in the code ==");
    }
}
