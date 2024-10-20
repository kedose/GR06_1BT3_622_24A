package com.poliweb.modelo;

public class Post {
    private String autor;
    private String mensaje;
    private int likes;
    private int comentarios;

    // Constructor
    public Post(String autor, String mensaje, int likes, int comentarios) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.likes = likes;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getComentarios() { return comentarios; }
    public void setComentarios(int comentarios) { this.comentarios = comentarios; }
}
