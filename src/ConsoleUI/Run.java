package ConsoleUI;
import Controller.ItemController;
import Controller.OrderController;
import Model.Database;

public class Run {


    public static void main(String[] args) {

        OrderController orderController = new OrderController();
        ItemController itemController = new ItemController();

    Database.getDatabase().populateDatabase();
        System.out.println(Database.getItemDetails());


    // bypassing LogInMenu for testing purposes
    // new LogInMenu().runMenu(); //TODO don't forget to uncomment this
        new MainMenu().runMenu();

//        System.out.println(itemController.searchForItem("table"));
//        System.out.println(itemController.searchForItem("hammer"));
//        System.out.println(itemController.searchForItem("nails"));
//
//        System.out.println(itemController.getLocationCodesToFindItems());

//        System.out.println();
//
//        System.out.println(database.getItem1().getItemName());
//        System.out.println(database.getItem1().toString());
//        System.out.println(database.getItem2().toString());
//        System.out.println(database.getItem3().toString());
    }


}
