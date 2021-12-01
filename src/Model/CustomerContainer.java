package Model;

import java.util.ArrayList;

public class CustomerContainer {

    private ArrayList<Customer> customers;
    private static CustomerContainer instance;

    private CustomerContainer(){
        customers = new ArrayList<Customer>();
    }

    // singleton
    public static CustomerContainer getInstance(){
        if(instance==null)
            instance = new CustomerContainer();
        return instance;
    }
}
