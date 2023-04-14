package com.example.shopsystem.currency;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class CurrencySelector extends ObservableCurrency{

    public CurrencySelector() {
    }

    public void selectCurrency(String currency) {
        setCurrency(currency);
    }
}
