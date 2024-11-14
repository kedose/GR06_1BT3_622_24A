package com.poliweb.modelo;

import java.util.List;

public class Plan {
    private int id;
    private String name;
    private double price;
    private List<String> features;

    // Constructor
    public Plan(int id, String name, double price, List<String> features) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.features = features;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
