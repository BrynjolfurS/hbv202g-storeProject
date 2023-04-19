package com.example.shopsystem;

import com.example.shopsystem.currency.CurrencySelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencySelectorTest {
    private CurrencySelector currencySelector;

    @BeforeEach
    public void setUp() {
        currencySelector = new CurrencySelector();
    }

    /***
     * Test method for com.example.shopsystem.currency.CurrencySelector.getCurrency()
     * testing to see if the currency is set correctly
     * */

    @Test
    public void testSelectCurrency() {
        currencySelector.selectCurrency("ISK");
        assertEquals("ISK", currencySelector.getCurrency(), "Currency should be set to ISK");

        currencySelector.selectCurrency("EURO");
        assertEquals("EURO", currencySelector.getCurrency(), "Currency should be set to EURO");
    }
}
