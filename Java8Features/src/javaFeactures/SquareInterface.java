package javaFeactures;

import java.util.Scanner;

@FunctionalInterface
interface Square {
    int calculate(int x);
    default void printResult(int x) {
        System.out.println("Square is: " + calculate(x));
    }
}

public class SquareInterface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        Square sq = a -> a * a;
        sq.printResult(val);
    }
}

