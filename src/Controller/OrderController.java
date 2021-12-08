package Controller;

import Model.Item;
import Model.Order;
import Model.OrderContainer;

import java.util.ArrayList;

public class OrderController {
    private final OrderContainer orderContainer;

    private final ItemController itemController;

    public OrderController(){
        orderContainer = OrderContainer.getInstance();
        itemController = new ItemController();

    }

    public void addItemsInOrder(Item item){
        getOrder().addItemsInOrder(item);
    }

    public Order getOrder(){
       return orderContainer.getOrder();
    }

    public void createOrder(){
        orderContainer.createOrder();
    }



    public void addOrderToDatabase(Order order){
        orderContainer.addOrderToDatabase(order);
    }

    // searches the inventory for an item with the same barcode as the parameter
    // if found, adds it to the itemsInOrder ArrayList
    public void addItemToOrder(int barcode){

        for (int i = 0; i < itemController.getInventory().size(); i++) {
            int barcodeOfItem = itemController.getInventory().get(i).getBarcode();
            if (barcode == barcodeOfItem){
                createAndGetItemsInOrder().add(itemController.getInventory().get(i));
            }else {
                System.out.println("Something went wrong here"); //for debugging
            }
        }
    }

    public ArrayList<Item> createAndGetItemsInOrder() {
        return orderContainer.createAndGetItemsInOrder();
    }

    public ArrayList<Item> getItemsInOrder() {
        return orderContainer.getItemsInOrder();
    }
}
