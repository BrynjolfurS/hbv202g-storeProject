package com.example.shopsystem.storeItems;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 * Singleton class that is used to build variants of the
 * ShopItem class.
 ***********************************************************/
public class ItemFactory {

    private static ItemFactory factoryInstance;
    private static int nextId = 0;

    public static ItemFactory getInstance() {
        if (factoryInstance == null) {
            factoryInstance = new ItemFactory();
        }
        return factoryInstance;
    }

    public StoreItem createItem(String itemType, String name, double price, String stringAttribute) {
        if (itemType == null) {
            return null;
        }
        if (itemType.equalsIgnoreCase("ELECTRONICITEM")) {
            nextId++;
            return new ElectronicItem(nextId, name, price, stringAttribute);
        }
        else if (itemType.equalsIgnoreCase("BOOKITEM")) {
            nextId++;
            return new BookItem(nextId, name, price, stringAttribute);
        }
        else if (itemType.equalsIgnoreCase("CLOTHINGITEM")) {
            nextId++;
            return new ClothingItem(nextId, name, price, stringAttribute);
        }
        else {
            return null;
        }
    }
}
