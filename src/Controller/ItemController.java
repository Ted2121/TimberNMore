package Controller;

import Model.Item;
import Model.ItemContainer;

public class ItemController {
    private ItemContainer itemContainer;

    public ItemController(){itemContainer = ItemContainer.getInstance();}

    public void addItemToInventory(Item item){
        itemContainer.addItemToInventory(item);
    }

    public Item searchForItem(String name){
        Item itemToReturn = null;
        for (Item item:itemContainer.getInventory()) {
            if(item.getItemName().toLowerCase().contains(name.toLowerCase())){

            itemToReturn = item;

            }else{continue;}
        }
        return itemToReturn;
    }
}
