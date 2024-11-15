package com.poliweb.controladores;

import com.poliweb.modelo.Plan;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/asociaciones")
public class AsociacionController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Plan> planes = obtenerPlanes();
        request.setAttribute("planes", planes);

        // Obtener el plan seleccionado si existe en la solicitud
        String selectedPlanId = request.getParameter("planId");
        if (selectedPlanId != null && !selectedPlanId.isEmpty()) {
            Plan selectedPlan = obtenerPlanes().stream()
                    .filter(plan -> String.valueOf(plan.getId()).equals(selectedPlanId))
                    .findFirst()
                    .orElse(null);
            request.setAttribute("selectedPlan", selectedPlan); // Enviar al JSP
        }

        request.getRequestDispatcher("/asociaciones.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Manejo de solicitudes AJAX
        String planId = request.getParameter("planId");

        // Validación de que el parámetro 'planId' existe y es válido
        if (planId == null || planId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"success\": false, \"message\": \"Plan ID es requerido\"}");
            return;
        }

        // Buscar el plan seleccionado
        Plan planSeleccionado = obtenerPlanes().stream()
                .filter(plan -> String.valueOf(plan.getId()).equals(planId))
                .findFirst()
                .orElse(null);

        if (planSeleccionado != null) {
            // Construir la respuesta JSON manualmente sin usar Gson
            StringBuilder jsonResponse = new StringBuilder();
            jsonResponse.append("{")
                    .append("\"success\": true,")
                    .append("\"producto\": {")
                    .append("\"id\": ").append(planSeleccionado.getId()).append(",")
                    .append("\"nombre\": \"").append(planSeleccionado.getName()).append("\",")
                    .append("\"precio\": ").append(planSeleccionado.getPrice()).append(",")
                    .append("\"caracteristicas\": [");

            for (int i = 0; i < planSeleccionado.getFeatures().size(); i++) {
                jsonResponse.append("\"").append(planSeleccionado.getFeatures().get(i)).append("\"");
                if (i < planSeleccionado.getFeatures().size() - 1) {
                    jsonResponse.append(", ");
                }
            }

            jsonResponse.append("]")
                    .append("}}");

            // Enviar la respuesta como JSON
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        } else {
            // Si no se encuentra el plan con ese ID
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"success\": false, \"message\": \"Plan no encontrado\"}");
        }
    }

    private List<Plan> obtenerPlanes() {
        List<Plan> planes = new ArrayList<>();
        planes.add(new Plan(1, "Plan Básico", 7.99, Arrays.asList("Acceso a eventos básicos", "Descuentos en tutorías", "Carnet de membresía")));
        planes.add(new Plan(2, "Plan Estándar", 12.99, Arrays.asList("Todos los beneficios del Plan Básico", "Acceso a talleres exclusivos", "Descuentos en material didáctico", "Asesoría académica mensual")));
        planes.add(new Plan(3, "Plan Premium", 19.99, Arrays.asList("Todos los beneficios del Plan Estándar", "Acceso prioritario a eventos", "Mentoría personalizada", "Networking con profesionales", "Descuentos especiales en cursos")));
        return planes;
    }



}
