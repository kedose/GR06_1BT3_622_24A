package com.poliweb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String autor; // El autor del post
    private String mensaje; // El contenido del post
    private int likes; // Número de "me gusta"
    private List<Comentario> comentarios; // Lista de comentarios

    // Constructor
    public Post(String autor, String mensaje, int likes) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.likes = likes;
        this.comentarios = new ArrayList<>(); // Inicializa la lista de comentarios
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void agregarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public void incrementarLikes() {
        this.likes++;
    }
}

