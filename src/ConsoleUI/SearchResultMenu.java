package ConsoleUI;

import Controller.ItemController;

public class SearchResultMenu implements Menu{

    @Override
    public void runMenu() {
        searchResultMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void searchResultMenu(){
        System.out.println("****** Search Results ******");
        // TODO this ArrayList is not yet populated
        System.out.println(new ItemController().getSearchedItems());

        writeSearchResultsMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> System.out.println(new ItemController().getLocationCodesFromSearched());
                case 2 -> Menu.goToSearchItemsMenu();
                case 3 -> Menu.goToCreateOrderMenu();
                case 4 -> Menu.goToMainMenu();
                case 0 -> {
                    System.out.println("Closing Application");

                    Menu.closeApplication();
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }


    }

    private void writeSearchResultsMenu() {
        System.out.println();
        System.out.println(" (1) Print location codes");
        System.out.println(" (2) Search for another item");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");

    }
}
