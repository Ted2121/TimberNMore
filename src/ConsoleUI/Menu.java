package ConsoleUI;

import Controller.EmployeeController;
import Model.Database;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {

    EmployeeController employeeController = new EmployeeController();

    void runMenu();

    static void closeApplication(){
        System.exit(0);
    }

    static void goToMainMenu(){

        // Sleeping the thread for half a second because it was displaying err message "Customer not found!" in the wrong order
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);

                    new MainMenu().runMenu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        runnable.run();
    }

    static void goToCreateOrderMenu(){
        new CreateOrderMenu().runMenu();
    }

    static void goToSearchItemsMenu(){
        new SearchForItemsMenu().runMenu();
    }

    static void goToUpdateOrderMenu(){
        new UpdateOrderMenu().runMenu();
    }

    static  void goToCreateUserMenu() { new CRUD_Employee().runMenu();}

    // I put these printing methods here so that 2 different menus can use them
    static void writeIdentifyCustomer(){
        System.out.println();
        System.out.println("****** Identify Customer ******");
        System.out.println();
        System.out.print("Name: ");
        FinalizeOrderMenu.setName(Menu.getStringFromUser());
        System.out.print("ID: ");
        FinalizeOrderMenu.setId(Menu.getIntegerFromUser());
    }

    static int askCustomerType(){
        System.out.println("****** Customer Type ******");
        System.out.println();
        System.out.println(" (1) Registered Customer");
        System.out.println(" (2) Guest Customer");


        return getIntegerFromUser();
    }

    static int scanQuery() {
        System.out.println();
        System.out.println("Type in the barcode (placeholder for barcode scanner):");
        return Menu.getIntegerFromUser();
    }

    static void scanToAddProcess(){
        System.out.println(Database.getInstance().getItemDetails());
        // we scan a barcode (type it in as a placeholder)
        // we then find the matching item with the barcode
        // and we add that item to the current order
        Database.getInstance().getItemController().scanAndAdd(Menu.scanQuery());
    }

    static void scanToRemoveProcess(){
        System.out.println(Database.getItemDetails());
        Database.getInstance().getItemController().scanAndRemove(Menu.scanQuery());
    }

    static void goToScanItemsMenu(){
        new ScanItemsMenu().runMenu();
    }

    static void goToLogInMenu(){
        new LogInMenu().runMenu();
    }

    static void goToCancelOrderMenu(){new CancelOrderMenu().runMenu();}

    static void goToFinalizeOrderMenu(){
        new FinalizeOrderMenu().runMenu();
    }

    static void goToSearchResultMenu(){ new SearchResultMenu().runMenu();}

    static int getIntegerFromUser(){
        int choice = 9;
        try{
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            //return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }

    static String getStringFromUser(){
        String answer = null;
        try{
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();

        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return answer;
    }

    static boolean matchUsername(String username){

        boolean matched = false;
        //String matchedUsername = null;

        for (int i = 0; i < employeeController.getEmployees().size(); i++) {
            if (employeeController.getEmployees().get(i).getUsername().equalsIgnoreCase(username)) {
                matched = true;
            }
        }
        return matched;
    }

    static boolean matchPassword(String password){

        boolean matched = false;
        //String matchedUsername = null;

        for (int i = 0; i < employeeController.getEmployees().size(); i++) {
            if (employeeController.getEmployees().get(i).getPassword().equalsIgnoreCase(password)) {
                matched = true;
            }
        }
        return matched;
    }

    // used in LogIn menu
    static boolean grantAccess(String username, String password){
        return matchUsername(username) && matchPassword(password);
    }

    // will be used after order is finalized
    static void deleteSearchHistory(){
        Database.getInstance().getItemController().clearSearchHistory();
    }

}


