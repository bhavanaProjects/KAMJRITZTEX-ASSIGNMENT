public class FraudDetection {
    public static boolean isFraudulentTransaction(String transactionData) {
        // Parse transaction data (assuming JSON format for simplicity)
        // In real applications, use a JSON library like Jackson or Gson
        // Example rule: if transaction amount > 1000, mark as fraudulent

        double amount = extractTransactionAmount(transactionData);
        return amount > 1000;
    }

    private static double extractTransactionAmount(String transactionData) {
        // Extract the amount from the transaction data
        // This is a placeholder. Use a proper JSON parser in a real application
        return Double.parseDouble(transactionData.split(",")[1].split(":")[1]);
    }
}
