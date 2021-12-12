package ConsoleUI;
import Controller.ItemController;
import Controller.OrderController;
import Model.Database;

public class Run {


    public static void main(String[] args) {

        OrderController orderController = new OrderController();
        ItemController itemController = new ItemController();

    Database.getInstance().populateDatabase();
      //  System.out.println(Database.getItemDetails());


    // bypassing LogInMenu for testing purposes

  // Menu.goToLogInMenu(); //TODO don't forget to uncomment this
        Menu.goToMainMenu();
        
    }


}
