package com.example.shopsystem;

import com.example.shopsystem.currency.ObservableCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObservableCurrencyTest {
    private class TestCurrency extends ObservableCurrency {
    }

    private TestCurrency observableCurrency;

    @BeforeEach
    public void setUp() {
        observableCurrency = new TestCurrency();
    }

    /**
     * test method for com.example.shopsystem.currency.ObservableCurrency.setCurrency()
     * it's testing if the currency is set correctly
     */

    @Test
    public void testSetCurrency() {
        observableCurrency.setCurrency("ISK");
        assertEquals("ISK", observableCurrency.getCurrency(), "Currency should be set to ISK");

        observableCurrency.setCurrency("EURO");
        assertEquals("EURO", observableCurrency.getCurrency(), "Currency should be set to EURO");
    }

    /**
     * test method for com.example.shopsystem.currency.ObservableCurrency.getSymbol()
     * it's testing if the correct symbol is returned
     */
    @Test
    public void testGetSymbol() {
        observableCurrency.setCurrency("USD");
        assertEquals("$", observableCurrency.getSymbol(), "Currency symbol for USD should be $");

        observableCurrency.setCurrency("ISK");
        assertEquals("kr", observableCurrency.getSymbol(), "Currency symbol for ISK should be kr");

        observableCurrency.setCurrency("EURO");
        assertEquals("€", observableCurrency.getSymbol(), "Currency symbol for EURO should be €");
    }
}