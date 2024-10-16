package com.poliweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/asociaciones")
public class AsociacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear la lista de asociaciones con sus datos
        List<Asociacion> asociaciones = new ArrayList<>();

        asociaciones.add(new Asociacion("AEIO", null, null, null, null));
        asociaciones.add(new Asociacion("E (Ing Electrica)", null, null, null, null));
        asociaciones.add(new Asociacion("AEE-ICEF", null, null, null, null));
        asociaciones.add(new Asociacion("ESFOT", null, null, null, null));
        asociaciones.add(new Asociacion("AGROINDUSTRIAL", null, null, null, null));
        asociaciones.add(new Asociacion(
                "AEIS",
                "La Asociación de Estudiantes de Ingeniería de Sistemas (AEIS) representa a los estudiantes de esta carrera.",
                "contacto@aeis.epn.edu.ec",
                "http://www.aeis.epn.edu.ec",
                "Planes: Talleres de programación, charlas sobre tecnología y apoyo académico."
        ));

        // Otras asociaciones sin detalles
        asociaciones.add(new Asociacion("AEIE", null, null, null, null));
        asociaciones.add(new Asociacion("ASO-MAT", null, null, null, null));
        asociaciones.add(new Asociacion("AEIM", null, null, null, null));
        asociaciones.add(new Asociacion("ING CIVIL", null, null, null, null));
        asociaciones.add(new Asociacion("EFCA", null, null, null, null));
        asociaciones.add(new Asociacion("ING AMBIENTAL", null, null, null, null));
        asociaciones.add(new Asociacion("ING QUIMICA", null, null, null, null));

        // Pasar la lista de asociaciones al JSP
        request.setAttribute("asociaciones", asociaciones);
        request.getRequestDispatcher("asociaciones.jsp").forward(request, response);
    }

    // Clase para representar los datos de cada asociación
    public static class Asociacion {
        private String nombre;
        private String descripcion;
        private String email;
        private String sitioWeb;
        private String planesEstudiantiles;

        public Asociacion(String nombre, String descripcion, String email, String sitioWeb, String planesEstudiantiles) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.email = email;
            this.sitioWeb = sitioWeb;
            this.planesEstudiantiles = planesEstudiantiles;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSitioWeb() {
            return sitioWeb;
        }

        public void setSitioWeb(String sitioWeb) {
            this.sitioWeb = sitioWeb;
        }

        public String getPlanesEstudiantiles() {
            return planesEstudiantiles;
        }

        public void setPlanesEstudiantiles(String planesEstudiantiles) {
            this.planesEstudiantiles = planesEstudiantiles;
        }
    }
}
