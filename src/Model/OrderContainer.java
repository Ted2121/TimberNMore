package Model;

import java.util.ArrayList;

public class OrderContainer {
    private ArrayList<Order> orders;

    private static OrderContainer instance;
    private Order order;

    private OrderContainer(){
        orders = new ArrayList<Order>();

    }

    // singleton
    public static OrderContainer getInstance(){
        if(instance == null)
            instance = new OrderContainer();
        return instance;
    }

    // If order is null, we create a new order, otherwise we return the existing one
    public Order getOrder(){
        if(order == null)
            order = new Order();
        return order;
    }

    public void createOrder(){
        Order order = new Order();
    }
}
