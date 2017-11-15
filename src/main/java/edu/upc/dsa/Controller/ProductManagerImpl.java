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
        logger.info("getAllProducts: Getting all products from:");
        List<Order> temp = new ArrayList<>();

        for(Order o : this.servedOrders) {
            if (o.getUserId() == userId)
                temp.add(o);
        }
        //logger.info("getAllProducts: All products from: "+u.getUsername()+" retreived");

        return temp;
    }

    public List<Product> getAllProductsSortedByNoSales() {
        return sortProductsByNoSales(getAllServedProducts());
    }

    //Private functions

    private List<Product> sortProductsByCost(List<Product> products) {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
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
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==1)
                    temp.add(p);
            }
        }
        if (result > 0) {
            for (Product p : products) {
                if(!(temp.contains(p)) && p.getId() ==2)
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
        logger.info("getAllProducts: Getting all products from:");
        List<Product> temp = new ArrayList<>();

        for(Order o : this.servedOrders) {
            temp.addAll(o.getProducts());
        }
        //logger.info("getAllProducts: All products from: "+u.getUsername()+" retreived");

        return temp;
    }

    /*public Boolean initializeUsers() {

        User usr1 = new User(1, "Marc");

        Product item1 = new Coffee();
        Product item2 = new Coffee();
        Product item3 = new Sandwich();
        Product item4 = new Sandwich();
        Product item5 = new Coffee();

        List<Product> products = new ArrayList<>();

        products.add(item1);
        products.add(item2);
        products.add(item3);
        products.add(item4);
        products.add(item5);

        usr1.setOrder(new Order(usr1.getId(),false, products));

        User usr2 = new User(2, "Gerard");

        Product item6 = new Coffee();
        Product item7 = new Coffee();
        Product item8 = new Sandwich();
        Product item9 = new Sandwich();
        Product item10 = new Coffee();

        List<Product> products2 = new ArrayList<>();

        products2.add(item1);
        products2.add(item4);
        products2.add(item7);
        products2.add(item8);
        products2.add(item9);

        usr2.setOrder(new Order(usr2.getId(),false, products2));

        return true;
    }*/
}
