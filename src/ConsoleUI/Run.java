package ConsoleUI;
import Model.Database;
import Model.Database.*;
import Model.Employee;

public class Run {
    public static void main(String[] args) {

        Database database = new Database();

        System.out.println();

        System.out.println(database.getItem1().getItemName());
        System.out.println(database.getItem1().toString());
        System.out.println(database.getItem2().toString());
        System.out.println(database.getItem3().toString());
    }
}
