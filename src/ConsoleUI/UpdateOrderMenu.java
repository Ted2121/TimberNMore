package ConsoleUI;

import Controller.CustomerController;
import Controller.OrderController;

public class UpdateOrderMenu implements Menu{

    CustomerController customerController = new CustomerController();
    OrderController orderController = new OrderController();

    @Override
    public void runMenu() {
        updateOrderMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void updateOrderMenu(){


        Menu.writeIdentifyCustomer();
        orderController.matchOrder();

        writeUpdateOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> {
                    Menu.scanToAddProcess();
                    writeUpdateOrderMenu();
                }
                case 2 -> {
                    Menu.scanToRemoveProcess();
                    writeUpdateOrderMenu();
                }
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
