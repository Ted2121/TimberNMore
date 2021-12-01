package Model;

import java.math.BigDecimal;

public class Item {
    // Codes that start with T refer to Timber department
    // Codes that start with D refer to DIY department
    // locationCode will be the result of appending location + shelfNumber + itemId
    private String locationCode;
    private char location;
    private int shelfNumber;
    private static int itemId = 0;

    private String itemName;
    private BigDecimal price;

    private int barcode;
    private boolean applyDiscount;
    private static final double discountModifier = 0.1;

    public Item(char location,
                int shelfNumber,
                String itemName,
                boolean applyDiscount,
                BigDecimal price) {

        this.locationCode = String.valueOf(location + shelfNumber + itemId);
        this.location = location;
        this.shelfNumber = shelfNumber;
        this.itemName = itemName;
        this.applyDiscount = applyDiscount;
        if(applyDiscount){
           this.price = price.multiply(new BigDecimal(discountModifier));
        }else {
            this.price = price;
        }
        this.barcode = (int)Math.round(Math.random()*1000000);


    }
}
