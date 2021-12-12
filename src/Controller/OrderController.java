package Controller;

import ConsoleUI.FinalizeOrderMenu;
import ConsoleUI.Menu;
import Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OrderController {
    private final OrderContainer orderContainer;



    public OrderController(){
        orderContainer = OrderContainer.getInstance();
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

        for (int i = 0; i < Database.getInstance().getItemController().getInventory().size(); i++) {
            int barcodeOfItem = Database.getInstance().getItemController().getInventory().get(i).getBarcode();
            if (barcode == barcodeOfItem){
                createAndGetItemsInOrder().add(Database.getInstance().getItemController().getInventory().get(i));
            }else {
                System.out.println("Something went wrong here"); //for debugging
            }
        }
    }

    public ArrayList<Item> createAndGetItemsInOrder() {
        return orderContainer.createAndGetItemsInOrder();
    }

    public ArrayList<Item> getItemsInOrder(){
        return orderContainer.getItemsInOrder();
    }

    public BigDecimal totalPrice() throws NullPointerException{
        BigDecimal total = new BigDecimal(0);
        for (Item item:
             getItemsInOrder()) {
            total = total.add(item.getPrice());
            setTotalPrice(total);
        }
        return orderContainer.getTotalPrice().setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getTotalPrice(){
        return orderContainer.getTotalPrice().setScale(2, RoundingMode.CEILING);
    }

    public void setTotalPrice(BigDecimal totalPrice){
        orderContainer.setTotalPrice(totalPrice);
    }

    public Customer getCustomer() {
        return orderContainer.getCustomer();
    }

    public void setCustomer(Customer customer) {
        orderContainer.setCustomer(customer);
    }

    public Order getIdentifiedOrder() {
        return orderContainer.getIdentifiedOrder();
    }

    public void setIdentifiedOrder(Order identifiedOrder) {
        orderContainer.setIdentifiedOrder(identifiedOrder);
    }

    public Order findOrderByCustomer(Customer customer){
        Order identifiedOrder = null;

        for (int i = 0; i < orderContainer.getOrders().size(); i++){
            if(orderContainer.getOrders().get(i).getCustomer().getName().equalsIgnoreCase(customer.getName())){
                identifiedOrder = orderContainer.getOrders().get(i);
            }
        }
        if (identifiedOrder == null){
            System.err.println("Order could not be found!");
            Menu.goToMainMenu();
        }
        return identifiedOrder;
    }

    public void matchOrder(){

        try {
            Database.getInstance().getCustomerController().setIdentifiedCustomer(Database.getInstance().getCustomerController().getCustomerByName(FinalizeOrderMenu.getName()));
            setIdentifiedOrder(findOrderByCustomer(Database.getInstance().getCustomerController().getIdentifiedCustomer()));
        } catch (NullPointerException e) {
            System.err.println("Customer or order could not be found!");
            Menu.goToMainMenu();
        }

    }



    public String getReceipt(){
        return "Order\n-----------------------------------\n" +
                getItemsInOrder() +
                "\n-----------------------------------\n" +
                "Total: " + getTotalPrice().setScale(2, RoundingMode.CEILING);
    }
}
