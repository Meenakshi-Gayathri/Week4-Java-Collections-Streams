package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(in.nextLine());
        List<String> filtered = list.stream().filter(s -> !s.startsWith("A")).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }
}

