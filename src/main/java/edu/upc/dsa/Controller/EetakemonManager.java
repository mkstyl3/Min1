package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Item;
import edu.upc.dsa.Model.User;

import java.util.List;

public interface EetakemonManager {

    List<User> getAll();
    boolean set(User u);
    boolean edit(User u);
    User get(int id);
    List<Item> getItems(int userId);
    boolean setItem(int userId, Item i);
}
