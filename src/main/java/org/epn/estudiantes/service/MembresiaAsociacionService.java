package org.epn.estudiantes.service;

import org.epn.estudiantes.dao.MembresiaAsociacionDAO;
import org.epn.estudiantes.model.MembresiaAsociacion;

import java.util.List;

public class MembresiaAsociacionService {
    private final MembresiaAsociacionDAO membresiaDAO = new MembresiaAsociacionDAO();

    public void agregarMembresia(MembresiaAsociacion membresia) {
        membresiaDAO.guardarMembresia(membresia);
    }

    public List<MembresiaAsociacion> obtenerMembresias() {
        return membresiaDAO.obtenerMembresias();
    }
}
