package edu.upc.dsa.Controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.upc.dsa.Model.Coffee;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.User;
import org.apache.log4j.Logger;

import javax.ws.rs.Produces;
import java.util.*;

public class ProductManagerImpl implements ProductManager {

    //Variable declarations

    private static ProductManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);
    private Map<Integer, User> map; // key=userId

    //Singleton Pattern

    public static ProductManagerImpl getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }

    //Constructors

    public ProductManagerImpl(){
        map = new HashMap<>();
    }

    //Getters and Setters

    public Map<Integer, User> getMap() {
        return map;
    }
    public void setMap(Map<Integer, User> map) {
        this.map = map;
    }
    public String getUsername (int id) {
        return get(id).getUsername();
    }

    public Order makeOrder (int userId, int orderId, List<Product> products) {
        return new Order(userId, orderId, false, products);

    }

    public void setItems(int id, List<Order> list) {
        get(id).setOrders(list);
    }

    //Private functions

    private List<Product> sortProductsByCost(List<Product> products) {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    private List<Product> sortProductsByNoSales(List<Product> products) {
        products.sort(Comparator.comparing(Product::getNoSales));
        return products;
    }

    private Boolean doExist(int id){
        logger.info("doExist: Checking if user id: "+id+" exists...");

        if(map.containsKey(id)) {
            logger.info("doExist: User with id: "+id+" already exists");
            return true;
        }

        else {
            logger.info("doExist: User with id: "+id+" doesn't exist");
            return false;
        }
    }

    //Public functions

    //General functions

    public Boolean initializeUsers() {

        User usr_1 = new User(1, "Marc");
        User usr_2 = new User(2, "Gerard");

        Product item_1 = new Coffee(1,3);
        Product item_2 = new Coffee(2,4);

        List<Product> products = new ArrayList<>();
        products.add(item_1);
        products.add(item_2);

        usr_1.setOrder(new Order(usr_1.getId(), 1, false, products));


        // usr_2 has no items

        return true;
    }

    //User specific functions

    public boolean set(User u) {
        logger.info("set: Creating user: "+u.getUsername()+" ...");

        if(doExist(u.getId())) {
            logger.warn("set: User: "+u.getUsername()+" already exists");
            return false;
        }

        else {
            map.put(u.getId(), u);
            logger.info("set: User: "+u.getUsername()+" have been created!");
            return true;
        }
    }

    public User get(int id) {
        logger.info("get: Querying user id: "+id+" info...");

        if (doExist(id)) {
            logger.info("get: Retreived user id: "+id+" information");
            return map.get(id);
        }
        else {
            logger.fatal("get: Couldn't retreive user id: "+id+" information");
            return null;
        }
    }

    //Order specific functions

    public List<Product> getAllProducts(int userId) {
        logger.info("getAllProducts: Getting all products from: "+userId+" ...");
        User u = get(userId);
        List<Product> temp = new ArrayList<>();
        for (int i=0; i<u.getOrders().size(); i++) {
            temp.add(u.getOrder(i).getProduct(i));
        }
        logger.info("getAllProducts: All products from: "+u.getUsername()+" retreived");

        return temp;
    }

    public List<Product> getAllProductsSortedByCost(int userId) {
        logger.info("getAllProducts: Retreiving All user products ordered by cost...");
        return sortProductsByCost(getAllProducts(userId));
    }

    public Boolean serveOrder(int userId) {
        logger.info("serveOrder: Serving order from user id : "+userId+" ...");
        if(doExist(userId)) {

            int orderId = get(userId).getOrders().get(0).getId();
            get(userId).getOrder(orderId).setDone(true);
            logger.info("serveOrder: order served");
            return true;
        }

        else {
            logger.fatal("serveOrder: Couldn't serveOrder user id: "+userId);
            return false;
        }
    }

    public List<Order> getOrders(int userId) {
        logger.info("getOrders: Getting user item list...");

        User u = get(userId);
        if (u.getOrders().isEmpty())
            logger.info("getOrders: The user: "+u.getUsername()+" has no items");
        else
            logger.info("getOrders: User's items obtained");

        return u.getOrders();
    }

    public boolean setOrder(int userId, Order o) {
        String username = getUsername(userId);
        logger.info("setOrder: Adding order to "+username+" to user: "+username);
        get(userId).setOrder(o);

        logger.info("setItem: Item "+username+" added to user: "+username);
        return true;
    }

    public List<Order> getAllDoneOrders (int userId) {
        List<Order> temp = new ArrayList<>();
        for(Order o : get(userId).getOrders()) {
            if(o.getDone()) temp.add(o);
        }

        return temp;
    }

    public List<Product> getAllProductsOrderesByNoSales(int userId) {
        return sortProductsByNoSales(getAllProducts(userId));
    }




}
