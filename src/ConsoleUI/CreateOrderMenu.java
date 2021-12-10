package ConsoleUI;

import Controller.OrderController;

public class CreateOrderMenu implements Menu {


    @Override
    public void runMenu() {
        createOrderMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void createOrderMenu(){

            writeCreateOrderMenu();

            while (true) {
                int choice = Menu.getIntegerFromUser();
                switch (choice) {

                    case 1 -> Menu.goToSearchItemsMenu();
                    case 2 -> Menu.goToScanItemsMenu();
                    case 3 -> Menu.goToFinalizeOrderMenu();
                    case 4 -> Menu.goToMainMenu();
                    case 9 -> writeCreateOrderMenu();
                    case 0 -> {
                        System.out.println("Closing Application");

                        Menu.closeApplication();
                    }
                    default -> {
                        System.out.println("Invalid input: " + choice);
                        writeCreateOrderMenu();
                    }
                }
            }
    }

    private void writeCreateOrderMenu(){
        System.out.println("****** Create Order ******");
        System.out.println(" (1) Search for items");
        System.out.println(" (2) Scan items");
        System.out.println(" (3) Finalize order");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}

