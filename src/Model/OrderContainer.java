package Model;

import java.util.ArrayList;

public class OrderContainer {
    private ArrayList<Order> orders;
    private static OrderContainer instance;

    private OrderContainer(){
        orders = new ArrayList<Order>();
    }

    // singleton
    public static OrderContainer getInstance(){
        if(instance ==null)
            instance = new OrderContainer();
        return instance;
    }
}
