package com.poliweb.modelo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity // Define que la clase es una entidad
@Table(name = "usuario" )
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigoUnico;
    private String nombre;
    private String apellido;
    private String correo;

    // Constructores

    public Usuario() {
    }

    public Usuario(String codigoUnico, String nombre, String apellido, String correo) {
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    // Getters y Setters

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String cedula) {
        this.codigoUnico = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}