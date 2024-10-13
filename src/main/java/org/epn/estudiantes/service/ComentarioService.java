package org.epn.estudiantes.service;

import org.epn.estudiantes.dao.ComentarioDAO;
import org.epn.estudiantes.model.Comentario;

import java.util.List;

public class ComentarioService {
    private final ComentarioDAO comentarioDAO = new ComentarioDAO();

    public void agregarComentario(Comentario comentario) {
        comentarioDAO.guardarComentario(comentario);
    }

    public List<Comentario> obtenerComentarios() {
        return comentarioDAO.obtenerComentarios();
    }
}
