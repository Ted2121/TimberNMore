package Model;

import ConsoleUI.Utility;

import java.time.LocalDateTime;

public class Customer {
    private String name;
    private static int globalCustomerId = 1;
    private int customerId;
    private String customerType;
    private double discountMultiplier;
    private String guestCreationTime;

    public Customer(String name, String customerType) {
        this.customerId = globalCustomerId;
        this.name = name;
        this.customerType = customerType;
        this.discountMultiplier = switch (customerType.toLowerCase()){
            case "premium" -> 0.1;
            case "regular" -> 0.05;
            default -> 0;};
        // used for guest customer identification
        this.guestCreationTime = LocalDateTime.now().format(Utility.getFormat());
        globalCustomerId++;
        }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getDiscountMultiplier() {
        return discountMultiplier;
    }

    public void setDiscountMultiplier(double discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
    }

    public static int getGlobalCustomerId() {
        return globalCustomerId;
    }

    public String getGuestCreationTime() {
        return guestCreationTime;
    }

    public void setGuestCreationTime(String guestCreationTime) {
        this.guestCreationTime = guestCreationTime;
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        try {
            stringToReturn =  "Customer: " + "\n-----------------------------------\n" +
                    "name: " + name + "\n" +
                    "customerId: " + customerId + "\n" +
                    "customerType: " + customerType + "\n" +
                    "discountMultiplier: " + discountMultiplier + "\n" +
                    "";
        } catch (NullPointerException e) {
            System.err.println("Something went wrong retrieving customer information");
        }
        return stringToReturn;
    }
}

