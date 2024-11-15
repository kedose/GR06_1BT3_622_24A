package com.poliweb.modelo;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "cafeteria") // Indica que esta entidad corresponde a la tabla 'cafeteria'
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cafeteria;
    private String nombreMenu;
    private String descripcionMenu;
    private Double precio;
    private String tipoMenu;

    public Cafeteria(Long id, String nombreMenu, String descripcionMenu, Double precio, String tipoMenu) {
        this.id_cafeteria = id;
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

    public Long getId_cafeteria() {
        return id_cafeteria;
    }

    public void setId_cafeteria(Long id) {
        this.id_cafeteria = id;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getPrecioFormateado() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(precio);
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "id_cafeteria=" + id_cafeteria +
                ", nombreMenu='" + nombreMenu + '\'' +
                ", descripcionMenu='" + descripcionMenu + '\'' +
                ", precio=" + precio +
                ", tipoMenu='" + tipoMenu + '\'' +
                '}';
    }
}

