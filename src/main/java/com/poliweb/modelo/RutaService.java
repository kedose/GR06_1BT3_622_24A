package com.poliweb.modelo;

import com.poliweb.modelo.Ruta;
import java.util.List;

public class RutaService {

    public Ruta buscarRutaPorNombre(List<Ruta> rutas, String nombreRuta) {
        for (Ruta ruta : rutas) {
            if (ruta.getNombreRuta().equals(nombreRuta)) {
                return ruta;
            }
        }
        return null;
    }
}