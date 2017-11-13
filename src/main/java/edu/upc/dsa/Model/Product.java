package edu.upc.dsa.Model;

public abstract class Product {
    //Variable declarations

    protected int id;
    protected int cost;
    protected int noSales;

    //Constructors

    public Product(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    //Getters and Setters

    //Abstract
    public abstract String getName();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNoSales() {
        return noSales;
    }

    public void setNoSales(int noSales) {
        this.noSales = noSales;
    }
}
