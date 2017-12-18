package edu.upc.dsa.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    //Private atributes

    private int id;
    private String username;



    private String password;

    //Constructors

    public User () {

    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;

    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
