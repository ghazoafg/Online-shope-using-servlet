package com.example.demo;

public class Product {
private String name;
private int id;
private double price;
private int quantity;

public Product(int i, String n, double p,int q)
{
    this.id = i;
    this.name = n;
    this.price = p;
    this.quantity = q;
}
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
