package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.upc.dsa.Controller.ProductManagerImpl.getInstance;

/**
 * Unit test for simple App.
 */
public class ProductManagerTest
{
    // Variable initialization

    private final static Logger logger = Logger.getLogger(ProductManagerTest.class);

    private User usr1;
    private User usr2;

    private Product item1;
    private Product item2;

    Order userOrder1;
    Order userOrder2;

    private List<Product> products;
    private List<Product> products2;

    @Before //Junit4
    public void setUp() throws Exception {

        usr1 = new User(1, "Marc");
        usr2 = new User(2, "Gerard");

        item1 = new Product(1,"Sandwich",3);
        item2 = new Product(2,"Coffee", 1);

        products = new ArrayList<>();
        products2 = new ArrayList<>();

        products.add(item1);
        products.add(item2);

        products2.add(item1);
        products2.add(item1);
        products2.add(item1);

        userOrder1 = new Order(usr1.getId(),false, products);
        userOrder2 = new Order(usr2.getId(),false, products2);

        // usr_2 has no items
    }

    @After //Junit4
    public void tearDown(){

        usr1 = null;
        usr2 = null;
        item1 = null;
        item2 = null;
        products = null;
        products2 = null;
        getInstance().getOrders().clear();
        getInstance().getServedOrders().clear();
    }

    @Test
    public void makeOrderTest(){
        logger.info("Starting makeOrderTest...");
        Assert.assertTrue(getInstance().makeOrder(usr1.getId(),products));
        logger.info("Finishing setOrderTest...");
    }

    @Test
    public void serveOrderTest() {
        logger.info("Starting serveOrderTest()...");
        getInstance().makeOrder(usr2.getId(), products2);
        getInstance().serveOrder();
        Assert.assertEquals(0, getInstance().getOrders().size());
        logger.info("Ending serveOrderTest()...");
    }
}
