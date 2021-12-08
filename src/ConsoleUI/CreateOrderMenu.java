package ConsoleUI;

public class CreateOrderMenu implements Menu {
    @Override
    public void runMenu() {
        createOrderMenu();
    }

    private void createOrderMenu(){

            writeCreateOrderMenu();

            while (true) {
                int choice = Menu.getIntegerFromUser();
                switch (choice) {
                    // TODO
                    case 1 -> new SearchForItemsMenu().runMenu();
                    case 2 -> System.out.println();
                    case 3 -> System.out.println();
                    case 4 -> Menu.returnToMainMenu();
                    case 0 -> {
                        System.out.println("Closing Application");

                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input: " + choice);
                }
            }
    }

    private void writeCreateOrderMenu(){
        System.out.println("****** Create Order ******");
        System.out.println(" (1) Search for items");
        System.out.println(" (2) Scan items"); // TODO
        System.out.println(" (3) Finalize order"); // TODO
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}

