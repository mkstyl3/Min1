package edu.upc.dsa.Model;


import java.util.ArrayList;
import java.util.List;

public class Order {

    //Variable declaration
    private List<Product> products;
    private int userId;
    private boolean served;



    //Constructors

    public Order(int userId, boolean served, List<Product> products) {
        this.userId = userId;
        this.served = served;
        this.products = products;
    }

    public Order () {
        this.products = new ArrayList<>();
    }

    //Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(int id) {
        return this.products.get(id);
    }

    public void setProduct(Product product) {
        this.products.add(product);
    }

    public boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        this.served = served;
    }



}
