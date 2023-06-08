package com.example.shopapp;

public class Product {
    private int id;
    private String name;
    private String image;
    private double price;
    private int quantity;
    private String description;

    public Product(int id, String name, String image, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}
