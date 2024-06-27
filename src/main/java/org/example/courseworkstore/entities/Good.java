package org.example.courseworkstore.entities;

public class Good {
    private final String name;
    private String description;
    private String producer;
    private int quantity;
    private double price;
    private String category;

    public Good(String name) {
        this.name = name;
    }

    public Good(String name, String description, String producer, int quantity, double price, String category) {
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProducer() {
        return producer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
}

