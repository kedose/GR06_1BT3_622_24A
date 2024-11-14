package com.poliweb.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RutaTest {

    @Test
    public void testConstructor() {
        // Usamos todos los parámetros requeridos por el constructor
        Ruta ruta = new Ruta(1L, "Ruta 1", "Parada 1", "10:00 AM", "Teatro", "https://linkalmapa1.com");

        // Verificamos que todos los parámetros se hayan asignado correctamente
        assertEquals(1L, ruta.getIdBus());
        assertEquals("Ruta 1", ruta.getNombreRuta());
        assertEquals("Parada 1", ruta.getParadas());
        assertEquals("10:00 AM", ruta.getHorario());
        assertEquals("Teatro", ruta.getUbicacion());  // Verificamos el nuevo campo
        assertEquals("https://linkalmapa1.com", ruta.getMapaUrl());  // Verificamos el nuevo campo
    }

    @Test
    public void testSettersAndGetters() {
        // Creamos una nueva instancia con el constructor por defecto
        Ruta ruta = new Ruta();

        // Usamos los setters para asignar valores
        ruta.setIdBus(2L);
        ruta.setNombreRuta("Ruta 2");
        ruta.setParadas("Parada 2");
        ruta.setHorario("11:00 AM");
        ruta.setUbicacion("Sistemas");
        ruta.setMapaUrl("https://linkalmapa2.com");

        // Verificamos que los valores se hayan asignado correctamente
        assertEquals(2L, ruta.getIdBus());
        assertEquals("Ruta 2", ruta.getNombreRuta());
        assertEquals("Parada 2", ruta.getParadas());
        assertEquals("11:00 AM", ruta.getHorario());
        assertEquals("Sistemas", ruta.getUbicacion());  // Verificamos el nuevo campo
        assertEquals("https://linkalmapa2.com", ruta.getMapaUrl());  // Verificamos el nuevo campo
    }

    @Test
    public void testToString() {
        // Creamos una nueva instancia con todos los parámetros
        Ruta ruta = new Ruta(1L, "Ruta 1", "Parada 1", "10:00 AM", "Teatro", "https://linkalmapa1.com");

        // Verificamos el resultado del método toString()
        String expected = "Nombre de la Ruta: Ruta 1, Paradas: Parada 1, Horario: 10:00 AM, Ubicación: Teatro, Mapa URL: https://linkalmapa1.com";
        assertEquals(expected, ruta.toString());
    }
}
