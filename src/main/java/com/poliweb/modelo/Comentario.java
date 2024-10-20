package com.poliweb.modelo;

import java.time.LocalDateTime;

public class Comentario {
    private String autor; // El autor del comentario
    private String mensaje; // El contenido del comentario
    private LocalDateTime fecha; // La fecha y hora de creación del comentario

    // Constructor
    public Comentario(String autor, String mensaje) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now(); // Inicializa con la fecha y hora actuales
    }

    // Constructor
    public Comentario(String mensaje) {
        this.mensaje = mensaje;
    }


    // Getters y Setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
