package javaFeactures;

import java.util.*;
import java.util.stream.*;
import java.util.Optional;

public class OptionalMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++) numbers.add(in.nextInt());
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println(max.orElse(-1));
    }
}

