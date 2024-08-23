package Currency;

import java.util.HashMap;
import java.util.Map;

public class Coin {
    private Map<String, Double> exchangeRates;

    public Coin() {
        exchangeRates = new HashMap<>();
        // Example exchange rates
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        double baseAmount = amount / exchangeRates.get(fromCurrency);
        return baseAmount * exchangeRates.get(toCurrency);
    }

    public void displayAvailableCurrencies() {
        System.out.println("Available currencies: " + exchangeRates.keySet());
    }
}

