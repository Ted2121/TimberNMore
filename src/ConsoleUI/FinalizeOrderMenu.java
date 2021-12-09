package ConsoleUI;

import Controller.ItemController;
import Controller.OrderController;
import Model.ItemContainer;

public class FinalizeOrderMenu implements Menu{

    OrderController orderController = new OrderController();
    ItemController itemController = new ItemController();

    @Override
    public void runMenu() {
        finalizeOrderMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void finalizeOrderMenu(){
        writeFinalizeOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> {
                    System.out.println(orderController.getOrder());
                    writeFinalizeOrderMenu();
                }

                case 2 -> {

                    System.out.println(orderController.getReceipt());
                    orderController.addOrderToDatabase(orderController.getOrder());
                    itemController.clearSearchHistory();
                    System.out.println("Order finalized. Going back to Main Menu");
                    Menu.goToMainMenu();
                }
                case 3 -> Menu.goToCreateOrderMenu();
                case 4 -> Menu.goToMainMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    Menu.closeApplication();
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }
    }

    private void writeFinalizeOrderMenu() {
        System.out.println("****** Finalize Order ******");
        System.out.println(" (1) Show Order");
        System.out.println(" (2) Print Receipt");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
