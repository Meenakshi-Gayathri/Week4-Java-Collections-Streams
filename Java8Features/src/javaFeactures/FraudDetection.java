package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

class FraudAlert {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    FraudAlert(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public String toString() {
        return "Policy Number: " + policyNumber + ", Fraud Count: " + fraudCount + ", Total Fraud Amount: " + totalFraudAmount;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String transactionId = in.nextLine();
            String policyNumber = in.nextLine();
            double amount = in.nextDouble();
            in.nextLine();
            String transactionDate = in.nextLine();
            boolean isFraudulent = in.nextBoolean();
            in.nextLine();
            transactions.add(new Transaction(transactionId, policyNumber, amount, transactionDate, isFraudulent));
        }

        Map<String, List<Transaction>> fraudulentTransactions = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        fraudulentTransactions.forEach((policyNumber, transactionsList) -> {
            long fraudCount = transactionsList.size();
            double totalFraudAmount = transactionsList.stream().mapToDouble(Transaction::getAmount).sum();

            if (fraudCount > 5 || totalFraudAmount > 50000) {
                FraudAlert alert = new FraudAlert(policyNumber, fraudCount, totalFraudAmount);
                System.out.println("ALERT: " + alert);
            }
        });
    }
}

