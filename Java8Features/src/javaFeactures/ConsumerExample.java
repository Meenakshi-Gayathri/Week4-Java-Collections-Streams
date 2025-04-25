package javaFeactures;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(in.nextLine());
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        list.forEach(printUpper);
    }
}

