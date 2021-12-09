package Controller;

import Model.Customer;
import Model.CustomerContainer;

public class CustomerController {
    CustomerContainer customerContainer;

    public CustomerController(){customerContainer = CustomerContainer.getInstance();}

    public void addCustomer(Customer customer){
        customerContainer.addCustomer(customer);
    }

    // TODO
// DO NOT PUT THIS IN THE DIAGRAMS
//
//        boolean found = false;
//        int i = 0;
//        while(!found && i<persons.size()){
//            if(persons.get(i).getName().equals(name))
//                found = true;
//            else
//                i++;
//        }
//        if(found)
//            return persons.get(i);
//        else{
//
//            return null;}
//    }
}
