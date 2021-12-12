package ConsoleUI;

import Controller.CustomerController;
import Controller.ItemController;
import Controller.OrderController;
import Model.Order;

public class UpdateOrderMenu implements Menu{

    CustomerController customerController = new CustomerController();
    OrderController orderController = new OrderController();

    @Override
    public void runMenu() {

    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void updateOrderMenu(){

// TODO

        writeUpdateOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> Menu.goToCreateOrderMenu();
                case 4 -> Menu.goToMainMenu();
                case 9 -> writeUpdateOrderMenu();
                case 0 -> {
                    System.out.println("Closing Application");

                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeUpdateOrderMenu();
                }
            }
        }
    }

    private void writeUpdateOrderMenu() {
        Menu.writeIdentifyCustomer();
        orderController.matchOrder();

        System.out.println();
        System.out.println("****** Update Order ******");
        System.out.println();
        System.out.println(" (1) Add an item to the order");
        System.out.println(" (2) Remove an item from the order");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");

    }





}
