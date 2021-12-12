package Controller;

import ConsoleUI.FinalizeOrderMenu;
import ConsoleUI.Menu;
import Model.Customer;
import Model.CustomerContainer;
import Model.Database;
import Model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomerController {
    CustomerContainer customerContainer;

    public CustomerController(){customerContainer = CustomerContainer.getInstance();
    }

    public void addCustomer(Customer customer){
        customerContainer.addCustomer(customer);
    }

    // This method is used to check if the name of a customer matches the String name parameter
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

    // This method is used to check if the id of a customer matches the int id parameter
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

    // This method checks if both name and id match with a customer
    public boolean grantDiscountCheck(String name, int id){
        return matchName(name) && matchId(id);
    }

    // This method is used to get the customer that has a name matching the String name parameter
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

    public Customer getCustomerById(int id){
        Customer customer = null;

        try {
            for(int i = 0; i < customerContainer.getCustomers().size(); i++){
                if(customerContainer.getCustomers().get(i).getCustomerId() == id){
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

    // This method is used to calculate the discount that needs to be applied depending on the customer type,
    // after the discount is calculated, the totalPrice is set according to the discount
    // The price before applying the discount is calculated in the totalPrice() method by
    // adding all the prices of the itemsInOrder ArrayList
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

    public void createGuestCustomer(){
        customerContainer.createGuestCustomer();
    }
}
