package com.example.shopsystem;

import com.example.shopsystem.storeItems.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemFactoryTest {
    private ItemFactory itemFactory = ItemFactory.getInstance();

    /**
     * test method for com.example.shopsystem.storeItems.ItemFactory.createItem()
     * it's testing if the electronicItem is created correctly
     */
    @Test
    public void testCreateElectronicItem() {
        StoreItem electronicItem = itemFactory.createItem("ELECTRONICITEM", "Test Gadget", 150.0, "Test Brand");
        assertTrue(electronicItem instanceof ElectronicItem, "ItemFactory should create an ElectronicItem instance");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ItemFactory.createItem()
     * it's testing to see if the bookItem is created correctly
     */
    @Test
    public void testCreateBookItem() {
        StoreItem bookItem = itemFactory.createItem("BOOKITEM", "Test Book", 100.0, "Test Author");
        assertTrue(bookItem instanceof BookItem, "ItemFactory should create a BookItem instance");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ItemFactory.createItem()
     * it's testing to see if the clothingItem is created correctly
     */
    @Test
    public void testCreateClothingItem() {
        StoreItem clothingItem = itemFactory.createItem("CLOTHINGITEM", "Test Shirt", 50.0, "M");
        assertTrue(clothingItem instanceof ClothingItem, "ItemFactory should create a ClothingItem instance");
    }
}
