package edu.upc.dsa.Model;

public class Sandwich extends Product {

    final private String name = "Sandwich";

    public Sandwich(int id, int cost) {
        super(id, cost);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
