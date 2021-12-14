package ConsoleUI;

import Model.Database;

public class MainMenu implements Menu {


    @Override
    public void runMenu() {

        mainMenu();

    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void mainMenu(){
        writeMainMenu();
        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> {
                    Database.getInstance().getOrderController().createOrder();
                    Menu.goToCreateOrderMenu();
                }
                case 2 ->{
                    Database.getInstance().getOrderController().getOrder();
                    Menu.goToCreateOrderMenu();
                }
                case 3 -> Menu.goToUpdateOrderMenu();
                case 4 -> Menu.goToCancelOrderMenu();
                case 5 -> Menu.goToCreateUserMenu();
                case 9 -> writeMainMenu();
                case 0 -> {
                    System.out.println("Closing Application");

                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeMainMenu();
                }
            }
        }
    }

    private void writeMainMenu(){
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Create new order");
        System.out.println(" (2) Return to existing order");
        System.out.println(" (3) Update Order");
        System.out.println(" (4) Cancel Order");
        System.out.println(" (5) Create new User");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }

}
