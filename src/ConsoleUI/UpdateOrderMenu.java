package ConsoleUI;

import Controller.CustomerController;
import Controller.OrderController;
import Model.Database;

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
        orderController.matchOrderByName();

        writeUpdateOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                case 1 -> {
                    // grantDiscount() is a necessary call to update the price by calling the method setTotalPrice() internally
                    customerController.grantDiscount();
                    System.out.println(Database.getInstance().getOrderController().getIdentifiedOrder());
                    writeUpdateOrderMenu();
                }
                case 2 -> {
                    Menu.scanToAddProcess();
                    writeUpdateOrderMenu();
                }
                case 3 -> {
                    Menu.scanToRemoveProcess();
                    writeUpdateOrderMenu();
                }
                case 4 -> Menu.goToCreateOrderMenu();
                case 5 -> Menu.goToMainMenu();
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
        System.out.println(" (1) Show order");
        System.out.println(" (2) Add an item to the order");
        System.out.println(" (3) Remove an item from the order");
        System.out.println(" (4) Back to Create Order menu");
        System.out.println(" (5) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");

    }

}
