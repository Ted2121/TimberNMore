package Model;

public class Customer {
    private String name;
    private static int customerId = 1;
    private String customerType;
    private final double discountMultiplier;

    public Customer(String name, String customerType) {
        this.name = name;
        this.customerType = customerType;
        this.discountMultiplier = switch (customerType.toLowerCase()){
            case "premium" -> 0.1;
            case "regular" -> 0.05;
            default -> 0;};
        customerId++;
        }
    }

