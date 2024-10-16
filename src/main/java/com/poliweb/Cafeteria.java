package com.poliweb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreMenu;
    private String descripcionMenu;
    private Double precio;
    private String tipoMenu;

    public Cafeteria(Long id, String nombreMenu, String descripcionMenu, Double precio, String tipoMenu) {
        this.id = id;
        this.nombreMenu = nombreMenu;
        this.descripcionMenu = descripcionMenu;
        this.precio = precio;
        this.tipoMenu = tipoMenu;
    }

    public Cafeteria() {

    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

}
