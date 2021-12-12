package Model;

import Controller.CustomerController;
import Controller.EmployeeController;
import Controller.ItemController;
import Controller.OrderController;

import java.math.BigDecimal;

public class Database {
    private ItemController itemController = new ItemController();
    private EmployeeController employeeController = new EmployeeController();
    private OrderController orderController = new OrderController();
    private CustomerController customerController = new CustomerController();
    private static Database instance = new Database();
    // created this static string to be able to call its getter in void main
    private static String itemDetails;

    public Database(){
        setItemDetails();
    }

    public static Database getInstance(){

        return instance;
    }

    Item item1 = new Item('T', 11, "Hammer", true, new BigDecimal("50.00"));
    Item item2 = new Item('D', 12, "Nails", false, new BigDecimal("20.0"));
    Item item3 = new Item('T', 13, "Bolts", false, new BigDecimal("15.0"));
    Item item4 = new Item('D', 14, "Chair", true, new BigDecimal("10.0"));
    Item item5 = new Item('T', 15, "Table", true, new BigDecimal("200.0"));


    public void addItemsToInContainer(){
        itemController.addItemToInventory(item1);
        itemController.addItemToInventory(item2);
        itemController.addItemToInventory(item3);
        itemController.addItemToInventory(item4);
        itemController.addItemToInventory(item5);
    }

    Employee employee1 = new Employee("Bob", "Dylan", "sales assistant");
    Employee employee2 = new Employee("Anders", "Olesen", "manager");
    Employee employee3 = new Employee("Casper", "Olesen", "manager");
    Employee employee4 = new Employee("Joey", "Joes", "accountant");
    Employee employee5 = new Employee("Secondbob", "Notdylan", "sales assistant");

    public void addEmployeesToContainer(){
        employeeController.addEmployee(employee1);
        employeeController.addEmployee(employee2);
        employeeController.addEmployee(employee3);
        employeeController.addEmployee(employee4);
        employeeController.addEmployee(employee5);
    }

    Customer customer1 = new Customer("Ted", "regular");
    Customer customer2 = new Customer("Bozhidar", "standard");
    Customer customer3 = new Customer("Luka", "premium");
    Customer customer4 = new Customer("Andreea", "standard");
    Customer customer5 = new Customer("Vladdy", "regular");

    public void addCustomersToContainer(){
        customerController.addCustomer(customer1);
        customerController.addCustomer(customer2);
        customerController.addCustomer(customer3);
        customerController.addCustomer(customer4);
        customerController.addCustomer(customer5);
    }


    // Will get called at the start of the application
    public void populateDatabase(){

        addItemsToInContainer();
        // item1.setQuantity(2);
        // item3.setQuantity(3);
//        System.out.println(item1);
//        System.out.println(item3);
//        System.out.println(item2);
        addEmployeesToContainer();
        addCustomersToContainer();

//        System.out.println(employee1);
//        System.out.println(employee2);
    }

    // these methods are used to cheat the barcode part because we don't have a real barcode scanner
    public int getItem1Barcode(){
        return item1.getBarcode();
    }

    public int getItem2Barcode(){
        return item2.getBarcode();
    }

    public int getItem3Barcode(){
        return item3.getBarcode();
    }

    public int getItem4Barcode(){
        return item4.getBarcode();
    }

    public int getItem5Barcode(){
        return item5.getBarcode();
    }

    // this is used to initialize a static string to non-static items data
    public void setItemDetails(){
        itemDetails = item1.getItemName() + ": " + getItem1Barcode() + "\n" +
                item2.getItemName() + ": " + getItem2Barcode() + "\n" +
                item3.getItemName() + ": " + getItem3Barcode() + "\n" +
                item4.getItemName() + ": " + getItem4Barcode() + "\n" +
                item5.getItemName() + ": " + getItem5Barcode() + "\n";
    }

    public static String getItemDetails() {
        return itemDetails;
    }

    public ItemController getItemController() {
        return itemController;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }
}
