package ConsoleUI;

import Controller.ItemController;

public class SearchResultMenu implements Menu{

    @Override
    public void runMenu() {
        searchResultMenu();
    }

    private void searchResultMenu(){
        System.out.println("****** Search Results ******");
        // TODO this ArrayList is not yet populated
        System.out.println(new ItemController().getSearchedItems());

        writeSearchResultsMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> Menu.goToMainMenu();
                case 0 -> {
                    System.out.println("Closing Application");

                    System.exit(0);
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }


    }

    private void writeSearchResultsMenu() {
        System.out.println();
        System.out.println(" (1) Add items to list");
        System.out.println(" (2) Search for another item");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");

    }
}
