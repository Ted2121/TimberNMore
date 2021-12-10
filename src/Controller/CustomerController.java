package Controller;

import ConsoleUI.FinalizeOrderMenu;
import ConsoleUI.Menu;
import Model.Customer;
import Model.CustomerContainer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomerController {
    CustomerContainer customerContainer;

    OrderController orderController = new OrderController();
//    CustomerController customerController = new CustomerController();


    public CustomerController(){customerContainer = CustomerContainer.getInstance();}

    public void addCustomer(Customer customer){
        customerContainer.addCustomer(customer);
    }

    public boolean matchName(String name){
        boolean matched = false;

        try {
            for (int i = 0; i < customerContainer.getCustomers().size(); i++){
                if (customerContainer.getCustomers().get(i).getName().equalsIgnoreCase(name)) {
                    matched = true;
                    break;
                }
            }
        } catch (NullPointerException e) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Returning to main menu");
                    Menu.goToMainMenu();
                }
            };
            System.err.println("Customer not found!");
            runnable.run();
        }

        return matched;
    }

    public boolean matchId(int id){
        boolean matched = false;

        try {
            for(int i = 0; i < customerContainer.getCustomers().size(); i++){
                if(customerContainer.getCustomers().get(i).getCustomerId() == id){
                    matched = true;
                    break;
                }
            }
        } catch (NullPointerException e) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        System.out.println("Returning to main menu");
                        Menu.goToMainMenu();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            System.err.println("Customer not found!");
            runnable.run();
        }
        return matched;
    }

    public boolean grantDiscountCheck(String name, int id){
        return matchName(name) && matchId(id);
    }

    public Customer getCustomerByName(String name){
        Customer customer = null;

        try {
            for(int i = 0; i < customerContainer.getCustomers().size(); i++){
                if(customerContainer.getCustomers().get(i).getName().equalsIgnoreCase(name)){
                    customer = customerContainer.getCustomers().get(i);
                    break;
                }
            }
        } catch (NullPointerException e) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        System.out.println("Returning to main menu");
                        Menu.goToMainMenu();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            System.err.println("Customer not found!");
            runnable.run();
        }
        return customer;
    }

    public void grantDiscount(){

        try {
            BigDecimal discount = orderController.totalPrice()
                    .multiply(new BigDecimal(String.valueOf(customerContainer.getIdentifiedCustomer().getDiscountMultiplier()))
                            .setScale(2, RoundingMode.CEILING));
            if(grantDiscountCheck(FinalizeOrderMenu.getName(), FinalizeOrderMenu.getId())){
                orderController.setTotalPrice(orderController.totalPrice().subtract(discount));
            }
        } catch (NullPointerException e) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        System.out.println("Returning to main menu");
                        Menu.goToMainMenu();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            System.err.println("Customer not found!");
            runnable.run();
        }

    }

    public Customer getIdentifiedCustomer() {
        return customerContainer.getIdentifiedCustomer();
    }

    public void setIdentifiedCustomer(Customer identifiedCustomer) {
        customerContainer.setIdentifiedCustomer(identifiedCustomer);
    }
}
