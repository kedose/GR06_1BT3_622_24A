package com.poliweb.modelo;

import com.poliweb.modelo.Ruta;

import java.util.ArrayList;
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

    public List<Ruta> buscarRutaPorParada(List<Ruta> rutas, String nombreParada) {
        List<Ruta> rutasEncontradas = new ArrayList<>();
        for (Ruta ruta : rutas) {
            if (ruta.getParadas().contains(nombreParada)) {
                rutasEncontradas.add(ruta);
            }
        }
        return rutasEncontradas;
    }
}