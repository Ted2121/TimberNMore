package ConsoleUI;

import Model.Database;

public class CancelOrderMenu implements Menu{



    @Override
    public void runMenu() {
        cancelOrderMenu();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void cancelOrderMenu(){
       // writeCancelOrderMenu();
            int customerTypeChoice = Menu.askCustomerType();
            if(customerTypeChoice == 1){
                Menu.writeIdentifyCustomer();
                Database.getInstance().getOrderController().matchOrderByName();
            }else{
                System.out.println("***** Guest History *****");
                System.out.println(Database.getInstance().getCustomerController().getGuestDetails());

                Menu.writeIdentifyCustomer();
                Database.getInstance().getOrderController().matchOrderById();
            }

            writeCancelOrderMenu();

        while (true) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {

                case 1 -> {
                    Database.getInstance().getCustomerController().grantDiscount();
                    System.out.println(Database.getInstance().getOrderController().getIdentifiedOrder());
                    writeCancelOrderMenu();
                }
                case 2 -> {
                    Database.getInstance().getOrderController()
                            .cancelOrder(Database.getInstance().getOrderController().getIdentifiedOrder());
                    System.out.println("Order cancelled successfully");
                    System.out.println("Returning to Main Menu");
                    Menu.goToMainMenu();
                }

                case 3 -> Menu.goToMainMenu();
                case 9 -> writeCancelOrderMenu();
                case 0 -> {
                    System.out.println("Closing Application");
                    Menu.closeApplication();
                }
                default -> {
                    System.out.println("Invalid input: " + choice);
                    writeCancelOrderMenu();
                }
            }
        }
    }

    private void writeCancelOrderMenu() {
        System.out.println("****** Cancel Order Menu ******");
        System.out.println(" (1) Find order");
        System.out.println(" (2) Cancel order");
        System.out.println(" (3) Back to Main Menu");
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }

}
