package Controller;

import Model.Item;
import Model.ItemContainer;

import java.util.ArrayList;

public class ItemController {
    private final ItemContainer itemContainer;


    public ItemController(){itemContainer = ItemContainer.getInstance();
    }

    public void addItemToInventory(Item item){
        itemContainer.addItemToInventory(item);
    }

    public void searchForItem(String name){
        Item itemToReturn = null;
        try {
            for (Item item:itemContainer.getInventory()) {
                if(item.getItemName().toLowerCase().contains(name.toLowerCase())){

                    itemToReturn = item;

                    itemContainer.getSearchedItems().add(itemToReturn);
                }
            }
            if (itemToReturn == null){
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
