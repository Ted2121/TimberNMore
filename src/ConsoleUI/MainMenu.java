package ConsoleUI;

import Controller.OrderController;

public class MainMenu implements Menu {

    @Override
    public void runMenu() {
        mainMenu();
    }

    private void mainMenu(){
        writeMainMenu();
        boolean running = true;
        while (running) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> {
                    new OrderController().createOrder();
                    new CreateOrderMenu().runMenu();
                }
                case 2 ->{
                    new OrderController().getOrder();
                    new CreateOrderMenu().runMenu();
                }
                case 3 -> System.out.println();
                case 0 -> {
                    System.out.println("Closing Application");
                    running = false;
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }
    }

    private void writeMainMenu(){
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Create new order");
        System.out.println(" (2) Return to existing order");
        System.out.println(" (2) Update Order"); // TODO
        System.out.println(" (3) Find Order"); // TODO
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
