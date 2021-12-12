package Model;


import ConsoleUI.Menu;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CustomerContainer {

    private ArrayList<Customer> customers;
    private ArrayList<Customer> guestCustomers;
    private static CustomerContainer instance;
    Customer identifiedCustomer;


    private CustomerContainer(){
        customers = new ArrayList<>();
        guestCustomers = new ArrayList<>();
        identifiedCustomer = new Customer();
    }

    // singleton
    public static CustomerContainer getInstance(){
        if(instance==null)
            instance = new CustomerContainer();
        return instance;
    }

    public void createGuestCustomer() {
        Customer guest = new Customer("Guest", "guest");
        guestCustomers.add(guest);
        customers.add(guest);

    }

    public StringBuilder getGuestDetails(){
        StringBuilder details = null;

        try {
            for (Customer guest:
                 guestCustomers) {
                details.append("Name: ").append(guest.getName())
                        .append("\nID: ").append(guest.getCustomerId())
                        .append("\nDate and time: ").append(guest.getGuestCreationTime())
                        .append("\n-----------------------------------\n");
            }
        } catch (NullPointerException e) {
            System.err.println("No guest to display");
            Menu.goToMainMenu();
        }
        return details;
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
