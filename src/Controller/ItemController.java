package Controller;

import ConsoleUI.Menu;
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

    // This method finds the item that has a matching name with the parameter
    // and adds it to an ArrayList of searched items
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

    // This method gets the item from the database that has a barcode matching with the parameter
    public Item scanItem(int barcode){
        Item matchingItem = null;
        try {
            for (Item item:itemContainer.getInventory()) {
                if(item.getBarcode() == barcode){

                    matchingItem = item;
                }
            }
            if (matchingItem == null){
                System.err.println("Item not found");
            }
        } catch (NullPointerException e) {
            System.err.println("Item could not be found");
            Menu.goToMainMenu();
        }
        return matchingItem;
    }

    // This method finds the item with a matching barcode and adds it to the itemsInOrder ArrayList
    public void scanAndAdd(int barcode){

            OrderContainer.getInstance().createAndGetItemsInOrder().add(scanItem(barcode));
    }

    // This method finds the item with a matching barcode and removes it from the itemsInOrder ArrayList
    public void scanAndRemove(int barcode){
        OrderContainer.getInstance().createAndGetItemsInOrder().remove(scanItem(barcode));
    }

    // This method deletes the item search history once the receipt is printed and the order is in the database
    public void clearSearchHistory(){
        itemContainer.getLocationCodesToFindItems().clear();
        itemContainer.getSearchedItems().clear();
    }

    // This method returns an ArrayList of item details (name and location codes)
    // to make it easier for the sales assistant to find the items in the store
    public ArrayList<String> getLocationCodesFromSearched(){

        for (Item item:
                getSearchedItems()) {
            getLocationCodesToFindItems().add(item.getLocationCode());
        }

        return getLocationCodesToFindItems();
    }

    // Used by the method getLocationCodesFromSearched()
    public ArrayList<String> getLocationCodesToFindItems() {
        return itemContainer.getLocationCodesToFindItems();
    }

    // Used by the method getLocationCodesFromSearched()
    public ArrayList<Item> getSearchedItems() {
        return itemContainer.getSearchedItems();
    }

    public ArrayList<Item> getInventory(){
        return itemContainer.getInventory();
    }

}
