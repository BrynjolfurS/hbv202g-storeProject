package com.example.shopsystem.currency;

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
public abstract class ObservableCurrency {
    private List<CurrencyObserver> observers;

    private String currency;

    public ObservableCurrency() {
        observers = new ArrayList<CurrencyObserver>();
    }

    public void attach(CurrencyObserver observer) {
        observers.add(observer);
    }

    public void detach(CurrencyObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (CurrencyObserver observer : observers) {
            observer.update(currency);
        }
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
