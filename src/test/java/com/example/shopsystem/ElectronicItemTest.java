package com.example.shopsystem;

import com.example.shopsystem.storeItems.ElectronicItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectronicItemTest {
    private ElectronicItem electronicItem;

    @BeforeEach
    public void setUp() {
        electronicItem = new ElectronicItem(1, "Test Gadget", 150.0, "Test Brand");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ElectronicItem.getTypeDependantString()
     * testing to see if the type dependant string returns the correct string
     */
    @Test
    public void testGetTypeDependantString() {
        assertEquals("Test Brand", electronicItem.getTypeDependantString(), "getTypeDependantString should return the brand");
    }

    /**
     * test method for com.example.shopsystem.storeItems.ElectronicItem.getBrand()
     * testing to see if it returns the correct brand
     */
    @Test
    public void testGetBrand() {
        assertEquals("Test Brand", electronicItem.getBrand(), "getBrand should return the correct brand");
    }
}
