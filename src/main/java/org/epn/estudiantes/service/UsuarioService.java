package org.epn.estudiantes.service;

import org.epn.estudiantes.dao.UsuarioDAO;
import org.epn.estudiantes.model.Usuario;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.guardarUsuario(usuario);
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.obtenerUsuario(id);
    }
}
