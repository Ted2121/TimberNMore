package ConsoleUI;

public class ScanItemsMenu implements Menu {

    @Override
    public void runMenu() {
        scanItemsMenu();
    }

    private void scanItemsMenu(){
        writeScanItemsMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> Menu.returnToMainMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    System.exit(0);
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }
    }

    private void writeScanItemsMenu() {
        System.out.println("****** Scan Items ******");
        System.out.println(" (1) New scan");
        System.out.println(" (2) Back to Create Order menu");
        System.out.println(" (3) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
