package edu.upc.dsa.Model;

public class Product {

    //Variable declaration

    private int id; //All Apples has same id, All Sandwiches has the same id, All Coffee the same
    private String name; //All Apples has same name, All Sandwiches has the name id, All Coffee the same
    private int cost; //All Apples has same cost, All Sandwiches has the same cost, All Coffee the same


    //Constructors

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}
