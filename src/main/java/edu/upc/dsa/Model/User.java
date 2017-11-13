package edu.upc.dsa.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    //Private atributes

    private int id;
    private String username;
    private List<Order> orders;

    //Constructors

    public User () {
        this.orders = new ArrayList<>();
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.orders = new ArrayList<>();

    }

    //Getters and Sertters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    //Getters and Setters from "orders" (It's a list)

    public void setOrder (Order order) {
        this.orders.add(order);
    }

    public Order getOrder (int id) {
        for (Order o: this.orders) {
            if (o.getId() == id) return o;
        }
        return null;
    }
}
