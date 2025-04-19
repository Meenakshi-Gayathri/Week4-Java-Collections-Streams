package collections;

import java.util.*;

class Withdrawal {
    int accountNo;
    double withdrawAmount;

    public Withdrawal(int accountNo, double withdrawAmount) {
        this.accountNo = accountNo;
        this.withdrawAmount = withdrawAmount;
    }
}

public class BankingSystem{

    HashMap<Integer, Double> accountMap = new HashMap<>();
    TreeMap<Double, List<Integer>> balanceMap = new TreeMap<>();
    Queue<Withdrawal> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accNo, double initialBalance) {
        accountMap.put(accNo, initialBalance);
        balanceMap.putIfAbsent(initialBalance, new ArrayList<>());
        balanceMap.get(initialBalance).add(accNo);
    }

    public void addWithdrawalRequest(int accNo, double amount) {
        withdrawalQueue.offer(new Withdrawal(accNo, amount));
    }

    public void processAllWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            Withdrawal current = withdrawalQueue.poll();
            int accNo = current.accountNo;
            double amount = current.withdrawAmount;

            if (!accountMap.containsKey(accNo)) {
                System.out.println("Account " + accNo + " does not exist.");
                continue;
            }

            double currentBalance = accountMap.get(accNo);

            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accountMap.put(accNo, newBalance);

                balanceMap.get(currentBalance).remove(Integer.valueOf(accNo));
                if (balanceMap.get(currentBalance).isEmpty()) {
                    balanceMap.remove(currentBalance);
                }

                balanceMap.putIfAbsent(newBalance, new ArrayList<>());
                balanceMap.get(newBalance).add(accNo);

                System.out.println("Withdrawal of " + amount + " successful for Account " + accNo);
            } else {
                System.out.println("Insufficient balance for Account " + accNo);
            }
        }
    }

    public void showAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<Integer>> entry : balanceMap.entrySet()) {
            double balance = entry.getKey();
            for (int accNo : entry.getValue()) {
                System.out.println("Account " + accNo + " => Balance: " + balance);
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(101, 5000);
        bank.createAccount(102, 3000);
        bank.createAccount(103, 7000);
        bank.createAccount(104, 3000);

        bank.showAccountsSortedByBalance();

        bank.addWithdrawalRequest(102, 1000);
        bank.addWithdrawalRequest(103, 8000);
        bank.addWithdrawalRequest(105, 500);
        bank.addWithdrawalRequest(101, 2000);

        System.out.println("\nProcessing Withdrawals:");
        bank.processAllWithdrawals();

        System.out.println("\nUpdated Account Balances:");
        bank.showAccountsSortedByBalance();
    }
}

