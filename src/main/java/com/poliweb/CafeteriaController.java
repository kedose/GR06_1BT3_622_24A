package com.poliweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cafeteria")
public class CafeteriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear el menú de la cafetería
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Desayuno Continental", "$2.50"));
        menuItems.add(new MenuItem("Almuerzo Ejecutivo", "$3.50"));
        menuItems.add(new MenuItem("Sánduche de Pollo", "$2.00"));
        menuItems.add(new MenuItem("Ensalada César", "$2.75"));
        menuItems.add(new MenuItem("Café Americano", "$1.00"));

        // Pasar la lista de menú al JSP
        request.setAttribute("menuItems", menuItems);
        request.getRequestDispatcher("cafeteria.jsp").forward(request, response);
    }

    // Clase para representar los elementos del menú
    public static class MenuItem {
        private String name;
        private String price;

        public MenuItem(String name, String price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}

