package edu.upc.dsa.Model;


import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //Variable declaration

    private int id;
    private List<Product> products;
    private int userId;
    private boolean done;

    public boolean isDone() {
        return done;
    }

    //Constructors

    public Order(int userId, int id, boolean done, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.done = done;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }



}
