package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static edu.upc.dsa.Controller.ProductManagerImpl.*;

@Path("/user")
@Singleton //We need it to say jersey to use an unique instance
public class ProductManagerService {

    //Testing purposes "/user"
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @POST
    @Path("/set")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean createUserService(User u) {
        return getInstance().set(u);
    }

    @GET
    @Path("/{id}/products/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsService(@PathParam("id") int userId) {
        return getInstance().getAllProducts(userId);
    }

    @GET
    @Path("/{id}/products/allProductsSortedByCost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsSortedByCostService(@PathParam("id") int userId) {
        return getInstance().getAllProductsSortedByCost(userId);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getService(@PathParam("id") int id) {
        return getInstance().get(id);
    }

    @GET
    @Path("/{id}/orders/allOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getItemsService(@PathParam("id") int userId){
        return getInstance().getOrders(userId);
    }

    @POST
    @Path("/{id}/orders/setOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean setItemService(@PathParam("id") int userId, Order o){
        return getInstance().setOrder(userId,o);
    }
}
