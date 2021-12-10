package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private ArrayList<Item> itemsInOrder;
    private Customer customer;
    private static int orderId = 1;
    private String orderDateAndTime;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private BigDecimal totalPrice;

    public Order() {
        //itemsInOrder = new ArrayList<>();
        // We set the orderDateAndTime to the formatted LocalDateTime.now()
        this.orderDateAndTime = LocalDateTime.now().format(format);
        // We increment orderId every time we create a new order
        orderId++;
    }



    // Adds items to the order
    public void addItemsInOrder(Item item){
        itemsInOrder.add(item);
        System.out.println(itemsInOrder);
        System.out.println(itemsInOrder.size());
    }

    public ArrayList<Item> getItemsInOrder() {
        return itemsInOrder;
    }

    public void setItemsInOrder(ArrayList<Item> itemsInOrder) {
        this.itemsInOrder = itemsInOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getOrderId() {
        return orderId;
    }

    public static void setOrderId(int orderId) {
        Order.orderId = orderId;
    }

    public String getOrderDateAndTime() {
        return orderDateAndTime;
    }

    public void setOrderDateAndTime(String orderDateAndTime) {
        this.orderDateAndTime = orderDateAndTime;
    }

    public DateTimeFormatter getFormat() {
        return format;
    }

    public void setFormat(DateTimeFormatter format) {
        this.format = format;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order: " + "\n-----------------------------------\n" +
                "itemsInOrder: " + itemsInOrder + "\n" +
                "customer: " + customer + "\n" +
                "orderDateAndTime: " + orderDateAndTime + "\n" +
                "totalPrice: " + totalPrice + "\n" +
                "";
    }
}
