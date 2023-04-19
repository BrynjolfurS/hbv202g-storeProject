package com.example.shopsystem;

import com.example.shopsystem.currency.CurrencyConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterTest {

    /**
     * test method for com.example.shopsystem.currency.CurrencyConverter.convert()
     * testing the conversion of currency from USD to ISK and USD to EURO.
     */
    @Test
    public void testConvertFromUSD() {
        double usdToIsk = CurrencyConverter.convert("USD", "ISK", 1);
        double usdToEuro = CurrencyConverter.convert("USD", "EURO", 1);

        assertEquals(136.15, usdToIsk, 0.01, "USD to ISK conversion should be correct");
        assertEquals(0.90, usdToEuro, 0.01, "USD to EURO conversion should be correct");
    }
}
