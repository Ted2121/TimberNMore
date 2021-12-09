package ConsoleUI;

import Controller.OrderController;

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
                    new OrderController().createOrder();
                    Menu.goToCreateOrderMenu();
                }
                case 2 ->{
                    new OrderController().getOrder();
                    Menu.goToCreateOrderMenu();
                }
                case 3 -> System.out.println();
                case 4 -> System.out.println();
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
        System.out.println(" (4) Find Order");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
