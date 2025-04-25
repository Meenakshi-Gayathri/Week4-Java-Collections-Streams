package javaFeactures;

import java.util.Scanner;

@FunctionalInterface
interface Sum {
    int add(int a, int b);
}

public class FunctionalInterfaceSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Sum sum = (a, b) -> a + b;
        System.out.println(sum.add(x, y));
    }
}

