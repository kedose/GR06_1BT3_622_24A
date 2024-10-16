package com.poliweb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "buses") // Indica que esta entidad corresponde a la tabla 'buses'
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Genera un ID autoincremental
    private Long id_bus; // ID único para la ruta

    private String ruta; // Nombre de la ruta
    private String paradas; // Paradas de la ruta
    private String horario; // Horario de la ruta

    public Ruta() {
        // Constructor por defecto requerido por JPA
    }

    public Ruta(Long id_bus, String ruta, String paradas, String horario) {
        this.id_bus = id_bus;
        this.ruta = ruta;
        this.paradas = paradas;
        this.horario = horario;
    }

    public Long getIdBus() {
        return id_bus;
    }

    public void setIdBus(Long id_bus) {
        this.id_bus = id_bus;
    }

    public String getNombreRuta() {
        return ruta;
    }

    public void setNombreRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getParadas() {
        return paradas;
    }

    public void setParadas(String paradas) {
        this.paradas = paradas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Nombre de la Ruta: " + ruta + ", Paradas: " + paradas + ", Horario: " + horario;
    }

}
