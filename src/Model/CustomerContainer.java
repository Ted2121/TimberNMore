package Model;

import java.util.ArrayList;

public class CustomerContainer {

    private ArrayList<Customer> customers;
    private static CustomerContainer instance;
    Customer identifiedCustomer;

    private CustomerContainer(){
        customers = new ArrayList<Customer>();
        identifiedCustomer = new Customer();
    }

    // singleton
    public static CustomerContainer getInstance(){
        if(instance==null)
            instance = new CustomerContainer();
        return instance;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer getIdentifiedCustomer() {
        return identifiedCustomer;
    }

    public void setIdentifiedCustomer(Customer identifiedCustomer) {
        this.identifiedCustomer = identifiedCustomer;
    }

    //    public double getDiscountMultiplier() {
//        return cus;
//    }
}
