package Currency;

import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Coin converter = new Coin();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        converter.displayAvailableCurrencies();

        while (true) {
            System.out.print("Enter the currency you want to convert from (or type 'exit' to quit): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            if (fromCurrency.equals("EXIT")) {
                break;
            }

            System.out.print("Enter the currency you want to convert to: ");
            String toCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            try {
                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Thank you for using the Currency Converter!");
        scanner.close();
    }
}

