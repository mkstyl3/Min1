package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Item;
import edu.upc.dsa.Model.User;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static edu.upc.dsa.Controller.EetakemonManagerImpl.*;

@Path("/user")
@Singleton //We need it to say jersey to use an unique instance
public class EetakemonManagerService {

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
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersService() {
        return getInstance().getAll();
    }

    @GET
    @Path("/allSortedByUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersSortedByUsernameService() {
        return getInstance().getAllSortedByUsername();
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean editService(User u) {
        return getInstance().edit(u);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getService(@PathParam("id") int id) {
        return getInstance().get(id);
    }

    @GET
    @Path("/{id}/items/allItems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getItemsService(@PathParam("id") int userId){
        return getInstance().getItems(userId);
    }

    @POST
    @Path("/{id}/items/setItem")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean setItemService(@PathParam("id") int userId, Item i){
        return getInstance().setItem(userId,i);
    }
}
