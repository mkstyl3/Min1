package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;

import java.util.List;

public interface ProductManager {

    boolean makeOrder (int userId, List<Product> products);
    boolean serveOrder();
    List<Product> getAllServedProductsSortedByCost();
    List<Order> getAllServedUserOrders(int userId);
    List<Product> getAllProductsSortedByNoSales();
    User login(User u);
}
