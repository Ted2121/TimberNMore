package ConsoleUI;
import Model.Database;

public class Run {


    public static void main(String[] args) {

        Database.getInstance().populateDatabase();

        // Menu.goToLogInMenu(); // comment this line to bypass login screen
        Menu.goToMainMenu();

    }


}
