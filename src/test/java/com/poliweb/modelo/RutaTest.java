package com.poliweb.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RutaTest {

    @Test
    public void testConstructor() {
        Ruta ruta = new Ruta(1L, "Ruta 1", "Parada 1", "10:00 AM");
        assertEquals(1L, ruta.getIdBus());
        assertEquals("Ruta 1", ruta.getNombreRuta());
        assertEquals("Parada 1", ruta.getParadas());
        assertEquals("10:00 AM", ruta.getHorario());
    }

    @Test
    public void testSettersAndGetters() {
        Ruta ruta = new Ruta();
        ruta.setIdBus(2L);
        ruta.setNombreRuta("Ruta 2");
        ruta.setParadas("Parada 2");
        ruta.setHorario("11:00 AM");

        assertEquals(2L, ruta.getIdBus());
        assertEquals("Ruta 2", ruta.getNombreRuta());
        assertEquals("Parada 2", ruta.getParadas());
        assertEquals("11:00 AM", ruta.getHorario());
    }

    @Test
    public void testToString() {
        Ruta ruta = new Ruta(1L, "Ruta 1", "Parada 1", "10:00 AM");
        assertEquals("Nombre de la Ruta: Ruta 1, Paradas: Parada 1, Horario: 10:00 AM", ruta.toString());
    }
}
