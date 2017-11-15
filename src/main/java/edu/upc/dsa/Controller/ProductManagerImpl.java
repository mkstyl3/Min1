package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.*;
import org.apache.log4j.Logger;

import javax.ws.rs.Produces;
import java.util.*;

public class ProductManagerImpl implements ProductManager {

    //Variable declarations

    private static ProductManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);
    private Queue<Order> orders;
    private List<Order> servedOrders;

    //Singleton Pattern

    public static ProductManagerImpl getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }

    //Constructors

    public ProductManagerImpl() {
        this.orders = new ArrayDeque<>();
        this.servedOrders = new ArrayList<>();
    }

    //Getters and Setters

    public Queue<Order> getOrders() {
        return orders;
    }

    public List<Order> getServedOrders() {
        return servedOrders;
    }

    //Public functions

    public List<Product> getAllServedProductsSortedByCost() {
        logger.info("getAllProducts: Retreiving All user products ordered by cost...");
        return sortProductsByCost(getAllServedProducts());
    }

    public boolean makeOrder (int userId, List<Product> products) {
        logger.info("serveOrder: Making an order...");
        this.orders.add(new Order(userId, false, products));

        logger.info("serveOrder: Order sent");
        return true;
    }

    public boolean serveOrder() {
        logger.info("serveOrder: Serving an order..");

        if(!orders.isEmpty()) {
            this.servedOrders.add(this.orders.element());
            this.orders.remove();

            logger.info("serveOrder: An order has been served");
            return true;
        }
        else {
            logger.warn("serveOrder: No orders to serve");
            return false;
        }
    }

    public List<Order> getAllServedUserOrders(int userId) {
        List<Order> temp = new ArrayList<>();
        if (isUserOnQueue(userId)) {
            logger.info("getAllServedUserOrders: Getting all ordered products from userId: "+userId);
            for(Order o : this.servedOrders) {
                if (o.getUserId() == userId)
                    temp.add(o);
            }
            logger.info("getAllServedUserOrders: Historic from userId: "+userId+" retreived");
            return temp;
        }
        else {
            logger.warn("getAllServedUserOrders: There is no historic from id: "+userId);
            return temp;
        }
    }

    public List<Product> getAllProductsSortedByNoSales() {
        if (!servedOrders.isEmpty()) {
            logger.info("sortProductsByNoSales: Sorting all products by no. sales, if no null It's okay");
            return sortProductsByNoSales(getAllServedProducts());
        }
        else {
            logger.warn("sortProductsByNoSales: There are no products yet");
            return null;
        }

    }

    //Private functions

    private List<Product> sortProductsByCost(List<Product> products) {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    private boolean isUserOnQueue (int userId) {
        for(Order o : servedOrders) {
            if(o.getUserId() == userId)
                return true;
        }
        return false;
    }

    private List<Product> sortProductsByNoSales(List<Product> products) {
        int noCoffee = 0;
        int noSandwiches = 0;
        List<Product> temp = new ArrayList<>();
        for (Product p : products) {
            switch(p.getId()) {
                case 1:
                    noCoffee++;
                    break;
                case 2:
                    noSandwiches++;
                    break;
            }
        }
        int result = Integer.compare(noCoffee, noSandwiches);
        if (result == 0) {
            for (Product p : products) {
                if (!(temp.contains(p)))
                    temp.add(p);
            }
        }
        if (result < 0) {
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==2)
                    temp.add(p);
            }
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
        }
        if (result > 0) {
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==2)
                    temp.add(p);
            }
        }
        return temp;
    }

    private List<Product> getAllServedProducts() {
        List<Product> temp = new ArrayList<>();
        if (!servedOrders.isEmpty()) {
            logger.info("getAllProducts: Getting all products from:");
            for(Order o : this.servedOrders) {
                temp.addAll(o.getProducts());
            }
            logger.info("getAllProducts: All products retreived");
            return temp;
        }
        else {
            logger.info("getAllProducts: There are no products that have been ordered yet");
            return temp;
        }

    }
}
