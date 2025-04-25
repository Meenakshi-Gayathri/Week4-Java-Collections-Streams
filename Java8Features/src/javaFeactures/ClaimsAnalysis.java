package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}

class ClaimSummary {
    String policyNumber;
    double totalClaimAmount;
    double averageClaimAmount;

    ClaimSummary(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    public String toString() {
        return "Policy: " + policyNumber + ", Total: $" + totalClaimAmount + ", Average: $" + averageClaimAmount;
    }

    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String claimId = in.nextLine();
            String policyNumber = in.nextLine();
            double claimAmount = in.nextDouble();
            in.nextLine();
            String claimDate = in.nextLine();
            String status = in.nextLine();
            claims.add(new Claim(claimId, policyNumber, claimAmount, claimDate, status));
        }

        Map<String, List<Claim>> groupedClaims = claims.stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<ClaimSummary> summaries = groupedClaims.entrySet().stream()
                .map(e -> {
                    String policy = e.getKey();
                    List<Claim> claimList = e.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double avg = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                    return new ClaimSummary(policy, total, avg);
                })
                .sorted(Comparator.comparingDouble(ClaimSummary::getTotalClaimAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        summaries.forEach(System.out::println);
    }
}

