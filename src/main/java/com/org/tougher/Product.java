package com.org.tougher;

import java.time.LocalDate;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private List<Review> reviews;

    public Product(String id, String name, double price, String category, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
