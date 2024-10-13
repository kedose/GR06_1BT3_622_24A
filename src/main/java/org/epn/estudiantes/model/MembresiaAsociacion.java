package org.epn.estudiantes.model;

import javax.persistence.*;

@Entity
@Table(name = "membresias_asociacion")
public class MembresiaAsociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMembresia;

    private String asociacion;
    private String beneficios;
    private String tipo;
    private float precio;

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void listarBeneficios() {
        // Lógica para listar beneficios
    }

    public void obtenerDetallesMembresia() {
        // Lógica para obtener detalles de la membresía
    }
}
