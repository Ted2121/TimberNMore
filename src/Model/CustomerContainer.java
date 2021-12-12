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

    public String getGuestDetails(){
        String details = "";

        try {
            for (Customer guest:
                 guestCustomers) {
                details += "Name: " + guest.getName() +
                        "\nID: " + guest.getCustomerId() +
                        "\nDate and time: " + guest.getGuestCreationTime() +
                        "\n-----------------------------------\n";
            }
        } catch (NullPointerException e) {
            System.err.println("No guest to display");
            System.out.println(guestCustomers.toString());
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
