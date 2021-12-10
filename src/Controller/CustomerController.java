package Controller;

import Model.Customer;
import Model.CustomerContainer;

public class CustomerController {
    CustomerContainer customerContainer;

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
