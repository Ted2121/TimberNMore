package ConsoleUI;
import Controller.ItemController;
import Controller.OrderController;
import Model.Database;
import Model.Database.*;
import Model.Employee;

public class Run {
    public static void main(String[] args) {

        Database database = new Database();
        OrderController orderController = new OrderController();
        ItemController itemController = new ItemController();

    database.populateDatabase();

        System.out.println(itemController.searchForItem("hammer"));

//        System.out.println();
//
//        System.out.println(database.getItem1().getItemName());
//        System.out.println(database.getItem1().toString());
//        System.out.println(database.getItem2().toString());
//        System.out.println(database.getItem3().toString());
    }
}
