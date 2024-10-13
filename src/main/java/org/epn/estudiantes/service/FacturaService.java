package org.epn.estudiantes.service;

import org.epn.estudiantes.dao.FacturaDAO;
import org.epn.estudiantes.model.Factura;

public class FacturaService {
    private final FacturaDAO facturaDAO = new FacturaDAO();

    public void procesarFactura(Factura factura) {
        facturaDAO.guardarFactura(factura);
    }
}
