package ConsoleUI;

import Controller.ItemController;
import Controller.OrderController;
import Model.Database;

public class ScanItemsMenu implements Menu {

    @Override
    public void runMenu() {
        scanItemsMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void scanItemsMenu(){
        writeScanItemsMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> {
                    Menu.scanProcess();
                    // for testing:
                    // System.out.println(new OrderController().getItemsInOrder());
                    writeScanItemsMenu();
                }
                case 2 -> Menu.goToFinalizeOrderMenu();
                case 3 -> Menu.goToCreateOrderMenu();
                case 4 -> Menu.goToMainMenu();
                case 9 -> writeScanItemsMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeScanItemsMenu();
                }
            }
        }
    }



    private void writeScanItemsMenu() {
        System.out.println("****** Scan Items ******");
        System.out.println(" (1) New scan");
        System.out.println(" (2) Finalize order");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
