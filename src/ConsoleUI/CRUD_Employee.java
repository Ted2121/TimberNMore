package ConsoleUI;

import Model.Database;
import Model.EmployeeContainer;

public class CRUD_Employee implements Menu{


    public void runMenu(){ createUserMenu(); }

    private void createUserMenu(){
        writeCRUDEmployeeMenu();

        while (true){
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // case 1 -> EmployeeContainer.addEmployee();
                case 4 -> Menu.goToMainMenu();
                case 9 -> writeCRUDEmployeeMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeCRUDEmployeeMenu();
                }
            }
        }
    }

    private void writeCRUDEmployeeMenu(){
        System.out.println("****** Create User ******");
        System.out.println(" (1) Add Employee");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
