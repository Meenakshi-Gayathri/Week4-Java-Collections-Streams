package javaFeactures;

import java.util.*;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++) numbers.add(in.nextInt());
        int result = numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, Integer::sum);
        System.out.println(result);
    }
}

