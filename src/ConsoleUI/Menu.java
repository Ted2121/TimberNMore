package ConsoleUI;

import Controller.EmployeeController;
import Controller.ItemController;
import Model.Database;
import Model.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {

    EmployeeController employeeController = new EmployeeController();

    void runMenu();

    static void closeApplication(){
        System.exit(0);
    }

    static void goToMainMenu(){
        new MainMenu().runMenu();
    }

    static void goToCreateOrderMenu(){
        new CreateOrderMenu().runMenu();
    }

    static void goToSearchItemsMenu(){
        new SearchForItemsMenu().runMenu();
    }

    static void goToScanItemsMenu(){
        new ScanItemsMenu().runMenu();
    }

    static void goToLogInMenu(){
        new LogInMenu().runMenu();
    }

    static void goToFinalizeOrderMenu(){
        new FinalizeOrderMenu().runMenu();
    }

    static void goToSearchResultMenu(){ new SearchResultMenu().runMenu();}

    static int getIntegerFromUser(){
        int choice = 0;
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
        new ItemController().getSearchedItems().clear();
    }

    }


