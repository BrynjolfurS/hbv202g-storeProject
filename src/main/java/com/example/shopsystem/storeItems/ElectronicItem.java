package com.example.shopsystem.storeItems;

import com.example.shopsystem.currency.CurrencyConverter;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class ElectronicItem extends StoreItem {

    private String brand;

    public ElectronicItem(int id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public String getTypeDependantString() {
        return getBrand();
    }

    public String getBrand() {
        return brand;
    }

}
