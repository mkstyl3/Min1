package edu.upc.dsa.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    //Private atributes

    private int id;
    private String username;

    //Constructors

    public User () {

    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;

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

}
