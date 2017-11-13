package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Item;
import edu.upc.dsa.Model.User;
import org.apache.log4j.Logger;
import org.junit.*;

import static edu.upc.dsa.Controller.EetakemonManagerImpl.*;

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

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;


    @Before //Junit4
    public void setUp() throws Exception {

        usr1 = new User(1, "Marc", "1234", 34, 30, 30);
        usr2 = new User(2, "Gerard", "1234", 34, 30, 30);
        usr3 = new User(3, "Ivan", "1234", 34, 30, 30);
        usr4 = new User(4, "Mario", "1234", 34, 30, 30);

        item1 = new Item(1, "potion", 3, "minor heal", 0.2, 20);
        item2 = new Item(2, "paralize", 3, "minor heal", 0.2, 20);
        item3 = new Item(3, "mana", 3, "minor heal", 0.2, 20);
        item4 = new Item(4, "speed", 3, "minor heal", 0.2, 20);

        usr1.setItem(item1);
        usr1.setItem(item2);
        usr1.setItem(item3);
        usr1.setItem(item4);

        usr2.setItem(item1);
        usr2.setItem(item2);
        usr2.setItem(item3);

        usr3.setItem(item1);
        usr3.setItem(item2);

        getInstance().set(usr1);
        getInstance().set(usr2);
        getInstance().set(usr3);
        getInstance().set(usr4);
    }

    @After //Junit4
    public void tearDown(){

        usr1 = null;
        usr2 = null;
        usr3 = null;
        usr4 = null;

        item1 = null;
        item2 = null;
        item3 = null;
        item4 = null;

        getInstance().getMap().clear();
    }

    @Test
    public void setTest(){
        logger.info("Starting setTest...");
        //Creating new user
        User new_user = new User(5, "Oriol", "12345678", 37, 30, 30);
        Assert.assertTrue(getInstance().set(new_user));
        //Creating and existing user
        User new_user_2 = new User(1, "Marc", "1234", 34, 30, 30);
        Assert.assertFalse(getInstance().set(new_user_2));
        logger.info("Ending setTest...");
    }

    @Test
    public void addItemTest() {
        logger.info("Starting addItemTest...");

        //Adding item to user
        Item item_5 = new Item(5, "meat", 3, "minor heal", 0.2, 20);
        getInstance().setItem(2, item_5);
        Assert.assertEquals(4, getInstance().get(2).getItems().size());
        logger.info("Ending addItemTest...");
    }
}
