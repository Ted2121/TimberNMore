package Controller;

import ConsoleUI.FinalizeOrderMenu;
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

        for (int i = 0; i < customerContainer.getCustomers().size(); i++){
            if (customerContainer.getCustomers().get(i).getName().equalsIgnoreCase(name)) {
                matched = true;
                break;
            }
        }

        return matched;
    }

    public boolean matchId(int id){
        boolean matched = false;

        for(int i = 0; i < customerContainer.getCustomers().size(); i++){
            if(customerContainer.getCustomers().get(i).getCustomerId() == id){
                matched = true;
                break;
            }
        }
        return matched;
    }

    public boolean grantDiscount(String name, int id){
        return matchName(name) && matchId(id);
    }

    public Customer getCustomerByName(String name){
        Customer customer = null;

        for(int i = 0; i < customerContainer.getCustomers().size(); i++){
                if(customerContainer.getCustomers().get(i).getName().equalsIgnoreCase(name)){
                    customer = customerContainer.getCustomers().get(i);
                    break;
                }
        }
        return customer;
    }

    private void grantDiscount(){

        BigDecimal discount = orderController.totalPrice()
                .multiply(new BigDecimal(String.valueOf(customerContainer.getIdentifiedCustomer().getDiscountMultiplier()))
                        .setScale(2, RoundingMode.CEILING));
        if(grantDiscount(FinalizeOrderMenu.getName(), FinalizeOrderMenu.getId())){
            orderController.setTotalPrice(orderController.totalPrice().subtract(discount));
        }

    }

    public Customer getIdentifiedCustomer() {
        return customerContainer.getIdentifiedCustomer();
    }

    public void setIdentifiedCustomer(Customer identifiedCustomer) {
         customerContainer.setIdentifiedCustomer(identifiedCustomer);
    }
}
