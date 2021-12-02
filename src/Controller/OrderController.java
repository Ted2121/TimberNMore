package Controller;

import Model.OrderContainer;

public class OrderController {
    private OrderContainer orderContainer;

    public OrderController(){
        orderContainer = OrderContainer.getInstance();
    }
}
