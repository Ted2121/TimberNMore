package Model;

import java.util.ArrayList;

public class ItemContainer {
    private ArrayList<Item> inventory;
    private static ItemContainer instance;
    private ArrayList<String> locationCodesToFindItems;
    private ArrayList<Item> searchedItems;

    private ItemContainer(){
        this.inventory = new ArrayList<Item>();
        this.locationCodesToFindItems = new ArrayList<>();
        this.searchedItems = new ArrayList<Item>();
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


    public ArrayList<Item> getSearchedItems() {
        return searchedItems;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<String> getLocationCodesToFindItems() {
        return locationCodesToFindItems;
    }

    public void setLocationCodesToFindItems(ArrayList<String> locationCodesToFindItems) {
        this.locationCodesToFindItems = locationCodesToFindItems;
    }
}
