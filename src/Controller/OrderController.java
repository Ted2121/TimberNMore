package Controller;

import Model.Customer;
import Model.Item;
import Model.Order;
import Model.OrderContainer;

import java.util.ArrayList;

public class OrderController {
    private OrderContainer orderContainer;
    private ArrayList<Item> itemsInOrder;
    private ItemController itemController;

    public OrderController(){
        orderContainer = OrderContainer.getInstance();
        itemController = new ItemController();

        // TODO this might not be good later
        // singleton for order
        if(itemsInOrder == null){
            itemsInOrder = new ArrayList<Item>();
        }else{itemsInOrder = getItemsInOrder();}
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
                itemsInOrder.add(itemController.getInventory().get(i));
            }else {
                System.out.println("Something went wrong here"); //for debugging
            }
        }
    }

    public ArrayList<Item> getItemsInOrder() {
        return itemsInOrder;
    }
}
