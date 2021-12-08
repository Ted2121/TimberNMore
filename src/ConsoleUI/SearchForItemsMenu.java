package ConsoleUI;

public class SearchForItemsMenu implements Menu{

    @Override
    public void runMenu() {
        searchForItemsMenu();
    }

    private void searchForItemsMenu(){

        writeSearchForItemsMenu();

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

    private void writeSearchForItemsMenu() {
        System.out.println("****** Search for Items ******");
        System.out.println(" (1) New search");
        System.out.println(" (2) Back to Create Order menu");
        System.out.println(" (3) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }


}
