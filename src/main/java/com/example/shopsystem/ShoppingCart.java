package com.example.shopsystem;

import com.example.shopsystem.currency.CurrencyObserver;
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
public class ShoppingCart implements CurrencyObserver {

    private List<StoreItem> cartItems;
    private String currency;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    @Override
    public void update(String currency) {
        // Breyta verðinu
    }

    public void addItem(StoreItem item) {
        cartItems.add(item);
    }

    public void removeItem(StoreItem item) {
        cartItems.remove(item);
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (StoreItem item : cartItems) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}