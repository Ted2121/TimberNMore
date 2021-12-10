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

    private String name;
    private int id;
    private Customer identifiedCustomer;

    @Override
    public void runMenu() {
        finalizeOrderMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void finalizeOrderMenu(){
        writeFinalizeOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
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
                        itemController.clearSearchHistory();
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
        System.out.println();
        System.out.println("****** Identify Customer ******");
        System.out.println();
        System.out.print("Name: ");
        this.name = Menu.getStringFromUser();
      //  customerController.matchName(name);
        System.out.println("ID: ");
        this.id = Menu.getIntegerFromUser();
       // customerController.matchId(Menu.getIntegerFromUser());
        identifiedCustomer = customerController.getCustomerByName(this.name);
    }

    //TODO modify price according to discount
    private void grantDiscount(){

        BigDecimal discount = orderController.totalPrice()
                .multiply(new BigDecimal(String.valueOf(identifiedCustomer.getDiscountMultiplier()))
                        .setScale(2, RoundingMode.CEILING));
        if(customerController.grantDiscount(this.name, this.id)){
            orderController.setTotalPrice(orderController.totalPrice().subtract(discount));
        }

    }

//    private void checkAccountDetails() {
//        if (Menu.grantAccess(username, password)) {
//            Menu.goToMainMenu();
//        } else {
//            System.err.println("Incorrect Username or Password. Please try again!");
//
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(500);
//                        logInMenu();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            runnable.run();
//
//        }
//
//
//    }
}
