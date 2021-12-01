package Model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private Item item;
    private Customer customer;
    private static int orderId = 1;
    private String orderDateAndTime;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Order(Item item, Customer customer) {
        this.item = item;
        this.customer = customer;
        // We set the orderDateAndTime to the formatted LocalDateTime.now()
        this.orderDateAndTime = LocalDateTime.now().format(format);
        // We increment orderId every time we create a new order
        orderId++;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    @Override
    public String toString() {
        return "Order{" +
                "item=" + item +
                ", customer=" + customer +
                ", orderDateAndTime='" + orderDateAndTime + '\'' +
                ", format=" + format +
                '}';
    }
}
