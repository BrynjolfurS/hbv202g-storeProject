package com.example.shopsystem;

import com.example.shopsystem.storeItems.ClothingItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClothingItemTest {
    private ClothingItem clothingItem;

    @BeforeEach
    public void setUp() {
        clothingItem = new ClothingItem(1, "Test Shirt", 50.0, "M");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ClothingItem.getTypeDependantString()
     * testing to see if the type dependant string returns the correct string
     */
    @Test
    public void testGetTypeDependantString() {
        assertEquals("M", clothingItem.getTypeDependantString(), "getTypeDependantString should return the size");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ClothingItem.getSizes()
     * testing to see if it returns the correct sizes
     */
    @Test
    public void testGetSize() {
        assertEquals("M", clothingItem.getSize(), "getSize should return the correct size");
    }
}
