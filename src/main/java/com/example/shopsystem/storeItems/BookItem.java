package com.example.shopsystem.storeItems;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class BookItem extends StoreItem {

    private String Author;

    public BookItem(int id, String name, double price, String author) {
        super(id, name, price);
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }
}
