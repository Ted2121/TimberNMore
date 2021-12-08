package ConsoleUI;

public class FinalizeOrderMenu implements Menu{

    @Override
    public void runMenu() {

    }

    private void finalizeOrderMenu(){
        writeFinalizeOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> System.out.println();
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
