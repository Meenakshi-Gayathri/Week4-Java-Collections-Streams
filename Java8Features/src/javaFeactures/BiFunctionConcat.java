package javaFeactures;

import java.util.Scanner;
import java.util.function.BiFunction;

public class BiFunctionConcat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        BiFunction<String, String, String> concat = (a, b) -> a + " " + b;
        System.out.println(concat.apply(str1, str2));
    }
}

