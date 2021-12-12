package ConsoleUI;

import Controller.CustomerController;
import Controller.ItemController;
import Controller.OrderController;
import Model.Customer;
import Model.ItemContainer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinalizeOrderMenu implements Menu{

    OrderController orderController = new OrderController();
    ItemController itemController = new ItemController();
    CustomerController customerController = new CustomerController();

    private static String name;
    private static int id;
    //private Customer identifiedCustomer;

    @Override
    public void runMenu() {
        identifyCustomer();
        finalizeOrderMenu();
    }

//TODO add a way for unregistered customers to buy things
    @SuppressWarnings("InfiniteLoopStatement")
    private void finalizeOrderMenu(){
        writeFinalizeOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> {
                    try {
                        System.out.println(orderController.getOrder());
                    } catch (NullPointerException e) {
                        System.err.println("Order not found!");
                    } finally {
                        Runnable runnable =  new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    writeFinalizeOrderMenu();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        runnable.run();
                    }
                }

                case 2 -> {

                    try {
                        System.out.println(orderController.getReceipt());
                        orderController.addOrderToDatabase(orderController.getOrder());
                        Menu.deleteSearchHistory();
                        System.out.println("Order finalized. Going back to Main Menu");
                    } catch (NullPointerException e) {
                        System.err.println("Order not found!");
                    } finally {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    Menu.goToMainMenu();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        runnable.run();

                    }
                }
                case 3 -> Menu.goToCreateOrderMenu();
                case 4 -> Menu.goToMainMenu();
                case 9 -> writeFinalizeOrderMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeFinalizeOrderMenu();
                }
            }
        }
    }


    private void writeFinalizeOrderMenu() {
        System.out.println("****** Finalize Order ******");
        System.out.println(" (1) Show Order");
        System.out.println(" (2) Print Receipt");
        System.out.println(" (3) Back to Create Order menu");
        System.out.println(" (4) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }

    private void identifyCustomer(){
        Menu.writeIdentifyCustomer();
        customerController.setIdentifiedCustomer(customerController.getCustomerByName(getName()));
        customerController.grantDiscount();
        orderController.setCustomer(customerController.getIdentifiedCustomer());
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        FinalizeOrderMenu.name = name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        FinalizeOrderMenu.id = id;
    }

    }
