package com.example.shopsystem.dummyData;

import com.example.shopsystem.storeItems.ItemFactory;
import com.example.shopsystem.storeItems.StoreItem;

import java.util.ArrayList;
import java.util.List;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class DummyDataGenerator {

    private List<StoreItem> storeItems;
    private List<StoreItem> bookItems;
    private List<StoreItem> clothingItems;

    public DummyDataGenerator() {
        this.storeItems = new ArrayList<>();
        generateDummyItems();
    }

    public List<StoreItem> getStoreItems() {
        return storeItems;
    }

    private void generateDummyItems() {
        ItemFactory factory = ItemFactory.getInstance();
        // Electronic Items
        storeItems.add(factory.createItem("ElectronicItem", "Smartphone", 499.99, "Apple"));
        storeItems.add(factory.createItem("ElectronicItem", "Laptop", 999.99, "Dell"));
        storeItems.add(factory.createItem("ElectronicItem", "Headphones", 149.99, "Sony"));

        // Book Items
        storeItems.add(factory.createItem("BookItem", "The Catcher in the Rye", 12.99, "J.D. Salinger"));
        storeItems.add(factory.createItem("BookItem", "To Kill a Mockingbird", 14.99, "Harper Lee"));
        storeItems.add(factory.createItem("BookItem", "1984", 11.99, "George Orwell"));

        // Clothing Items
        storeItems.add(factory.createItem("ClothingItem", "T-Shirt", 19.99, "M"));
        storeItems.add(factory.createItem("ClothingItem", "Jeans", 39.99, "L"));
        storeItems.add(factory.createItem("ClothingItem", "Jacket", 79.99, "XL"));
    }
}
