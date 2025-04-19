package collections;

import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber == other.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        int dateCompare = this.expiryDate.compareTo(other.expiryDate);
        if (dateCompare != 0) return dateCompare;
        return Integer.compare(this.policyNumber, other.policyNumber);
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyHolderName + " - " + expiryDate + " - " + coverageType + " - ₹" + premiumAmount;
    }
}

public class InsuranceSystem {
    HashSet<Policy> hashSetPolicies = new HashSet<>();
    LinkedHashSet<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    TreeSet<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void showAllUniquePolicies() {
        System.out.println("\nAll Unique Policies (HashSet):");
        for (Policy p : hashSetPolicies) {
            System.out.println(p);
        }
    }

    public void showInsertionOrder() {
        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");
        for (Policy p : linkedHashSetPolicies) {
            System.out.println(p);
        }
    }

    public void showSortedByExpiry() {
        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        for (Policy p : treeSetPolicies) {
            System.out.println(p);
        }
    }

    public void policiesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        System.out.println("\nPolicies Expiring Within 30 Days:");
        for (Policy p : treeSetPolicies) {
            if (!p.expiryDate.isAfter(threshold)) {
                System.out.println(p);
            }
        }
    }

    public void policiesByCoverage(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy p : hashSetPolicies) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void findDuplicates(List<Policy> rawPolicies) {
        Set<Integer> seen = new HashSet<>();
        System.out.println("\nDuplicate Policies Based on Policy Number:");
        for (Policy p : rawPolicies) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InsuranceSystem system = new InsuranceSystem();

        List<Policy> rawInput = Arrays.asList(
            new Policy(101, "Alice", LocalDate.of(2025, 6, 10), "Health", 12000),
            new Policy(102, "Bob", LocalDate.of(2025, 5, 15), "Auto", 8000),
            new Policy(103, "Charlie", LocalDate.of(2025, 5, 5), "Home", 9000),
            new Policy(101, "Alice", LocalDate.of(2025, 6, 10), "Health", 12000),
            new Policy(104, "David", LocalDate.now().plusDays(20), "Health", 11000)
        );

        for (Policy p : rawInput) {
            system.addPolicy(p);
        }

        system.showAllUniquePolicies();
        system.showInsertionOrder();
        system.showSortedByExpiry();
        system.policiesExpiringSoon();
        system.policiesByCoverage("Health");
        system.findDuplicates(rawInput);
    }
}
