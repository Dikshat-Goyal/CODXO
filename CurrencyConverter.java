import java.util.*;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Setting up some sample exchange rates (to INR)
        exchangeRates.put("INR", 85.0);
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("CAD", 0.9);
        exchangeRates.put("PKR", 70.0);
    }

    // Method to add a new currency and its exchange rate relative to INR
    public void addCurrency(String currencyCode, double rateToINR) {
        exchangeRates.put(currencyCode.toUpperCase(), rateToINR);
    }

    // Method to convert amount from one currency to another
    public double convert(String fromCurrency, String toCurrency, double amount) {
        fromCurrency = fromCurrency.toUpperCase();
        toCurrency = toCurrency.toUpperCase();

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("Currency not supported.");
            return -1;
        }

        double rateFrom = exchangeRates.get(fromCurrency);
        double rateTo = exchangeRates.get(toCurrency);

        // Convert amount from 'fromCurrency' to INR, then to 'toCurrency'
        double amountInINR = amount / rateFrom;
        double convertedAmount = amountInINR * rateTo;

        return convertedAmount;
    }

    // Main method to handle user input and output
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        // Adding additional currencies
        converter.addCurrency("CAD", 1.25);
        converter.addCurrency("USD", 1.35);

        // Getting input from user
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter currency to convert from (e.g., INR, USD, CAD, PKR): ");
        String fromCurrency = scanner.next();

        System.out.print("Enter currency to convert to (e.g., INR, USD, CAD, PKR): ");
        String toCurrency = scanner.next();

        // Converting amounts
        double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);

        if (convertedAmount != -1) {
            System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
        }

        scanner.close();
    }
}
