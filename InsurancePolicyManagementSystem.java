package collections;

import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return "Policy" + policyNumber + "\n Name: " + policyHolderName + " \n Expiry: " + expiryDate + " \n Coverage: " + coverageType + " \n Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {

    HashMap<Integer, InsurancePolicy> hashMapPolicies = new HashMap<>();
    LinkedHashMap<Integer, InsurancePolicy> linkedHashMapPolicies = new LinkedHashMap<>();
    TreeMap<LocalDate, List<InsurancePolicy>> treeMapByExpiry = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        hashMapPolicies.put(policy.policyNumber, policy);
        linkedHashMapPolicies.put(policy.policyNumber, policy);

        treeMapByExpiry.putIfAbsent(policy.expiryDate, new ArrayList<>());
        treeMapByExpiry.get(policy.expiryDate).add(policy);
    }

    public InsurancePolicy getPolicyByNumber(int policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public void listPoliciesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate in30Days = today.plusDays(30);

        System.out.println("\nPolicies expiring within next 30 days:");
        SortedMap<LocalDate, List<InsurancePolicy>> upcoming = treeMapByExpiry.subMap(today.plusDays(1), true, in30Days, true);

        for (List<InsurancePolicy> policies : upcoming.values()) {
            for (InsurancePolicy policy : policies) {
                System.out.println(policy);
            }
        }
    }

    public void listPoliciesByHolderName(String name) {
        System.out.println("\nPolicies for policyholder: " + name);
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<Integer> toRemove = new ArrayList<>();

        for (Map.Entry<Integer, InsurancePolicy> entry : hashMapPolicies.entrySet()) {
            if (entry.getValue().expiryDate.isBefore(today)) {
                toRemove.add(entry.getKey());
            }
        }

        for (int policyNumber : toRemove) {
            InsurancePolicy policy = hashMapPolicies.remove(policyNumber);
            linkedHashMapPolicies.remove(policyNumber);

            List<InsurancePolicy> list = treeMapByExpiry.get(policy.expiryDate);
            list.remove(policy);
            if (list.isEmpty()) {
                treeMapByExpiry.remove(policy.expiryDate);
            }
        }

        System.out.println("\nExpired policies removed successfully.");
    }

    public void displayAllPoliciesInsertionOrder() {
        System.out.println("\nAll policies in insertion order:");
        for (InsurancePolicy policy : linkedHashMapPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new InsurancePolicy(1001, "Alice", LocalDate.now().plusDays(15), "Health", 5000));
        system.addPolicy(new InsurancePolicy(1002, "Bob", LocalDate.now().plusDays(45), "Life", 12000));
        
        system.displayAllPoliciesInsertionOrder();

        system.listPoliciesExpiringIn30Days();

        system.listPoliciesByHolderName("Alice");

        system.removeExpiredPolicies();

        system.displayAllPoliciesInsertionOrder();
    }
}

