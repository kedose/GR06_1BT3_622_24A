package com.poliweb.controladores;

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
        // Crear planes para AEIS
        List<Asociacion.Plan> planesAEIS = new ArrayList<>();
        planesAEIS.add(new Asociacion.Plan("Taller de programación", "Aprende los conceptos básicos de programación."));
        planesAEIS.add(new Asociacion.Plan("Charlas sobre tecnología", "Charlas sobre las últimas tendencias tecnológicas."));
        planesAEIS.add(new Asociacion.Plan("Apoyo académico", "Asesoría y tutorías para estudiantes de sistemas."));


        // Crear la lista de asociaciones con sus datos
        List<Asociacion> asociaciones = new ArrayList<>();

        asociaciones.add(new Asociacion("AEIO", null, null, null, null, null));
        asociaciones.add(new Asociacion("E (Ing Electrica)", null, null, null, null, null));
        asociaciones.add(new Asociacion("AEE-ICEF", null, null, null, null, null));
        asociaciones.add(new Asociacion("ESFOT", null, null, null, null, null));
        asociaciones.add(new Asociacion("AGROINDUSTRIAL", null, null, null, null, null));
        asociaciones.add(new Asociacion(
                "AEIS",
                "La Asociación de Estudiantes de Ingeniería de Sistemas (AEIS) representa a los estudiantes de esta carrera.",
                "contacto@aeis.epn.edu.ec",
                "http://www.aeis.epn.edu.ec",
                planesAEIS,
                "Cuenta bancaria: Banco Pichincha, N° 1234567890"
        ));

        // Otras asociaciones sin detalles
        asociaciones.add(new Asociacion("AEIE", null, null, null, null, null));
        asociaciones.add(new Asociacion("ASO-MAT", null, null, null, null, null));
        asociaciones.add(new Asociacion("AEIM", null, null, null, null, null));
        asociaciones.add(new Asociacion("ING CIVIL", null, null, null, null, null));
        asociaciones.add(new Asociacion("EFCA", null, null, null, null, null));
        asociaciones.add(new Asociacion("ING AMBIENTAL", null, null, null, null, null));
        asociaciones.add(new Asociacion("ING QUIMICA", null, null, null, null, null));

        // Obtener la asociación seleccionada y la acción (mostrar planes o mostrar cuenta bancaria)
        String asociacionSeleccionada = request.getParameter("asociacion");
        String accion = request.getParameter("accion");

        // Filtrar la asociación seleccionada si existe
        Asociacion asociacionInfo = null;
        if (asociacionSeleccionada != null) {
            for (Asociacion asociacion : asociaciones) {
                if (asociacion.getNombre().equals(asociacionSeleccionada)) {
                    asociacionInfo = asociacion;
                    break;
                }
            }
        }

        // Verificar si se debe mostrar la cuenta bancaria
        boolean mostrarCuentaBancaria = "mostrarCuenta".equals(accion);
        

        // Pasar la lista de asociaciones, la asociación seleccionada y la bandera de la cuenta bancaria al JSP
        request.setAttribute("asociaciones", asociaciones);
        request.setAttribute("asociacionSeleccionada", asociacionInfo);
        request.setAttribute("mostrarCuentaBancaria", mostrarCuentaBancaria);

        request.getRequestDispatcher("asociaciones.jsp").forward(request, response);
    }

    // Clase para representar los datos de cada asociación
    public static class Asociacion {
        private String nombre;
        private String descripcion;
        private String email;
        private String sitioWeb;
        private List<Plan> planesEstudiantiles;
        private String cuentaBancaria;

        // Constructor
        public Asociacion(String nombre, String descripcion, String email, String sitioWeb, List<Plan> planesEstudiantiles, String cuentaBancaria) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.email = email;
            this.sitioWeb = sitioWeb;
            this.planesEstudiantiles = planesEstudiantiles;
            this.cuentaBancaria = cuentaBancaria;
        }

        // Getters y Setters
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

        public List<Plan> getPlanesEstudiantiles() {
            return planesEstudiantiles;
        }

        public void setPlanesEstudiantiles(List<Plan> planesEstudiantiles) {
            this.planesEstudiantiles = planesEstudiantiles;
        }

        public String getCuentaBancaria() {
            return cuentaBancaria;
        }

        public void setCuentaBancaria(String cuentaBancaria) {
            this.cuentaBancaria = cuentaBancaria;
        }

        // Clase interna Plan
        public static class Plan {
            private String nombre;
            private String descripcion;

            public Plan(String nombre, String descripcion) {
                this.nombre = nombre;
                this.descripcion = descripcion;
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
        }
    }


}
