package Controller;

import ConsoleUI.FinalizeOrderMenu;
import ConsoleUI.Menu;
import Model.Customer;
import Model.CustomerContainer;
import Model.Database;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomerController {
    CustomerContainer customerContainer;


//    CustomerController customerController = new CustomerController();


    public CustomerController(){customerContainer = CustomerContainer.getInstance();
       // database = Database.getInstance();
    }

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

            System.err.println("Customer or order could not be found!");
            Menu.goToMainMenu();
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

            System.err.println("Customer or order could not be found!");
            Menu.goToMainMenu();
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

            System.err.println("Customer or order could not be found!");
            Menu.goToMainMenu();
        }
        return customer;
    }

    public void grantDiscount(){

        try {
            BigDecimal discount = Database.getInstance().getOrderController().totalPrice()
                    .multiply(new BigDecimal(String.valueOf(customerContainer.getIdentifiedCustomer().getDiscountMultiplier()))
                            .setScale(2, RoundingMode.CEILING));
            if(grantDiscountCheck(FinalizeOrderMenu.getName(), FinalizeOrderMenu.getId())){
                Database.getInstance().getOrderController().setTotalPrice(Database.getInstance().getOrderController().totalPrice().subtract(discount));
            }
        } catch (NullPointerException e) {

            System.err.println("Customer or order could not be found!");
            Menu.goToMainMenu();
        }

    }

    public Customer getIdentifiedCustomer() {
        return customerContainer.getIdentifiedCustomer();
    }

    public void setIdentifiedCustomer(Customer identifiedCustomer) {
        customerContainer.setIdentifiedCustomer(identifiedCustomer);
    }
}
