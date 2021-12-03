package Controller;

import Model.Item;
import Model.ItemContainer;

public class ItemController {
    private ItemContainer itemContainer;

    public ItemController(){itemContainer = ItemContainer.getInstance();}

    public void addItemToInventory(Item item){
        itemContainer.addItemToInventory(item);
    }
}
