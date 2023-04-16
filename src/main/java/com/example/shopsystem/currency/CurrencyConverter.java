package com.example.shopsystem.currency;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 * Class contains conversion rates as they were at 16.04.2023
 * Rates are used to convert an amount of currency into another
 * via the 'convert' method
 ***********************************************************/
public class CurrencyConverter {

    // Conversion rates (1 unit of the base currency to the target currency)
    private static final double USD_TO_EURO = 0.90;
    private static final double USD_TO_ISK = 136.15;
    private static final double EURO_TO_USD = 1.11;
    private static final double EURO_TO_ISK = 149.65;
    private static final double ISK_TO_USD = 0.0074;
    private static final double ISK_TO_EURO = 0.0067;

    /**
     * Converts the given amount from one currency to another.
     * @param fromCurrency The original currency.
     * @param toCurrency The target currency.
     * @param amount The amount of money to convert.
     * @return The converted amount of money.
     * @throws IllegalArgumentException if an unsupported currency is provided.
     */
    public static double convert(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency.equals("USD")) {
            return convertFromUSD(toCurrency, amount);
        }
        // Only USD to ISK and USD to EURO is ever used in the current state of the system
        else if (fromCurrency.equals("ISK")) {
            return convertFromISK(toCurrency, amount);
        } else if (fromCurrency.equals("EURO")) {
            return convertFromEuro(toCurrency, amount);
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + fromCurrency);
        }
    }

    private static double convertFromUSD(String toCurrency, double amount) {
        if (toCurrency.equals("USD")) {
            return amount;
        } else if (toCurrency.equals("ISK")) {
            return amount * USD_TO_ISK;
        } else if (toCurrency.equals("EURO")) {
            return amount * USD_TO_EURO;
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + toCurrency);
        }
    }

    private static double convertFromISK(String toCurrency, double amount) {
        if (toCurrency.equals("USD")) {
            return amount / ISK_TO_USD;
        } else if (toCurrency.equals("ISK")) {
            return amount;
        } else if (toCurrency.equals("EURO")) {
            return amount / ISK_TO_EURO;
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + toCurrency);
        }
    }

    private static double convertFromEuro(String toCurrency, double amount) {
        if (toCurrency.equals("USD")) {
            return amount * EURO_TO_USD;
        } else if (toCurrency.equals("ISK")) {
            return amount * EURO_TO_ISK;
        } else if (toCurrency.equals("EURO")) {
            return amount;
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + toCurrency);
        }
    }
}
