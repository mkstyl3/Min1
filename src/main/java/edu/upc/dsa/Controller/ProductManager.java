package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;

import java.util.List;

public interface ProductManager {

    List<Product> getAllProductsSortedByCost(int userId);
    public Boolean serveOrder(int userId);
    boolean set(User u);
    User get(int id);
    List<Order> getOrders(int userId);
    boolean setOrder(int userId, Order o);
    List<Product> getAllProducts(int userId);
    List<Order> getAllDoneOrders (int userId);
    List<Product> getAllProductsOrderesByNoSales(int userId);
}
