package com.example.shopsystem;

import com.example.shopsystem.storeItems.ElectronicItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    /**
     * test method for com.example.shopsystem.ShoppingCart.addItem()
     * it's testing if the item is added to the shopping cart
     */
    @Test
    public void testAddItem() {
        ElectronicItem item = new ElectronicItem(1, "Test Item", 100.0, "Test Brand");
        shoppingCart.addItem(item);
        assertTrue(shoppingCart.getCartItems().contains(item), "Item should be added to the cart");
    }

    /**
     * test method for com.example.shopsystem.ShoppingCart.removeItem()
     * it's testing if the item is removed from the shopping cart
     */
    @Test
    public void testRemoveItem() {
        ElectronicItem item = new ElectronicItem(1, "Test Item", 100.0, "Test Brand");
        shoppingCart.addItem(item);
        shoppingCart.removeItem(item);
        assertFalse(shoppingCart.getCartItems().contains(item), "Item should be removed from the cart");
    }

    /**
     * test method for com.example.shopsystem.ShoppingCart.getTotalCost()
     * it's testing to see if the total cost of the shopping cart is correct
     */
    @Test
    public void testGetTotalCost() {
        ElectronicItem item1 = new ElectronicItem(1, "Test Item 1", 100.0, "Test Brand");
        ElectronicItem item2 = new ElectronicItem(2, "Test Item 2", 200.0, "Test Brand");
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        double expectedTotalCost = item1.getPrice() + item2.getPrice();
        assertEquals(expectedTotalCost, shoppingCart.getTotalCost(), "Total cost should be the sum of item prices");
    }
}
