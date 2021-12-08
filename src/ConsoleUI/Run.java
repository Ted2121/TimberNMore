package ConsoleUI;
import Controller.ItemController;
import Controller.OrderController;
import Model.Database;

public class Run {
    public static void main(String[] args) {

        Database database = new Database();
        OrderController orderController = new OrderController();
        ItemController itemController = new ItemController();

    database.populateDatabase();

    new LogInMenu().runMenu();

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
