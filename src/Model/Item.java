package Model;

import ConsoleUI.Utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    // Codes that start with T refer to Timber department
    // Codes that start with D refer to DIY department
    // locationCode will be the result of appending location + shelfNumber + itemId
    private String locationCode;
    private char location;
    private int shelfNumber;
    private static int globalItemId = 1;
    private final int itemId;
    private String itemName;
    private BigDecimal price;
    private int barcode;
    private boolean applyDiscount;
    private double discountModifier = 0.1;

    public Item(char location,
                int shelfNumber,
                String itemName,
                boolean applyDiscount,
                BigDecimal price) {

        this.itemId = globalItemId;
        this.locationCode = location + String.valueOf(shelfNumber) + itemId;
        this.location = location;
        this.shelfNumber = shelfNumber;
        this.itemName = itemName;
        this.applyDiscount = applyDiscount;
        if(applyDiscount){
           this.price = price.subtract(price.multiply(new BigDecimal(discountModifier)));
        }else {
            this.price = price;
        }
        this.barcode = Utility.getRandom(100000, 999999);
        globalItemId++;

    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(boolean applyDiscount) {
        this.applyDiscount = applyDiscount;
    }

    public double getDiscountModifier() {
        return discountModifier;
    }

    public void setDiscountModifier(double discountModifier) {
        this.discountModifier = discountModifier;
    }

    @Override
    public String toString() {
        return "Item: " + "\n-----------------------------------\n" +
                "locationCode: " + locationCode + "\n" +
                "location: " + location + "\n" +
                "shelfNumber: " + shelfNumber + "\n" +
                "itemId: " + itemId + "\n" +
                "itemName: " + itemName + "\n" +
                "price: " + price.setScale(2, RoundingMode.CEILING) + "\n" +
                //"quantity: " + quantity + "\n" +
                "barcode: " + barcode + "\n" +
                "applyDiscount: " + applyDiscount + "\n" +
                "discountModifier: " + discountModifier + "\n" +
                "\n-----------------------------------\n" +
                "";
    }

}
