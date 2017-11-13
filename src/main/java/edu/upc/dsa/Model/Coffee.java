package edu.upc.dsa.Model;

public class Coffee extends Product {
    final private String name = "Coffee";

    public Coffee(int id, int cost) {
        super(id, cost);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
