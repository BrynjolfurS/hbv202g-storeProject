package com.example.shopsystem.storeItems;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public abstract class StoreItem {

    private int id;
    private String name;
    private double price;

    public StoreItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTypeDependantString() {
        return "";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
