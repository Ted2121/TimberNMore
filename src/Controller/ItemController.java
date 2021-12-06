package Controller;

import Model.Item;
import Model.ItemContainer;

import java.util.ArrayList;

public class ItemController {
    private ItemContainer itemContainer;
    private ArrayList<String> itemsToFindLocationCodes;

    public ItemController(){itemContainer = ItemContainer.getInstance();}

    public void addItemToInventory(Item item){
        itemContainer.addItemToInventory(item);
    }

    public Item searchForItem(String name){
        Item itemToReturn = null;
        for (Item item:itemContainer.getInventory()) {
            if(item.getItemName().toLowerCase().contains(name.toLowerCase())){

            itemToReturn = item;
            itemsToFindLocationCodes.add(item.getLocationCode());
            }else{continue;}
        }
        return itemToReturn;
    }
}
