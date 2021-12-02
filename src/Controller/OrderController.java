package Controller;

import Model.Customer;
import Model.Item;
import Model.Order;
import Model.OrderContainer;

import java.util.ArrayList;

public class OrderController {
    private OrderContainer orderContainer;
    private ArrayList<Item> itemsInOrder;

    public OrderController(){
        orderContainer = OrderContainer.getInstance();
    }

    public void addItemsInOrder(Item item){
        orderContainer.getOrder().addItemsInOrder(item);
    }


}
