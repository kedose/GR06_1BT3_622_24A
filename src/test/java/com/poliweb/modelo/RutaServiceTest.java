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
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(Parameterized.class)
public class RutaServiceTest {
    private final List<Ruta> rutas;
    private final String nombreRuta;
    private final Ruta rutaEsperada;

    public RutaServiceTest(List<Ruta> rutas, String nombreRuta, Ruta rutaEsperada) {
        this.rutas = rutas;
        this.nombreRuta = nombreRuta;
        this.rutaEsperada = rutaEsperada;
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
                        "Ruta 1",
                        new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com")
                },
                {
                        // Datos de prueba para el segundo caso
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Ruta 2",
                        new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                },
                {
                        // Datos de prueba para el tercer caso (ruta no encontrada)
                        Arrays.asList(
                                new Ruta(1L, "Ruta 1", "Parada A, Parada B", "7:00 - 19:00", "Bloque A", "mapa1.com"),
                                new Ruta(2L, "Ruta 2", "Parada C, Parada D", "8:00 - 20:00", "Bloque B", "mapa2.com")
                        ),
                        "Ruta 3",
                        null
                }
        });
    }

    @Test
    public void testBuscarRutaPorNombre() {
        RutaService service = new RutaService();
        Ruta resultado = service.buscarRutaPorNombre(rutas, nombreRuta);

        if (rutaEsperada != null) {
            // Asegurar que ambos objetos Ruta tengan los mismos valores en sus atributos
            assertEquals(rutaEsperada.getIdBus(), resultado.getIdBus());
            assertEquals(rutaEsperada.getNombreRuta(), resultado.getNombreRuta());
            assertEquals(rutaEsperada.getParadas(), resultado.getParadas());
            assertEquals(rutaEsperada.getHorario(), resultado.getHorario());
            assertEquals(rutaEsperada.getUbicacion(), resultado.getUbicacion());
            assertEquals(rutaEsperada.getMapaUrl(), resultado.getMapaUrl());
        } else {
            // Verificar que el resultado sea nulo si no se espera encontrar una ruta
            assertNull(resultado);
        }
    }
}
