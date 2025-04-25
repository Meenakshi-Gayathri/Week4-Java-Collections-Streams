package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public String toString() {
        return "ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<PolicyHolder> holders = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String holderId = in.nextLine();
            String name = in.nextLine();
            int age = in.nextInt();
            in.nextLine();
            String policyType = in.nextLine();
            double premiumAmount = in.nextDouble();
            in.nextLine();
            holders.add(new PolicyHolder(holderId, name, age, policyType, premiumAmount));
        }

        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> h.getPolicyType().equalsIgnoreCase("Life") && h.getAge() > 60)
                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))
                .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));

        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
        });
    }
}

