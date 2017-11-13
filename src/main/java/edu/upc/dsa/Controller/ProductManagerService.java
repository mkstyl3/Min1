package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static edu.upc.dsa.Controller.ProductManagerImpl.*;

@Path("/products")
@Singleton //We need it to say jersey to use an unique instance
public class ProductManagerService {

    //Testing purposes "/products"
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @POST
    @Path("/{id}/makeOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean makeOrderService(@PathParam("id") int userId, ArrayList<Product> products) {
        return getInstance().makeOrder(userId, products);
    }

    @GET
    @Path("/served/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllServedProducts() {
        return getInstance().getAllServedProductsSortedByCost();
    }

    @GET
    @Path("/served/getAllSortedByCost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsSortedByCostService() {
        return getInstance().getAllServedProductsSortedByCost();
    }

    @GET
    @Path("/order/serve")
    public boolean serveOrder()  {
        return getInstance().serveOrder();
    }

    @GET
    @Path("/{id}/AllServedOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllServedUserOrders(@PathParam("id") int userId){
        return getInstance().getAllServedUserOrders(userId);
    }

    @GET
    @Path("/served/AllSortedByNoSales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> setItemService(){
        return getInstance().getAllProductsSortedByNoSales();
    }
}
