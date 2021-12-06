package Model;

import java.util.ArrayList;

public class ItemContainer {
    private ArrayList<Item> inventory;
    private static ItemContainer instance;

    private ItemContainer(){
        inventory = new ArrayList<Item>();
    }

    // singleton
    public static ItemContainer getInstance(){
        if(instance ==null)
            instance = new ItemContainer();
        return instance;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

//    public Item searchForItem(String name){
//        Item itemToReturn = null;
//        for (Item item:inventory) {
//            if(item.getItemName().contains(name.toLowerCase())){
//
//            itemToReturn = item;
//            }
//            continue;
//        }
//        return itemToReturn;
//    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
