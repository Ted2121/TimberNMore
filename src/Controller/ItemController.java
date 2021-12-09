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

                    OrderContainer.getInstance().createAndGetItemsInOrder().add(matchingItem);
                }
            }
            if (matchingItem == null){
                System.err.println("Item not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearSearchHistory(){
        itemContainer.getLocationCodesToFindItems().clear();
        itemContainer.getSearchedItems().clear();
    }

    public ArrayList<String> getLocationCodesFromSearched(){

        for (Item item:
                getSearchedItems()) {
            getLocationCodesToFindItems().add(item.getLocationCode());
        }

        return getLocationCodesToFindItems();
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
