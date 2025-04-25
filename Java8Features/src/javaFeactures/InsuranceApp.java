package javaFeactures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | $" + premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }
}

public class InsuranceApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<InsurancePolicy> policies = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String policyNumber = in.nextLine();
            String holderName = in.nextLine();
            double premiumAmount = in.nextDouble();
            in.nextLine();
            policies.add(new InsurancePolicy(policyNumber, holderName, premiumAmount));
        }

        // 1. Filter by Premium > 1200
        policies.stream().filter(p -> p.premiumAmount > 1200).forEach(System.out::println);

        // 2. Sort by Holder Name
        policies.stream().sorted(Comparator.comparing(p -> p.holderName)).forEach(System.out::println);

        // 3. Compute Total Premium
        double total = policies.stream().mapToDouble(p -> p.premiumAmount).sum();
        System.out.println("Total Premium: $" + total);

        // 4. Print Details
        policies.forEach(p -> System.out.println(p.toString()));

        // 5. Premium Between 1000 and 2000
        policies.stream().filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000).forEach(System.out::println);

        // 6. Policy with Highest Premium
        policies.stream().max(Comparator.comparingDouble(p -> p.premiumAmount)).ifPresent(System.out::println);

        // 7. Group by Holder Initial
        Map<Character, List<InsurancePolicy>> grouped = policies.stream().collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
        grouped.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });

        // 8. Average Premium
        double avg = policies.stream().mapToDouble(p -> p.premiumAmount).average().orElse(0);
        System.out.println("Average Premium: $" + avg);

        // 9. Sort by Premium and Print
        policies.stream().sorted(Comparator.comparingDouble(p -> p.premiumAmount)).forEach(System.out::println);

        // 10. Any Policy > $2000
        boolean anyAbove2000 = policies.stream().anyMatch(p -> p.premiumAmount > 2000);
        System.out.println("Any Policy Above $2000: " + anyAbove2000);

        // 11. Count Policies per Premium Range
        long low = policies.stream().filter(p -> p.premiumAmount <= 1000).count();
        long mid = policies.stream().filter(p -> p.premiumAmount > 1000 && p.premiumAmount <= 2000).count();
        long high = policies.stream().filter(p -> p.premiumAmount > 2000).count();
        System.out.println("$0-1000: " + low);
        System.out.println("$1001-2000: " + mid);
        System.out.println(">$2000: " + high);

        // 12. Unique Holder Names
        policies.stream().map(p -> p.holderName).distinct().forEach(System.out::println);

        // 13. Find Policies by Substring
        String substr = in.nextLine();
        policies.stream().filter(p -> p.holderName.contains(substr)).forEach(System.out::println);

        // 14. Map of Policy Numbers to Premiums
        Map<String, Double> policyMap = policies.stream().collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
        policyMap.forEach((k, v) -> System.out.println(k + " => $" + v));

        // 15. Most Frequent Words in Text Corpus
        String corpus = in.nextLine();
        int topN = in.nextInt();
        in.nextLine();
        List<String> words = Arrays.stream(corpus.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                .filter(w -> !w.isEmpty()).collect(Collectors.toList());
        Map<String, Long> wordFreq = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(topN)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 16. Second Most Frequent Word
        List<Map.Entry<String, Long>> sortedWords = new ArrayList<>(wordFreq.entrySet());
        if (sortedWords.size() >= 2) {
            sortedWords.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));
            System.out.println("Second Most Frequent: " + sortedWords.get(1).getKey() + " - " + sortedWords.get(1).getValue());
        }
    }
}
