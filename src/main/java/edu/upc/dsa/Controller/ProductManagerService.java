package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static edu.upc.dsa.Controller.ProductManagerImpl.*;

@Path("/orders")
@Singleton //We need it to say jersey to use an unique instance
public class ProductManagerService {


    //Testing purposes "/products"
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/products/getAllSortedByCost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsSortedByCostService() {
        return getInstance().getAllServedProductsSortedByCost();
    }

    @POST
    @Path("/{id}/makeOrder")
    public Boolean makeOrderService(@PathParam("id") int userId, List<Product> products) {
        return getInstance().makeOrder(userId, products);
    }

    @GET
    @Path("/serve")
    public boolean serveOrder()  {
        return getInstance().serveOrder();
    }

    @GET
    @Path("/products/{id}/getAllUserOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllServedUserOrders(@PathParam("id") int userId){
        return getInstance().getAllServedUserOrders(userId);
    }

    @GET
    @Path("/products/getAllSortedBySales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllSortedBySalesService(){
        return getInstance().getAllProductsSortedByNoSales();
    }

    @POST
    @Path("/userLogin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User loginService(User u) {
        return getInstance().login(u);
    }
}
