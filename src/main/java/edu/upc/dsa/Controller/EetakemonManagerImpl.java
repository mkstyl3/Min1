package edu.upc.dsa.Controller;

import edu.upc.dsa.Model.Item;
import edu.upc.dsa.Model.User;
import org.apache.log4j.Logger;

import java.util.*;

public class EetakemonManagerImpl implements EetakemonManager {

    //Variable declarations

    private static EetakemonManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(EetakemonManagerImpl.class);
    private Map<Integer, User> map; // key=userId

    //Singleton Pattern

    public static EetakemonManagerImpl getInstance() {
        if (instance == null) instance = new EetakemonManagerImpl();
        return instance;
    }

    //Constructors

    public EetakemonManagerImpl(){
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


    public void setUsername(int id, String username) {
        get(id).setUsername(username);
    }
    public void setPassword(int id, String password) {
        get(id).setPassword(password);
    }
    public void setAtk(int id, int atk) {
        get(id).setAtk(atk);
    }
    public void setDef(int id, int def) {
        get(id).setDef(def);
    }
    public void setVit(int id, int vit) {
        get(id).setVit(vit);
    }
    public void setItems(int id, List<Item> list) {
        get(id).setItems(list);
    }

    //Private functions

    private List<User> sortUsersByUsername(List<User> users) {
        users.sort(Comparator.comparing(User::getUsername));
        return users;
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

    public List<User> getAll() {
        return new ArrayList<>(map.values());
    }

    public List<User> getAllSortedByUsername() {
        logger.info("getAll: Retreiving All Users ordered alphabetically...");
        return sortUsersByUsername(getAll());
    }

    public Boolean initializeUsers() {

        User usr_1 = new User(1, "Marc", "1234", 34, 30, 30);
        User usr_2 = new User(2, "Gerard", "1234", 34, 30, 30);
        User usr_3 = new User(3, "Ivan", "1234", 34, 30, 30);
        User usr_4 = new User(4, "Mario", "1234", 34, 30, 30);

        Item item_1 = new Item(1,"potion", 3, "minor heal", 0.2, 20);
        Item item_2 = new Item(2,"paralize", 3, "minor heal", 0.2, 20);
        Item item_3 = new Item(3,"mana", 3, "minor heal", 0.2, 20);
        Item item_4 = new Item(4,"speed", 3, "minor heal", 0.2, 20);

        usr_1.setItem(item_1);
        usr_1.setItem(item_2);
        usr_1.setItem(item_3);
        usr_1.setItem(item_4);

        usr_2.setItem(item_1);
        usr_2.setItem(item_2);
        usr_2.setItem(item_3);

        usr_3.setItem(item_1);
        usr_3.setItem(item_2);

        set(usr_1);
        set(usr_2);
        set(usr_3);
        set(usr_4);

        // usr_4 has no items

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

    public boolean edit(User u) { //Id can't be changed, only deleted by own criteria
        logger.info("edit: Editing user: "+u.getUsername()+" ...");

        if (u.getUsername() != null)
            setUsername(u.getId(), u.getUsername());
        if(u.getPassword() != null)
            setPassword(u.getId(), u.getPassword());
        if(u.getAtk() != 0)
            setAtk(u.getId(), u.getAtk());
        if(u.getDef() != 0)
            setDef(u.getId(), u.getDef());
        if(u.getVit() != 0)
            setVit(u.getId(), u.getVit());
        if(u.getItems() != null)
            setItems(u.getId(), u.getItems());
        logger.info("edit: User: "+u.getUsername()+" edited.");

        return true;
    }

    public Boolean del(int id) {
        logger.info("del: Removing user id "+id+" ...");

        if(doExist(id)) {
            map.remove(id);
            logger.info("del: User id: "+id+" already removed");
            return true;
        }

        else {
            logger.fatal("del: Couldn't del user id: "+id);
            return false;
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

    public List<Item> getItems(int userId) {
        logger.info("getItems: Getting user item list...");

        User u = get(userId);
        if (u.getItems().isEmpty())
            logger.info("getItems: The user: "+u.getUsername()+" has no items");
        else
            logger.info("getItems: User's items obtained");

        return u.getItems();
    }

    public boolean setItem(int userId, Item i) {
        String username = getUsername(userId);
        logger.info("addItemUs/er: Adding item "+i.getName()+" to user: "+username);
        get(userId).setItem(i);

        logger.info("setItem: Item "+i.getName()+" added to user: "+username);
        return true;
    }
}
