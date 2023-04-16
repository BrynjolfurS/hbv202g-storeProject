package com.example.shopsystem.currency;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public abstract class ObservableCurrency {
    private static final Dictionary<String, String> currencySymbols = new Hashtable<>();
    private List<CurrencyObserver> observers;
    private String currency;

    public ObservableCurrency() {
        observers = new ArrayList<CurrencyObserver>();
        currency = "USD";
        currencySymbols.put("USD", "$");
        currencySymbols.put("ISK", "kr");
        currencySymbols.put("EURO", "€");
    }

    public void attach(CurrencyObserver observer) {
        observers.add(observer);
    }

    public void detach(CurrencyObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String currencyTo) {
        for (CurrencyObserver observer : observers) {
            observer.update(currencyTo);
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSymbol() {
        return currencySymbols.get(currency);
    }

}
