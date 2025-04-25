package javaFeactures;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFilter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(in.nextLine());
        String substr = in.nextLine();
        Predicate<String> lengthCheck = s -> s.length() > 5;
        Predicate<String> containsCheck = s -> s.contains(substr);
        List<String> result = list.stream().filter(lengthCheck.and(containsCheck)).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}

