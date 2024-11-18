package com.poliweb.modelo;

import com.poliweb.modelo.Ruta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RutaService {

    public Ruta buscarRutaPorNombre(List<Ruta> rutas, String nombreRuta) {
        return rutas.stream()
                .filter(ruta -> ruta.getNombreRuta().equals(nombreRuta))
                .findFirst()
                .orElse(null);
    }


    public List<Ruta> buscarRutaPorParada(List<Ruta> rutas, String nombreParada) {
        return rutas.stream()
                .filter(ruta -> ruta.getParadas().contains(nombreParada))
                .collect(Collectors.toList());
    }

}