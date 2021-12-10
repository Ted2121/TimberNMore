package Model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderContainer {
    private final ArrayList<Order> orders;

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

    // if the ArrayList itemInOrder is null, we create a new one
    // else, we return the existing one
    public ArrayList<Item> createAndGetItemsInOrder() {
        // singleton for items in order
        if(order.getItemsInOrder() == null){
            order.setItemsInOrder(new ArrayList<Item>()) ;
        }else{order.setItemsInOrder(order.getItemsInOrder());}
        return order.getItemsInOrder();
    }

    public ArrayList<Item> getItemsInOrder(){
       return order.getItemsInOrder();
    }

    // If order is null, we create a new order, otherwise we return the existing one
    // we use this method to get the current order while making sure we don't get a null object

    public Order getOrder(){
        if(this.order == null)
            this.order = new Order();
        return this.order;
    }

    public BigDecimal getTotalPrice(){
       return order.getTotalPrice();
    }

    public void setTotalPrice(BigDecimal totalPrice){
        order.setTotalPrice(totalPrice);
    }


    // This method is used when we start a new order,
    // and we want to override the reference to the last order
    // Make sure you store the last order in the orders ArrayList first
    public void createOrder(){
        this.order = new Order();
    }

    public void addOrderToDatabase(Order order){
        orders.add(order);
    }

    public Customer getCustomer() {
        return order.getCustomer();
    }

    public void setCustomer(Customer customer) {
        order.setCustomer(customer);
    }


}
