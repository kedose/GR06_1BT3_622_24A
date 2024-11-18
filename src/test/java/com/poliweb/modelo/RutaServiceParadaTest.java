package com.poliweb.modelo;

import com.poliweb.modelo.Ruta;
import com.poliweb.modelo.RutaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RutaServiceParadaTest {

    private final List<Ruta> rutas;
    private final String nombreParada;
    private final List<Ruta> rutasEsperadas;

    public RutaServiceParadaTest(List<Ruta> rutas, String nombreParada, List<Ruta> rutasEsperadas) {
        this.rutas = rutas;
        this.nombreParada = nombreParada;
        this.rutasEsperadas = rutasEsperadas;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        // Datos de prueba para el primer caso
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Parada A",
                        Arrays.asList(new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"))
                },
                {
                        // Datos de prueba para el segundo caso
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Parada D",
                        Arrays.asList(new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com"))
                },
                {
                        // Datos de prueba para el tercer caso (parada en varias rutas)
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B, Parada E", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D, Parada E", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Parada E",
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B, Parada E", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D, Parada E", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        )
                },
                {
                        // Datos de prueba para el cuarto caso (parada no encontrada)
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Parada F",
                        Arrays.asList() // Lista vacía
                }
        });
    }

    @Test
    public void testBuscarRutaPorParada() {
        RutaService service = new RutaService();
        List<Ruta> resultado = service.buscarRutaPorParada(rutas, nombreParada);

        assertEquals(rutasEsperadas.size(), resultado.size()); // Verificar el tamaño de las listas primero

        for (int i = 0; i < rutasEsperadas.size(); i++) {
            Ruta rutaEsperada = rutasEsperadas.get(i);
            Ruta rutaResultado = resultado.get(i);

            // Asegurar que ambos objetos Ruta tengan los mismos valores en sus atributos
            assertEquals(rutaEsperada.getIdBus(), rutaResultado.getIdBus());
            assertEquals(rutaEsperada.getNombreRuta(), rutaResultado.getNombreRuta());
            assertEquals(rutaEsperada.getParadas(), rutaResultado.getParadas());
            assertEquals(rutaEsperada.getHorario(), rutaResultado.getHorario());
            assertEquals(rutaEsperada.getUbicacion(), rutaResultado.getUbicacion());
            assertEquals(rutaEsperada.getMapaUrl(), rutaResultado.getMapaUrl());
        }
    }
}