package Model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private Item item;
    private Customer customer;
    private static int orderId = 0;
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
}
