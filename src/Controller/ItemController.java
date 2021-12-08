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

    public Item searchForItem(String name){
        Item itemToReturn = null;
        for (Item item:itemContainer.getInventory()) {
            if(item.getItemName().toLowerCase().contains(name.toLowerCase())){

            itemToReturn = item;

                try {
                    itemContainer.getSearchedItems().add(itemToReturn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (itemToReturn == null){
            System.err.println("Item not found");
        }
        return itemToReturn;
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
