package collections;

import java.util.*;

public class ElementFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter strings separated by space:");
        String line = sc.nextLine();
        String[] input = line.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : input) {
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }
        System.out.println("Frequency of elements:");
        for (String key : freqMap.keySet()) {
            System.out.println(key + " = " + freqMap.get(key));
        }
        sc.close();
    }
}
