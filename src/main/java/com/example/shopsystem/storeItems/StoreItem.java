package com.example.shopsystem.storeItems;

import com.example.shopsystem.currency.CurrencyConverter;
import com.example.shopsystem.currency.CurrencyObserver;

import java.util.Dictionary;
import java.util.Hashtable;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public abstract class StoreItem implements CurrencyObserver {

    private int id;
    private String name;

    private Dictionary<String, Double> priceByCurrency = new Hashtable<>();
    private double currentPrice;

    public StoreItem(int id, String name, double priceInDollars) {
        this.id = id;
        this.name = name;
        this.currentPrice = priceInDollars;
        priceByCurrency.put("USD", this.currentPrice);
        priceByCurrency.put("ISK", CurrencyConverter.convert("USD","ISK",priceInDollars));
        priceByCurrency.put("EURO", CurrencyConverter.convert("USD","EURO",priceInDollars));
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
        return currentPrice;
    }
    public void setPrice(double price) {
        this.currentPrice = price;
    }
    @Override
    public void update(String currencyTo) {
        this.setPrice(priceByCurrency.get(currencyTo));
    }
}
