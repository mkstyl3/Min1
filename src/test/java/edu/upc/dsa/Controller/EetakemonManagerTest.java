package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Coffee;
import edu.upc.dsa.Model.Product;
import edu.upc.dsa.Model.Order;
import edu.upc.dsa.Model.User;
import org.apache.log4j.Logger;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static edu.upc.dsa.Controller.ProductManagerImpl.*;

/**
 * Unit test for simple App.
 */
public class EetakemonManagerTest
{
    // Variable initialization

    private final static Logger logger = Logger.getLogger(EetakemonManagerTest.class);

    private User usr1;
    private User usr2;
    private User usr3;
    private User usr4;

    private Product item1;
    private Product item2;

    Order order;

    private ArrayList<Product> products;


    @Before //Junit4
    public void setUp() throws Exception {

        usr1 = new User(1, "Marc");
        usr2 = new User(2, "Gerard");

        item1 = new Coffee(1,3);
        item2 = new Coffee(2,4);

        products = new ArrayList<>();

        products.add(item1);
        products.add(item2);

        usr1.setOrder(new Order(usr1.getId(), 1, false, products));

        order = new Order(usr1.getId(), 2, false, products);
        // usr_2 has no items
    }

    @After //Junit4
    public void tearDown(){

        usr1 = null;
        usr2 = null;

        item1 = null;
        item2 = null;

        products = null;

        getInstance().getMap().clear();
    }

    @Test
    public void setOrderTest(){
        logger.info("Starting setOrderTest...");
        Order newOrder = new Order(usr1.getId(), 1, false, products);
        Assert.assertTrue(getInstance().setOrder(usr1.getId(),newOrder));
    }

    @Test
    public void serveOrderTest() {
        logger.info("Starting serveOrderTest()...");

        getInstance().serveOrder(1);
        Assert.assertEquals(1, getInstance().getAllDoneOrders(1));
        logger.info("Ending serveOrderTest()...");
    }
}
