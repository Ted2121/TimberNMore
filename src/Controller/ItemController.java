package Controller;

import Model.Item;
import Model.ItemContainer;
import Model.OrderContainer;

import java.util.ArrayList;

public class ItemController {
    private final ItemContainer itemContainer;



    public ItemController(){itemContainer = ItemContainer.getInstance();
    }

    public void addItemToInventory(Item item){
        itemContainer.addItemToInventory(item);
    }

    public void searchForItem(String name){
        Item matchingItem = null;
        try {
            for (Item item:itemContainer.getInventory()) {
                if(item.getItemName().toLowerCase().contains(name.toLowerCase())){

                    matchingItem = item;

                    itemContainer.getSearchedItems().add(matchingItem);
                }
            }
            if (matchingItem == null){
                System.err.println("Item not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scanItem(int barcode){
        Item matchingItem = null;
        try {
            for (Item item:itemContainer.getInventory()) {
                if(item.getBarcode() == barcode){

                    matchingItem = item;

                    OrderContainer.getInstance().getItemsInOrder().add(matchingItem);
                }
            }
            if (matchingItem == null){
                System.err.println("Item not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getLocationCodesToFindItems() {
        return itemContainer.getLocationCodesToFindItems();
    }

    public ArrayList<Item> getSearchedItems() {
        return itemContainer.getSearchedItems();
    }

    public ArrayList<Item> getInventory(){
        return itemContainer.getInventory();
    }

}
