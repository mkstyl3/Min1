package edu.upc.dsa.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    //Private atributes

    private int id;
    private String username;
    private Order order;

    //Constructors

    public User () {
        this.order = new Order();
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.order = new Order();

    }

    //Getters and Sertters

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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

}
