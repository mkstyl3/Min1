package edu.upc.dsa.Model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Coffee.class, name = "Coffee"),
        @JsonSubTypes.Type(value = Sandwich.class, name = "Sandwich")
})
public class Product {
    private int cost;

    public int getCost() {
        return cost;
    }
}
