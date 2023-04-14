package com.example.shopsystem.storeItems;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class ClothingItem extends StoreItem {

    private String size;

    public ClothingItem(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public String getTypeDependantString() {
        return getSize();
    }

    public String getSize() {
        return size;
    }
}
