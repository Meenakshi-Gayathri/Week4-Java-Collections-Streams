package collections;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> original = Map.of("A", 1, "B", 2, "C", 1);
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println(inverted);
    }
}

